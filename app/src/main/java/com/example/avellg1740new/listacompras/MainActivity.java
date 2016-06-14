package com.example.avellg1740new.listacompras;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    /*
    * Lista de produtos:
    * Esoerado JSON no formato
    *
    * JSONObject produto {
    *   id: 01
    *   nome: Tesoura,
    *   preço:{
    *       01: 1000,  //R% 10,00
    *       02: 1500   //R$ 15,00
    *       ...
    *   }
    *
    *   Sendo os ID's no preço, o ID de cada mercado que contém tal produto.
    * JSONObject loja {
    *       01:"BIG",
    *       02:"Angelloni",
    *       03:"Giassi",
    *       04:"Santa Rosa"
    *       ...
    *   }
    * */

    ArrayList<Produto> databaseProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pega dados do banco
        databaseProductList = getDatabaseProductList();

        //Cria instância do adapter customizado para a lista de produtos
        ProdutoAdapter produtoAdapter = new
                ProdutoAdapter(this, databaseProductList);


        //Pega instância da mainList
        ListView mainList = (ListView) findViewById(R.id.listView);

        //Adequa o adapter à mainList
        mainList.setAdapter(produtoAdapter);
    }

    //Realiza consulta no banco e retorna os dados em formato JSON conforme explicado acima.
    protected ArrayList<Produto> getDatabaseProductList() {
        ArrayList<Produto> jsonObject = new ArrayList<Produto>();
        Produto prod;
        ArrayList<Preco> precos;

        //Conecta com o banco
        ProdutoHelper produtoHelper = new ProdutoHelper(this);
        Cursor cur = produtoHelper.getAll();
        while (cur.moveToNext()) {
            //Constrói os objetos

            //Exemplo de como deve criar um objeto!
            precos = new ArrayList<Preco>();
            precos.add(new Preco(1, 200));
            precos.add(new Preco(2, 250));

            prod = new Produto(1, "caixa de leite", precos);
            jsonObject.add(prod);
        }


        return jsonObject;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Parceiros");

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.fragment_partner);
        dialog.setTitle("Parceiros");

        dialog.show();

        return true;
    }

    public void calcular(View view) {
        HashMap<Integer, Integer> prodList = new HashMap<Integer, Integer>();

        //Pega os valores da tela
        ListView mainList = (ListView) findViewById(R.id.listView);
        int j = mainList.getChildCount();
        for (int i = 0; i < j; i++) {
            View view1 = mainList.getChildAt(i);

            if (view1 instanceof RelativeLayout) {
                TextView txtidProd = (TextView) view1.findViewById(R.id.idProd);

                NumberPicker numberPicker = (NumberPicker) view1.findViewById(R.id.numberPicker);
                int num = numberPicker.getValue();


                prodList.put(Integer.parseInt(txtidProd.getText().toString()), num);
            }
        }

        Iterator i = prodList.entrySet().iterator();

        //Passa produto a produto para calcular
        while (i.hasNext()) {
            Map.Entry prod = (Map.Entry) i.next();
            Log.d("Object key: ", prod.getKey().toString());
            Log.d("Object value: ", prod.getValue().toString());
        }

        showResultDialog("Angeloni", 1450);
    }

    public void showResultDialog(String mercado, Integer valor) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.result);
        dialog.setTitle("Resultado");

        TextView txtTitle = (TextView) dialog.findViewById(R.id.result_text_mercado);
        txtTitle.setText("Mercado: " + mercado);

        txtTitle = (TextView) dialog.findViewById(R.id.result_text_valor);
        txtTitle.setText("Valor: " + formatter.format(valor / 100.00));

        Button dialogButton = (Button) dialog.findViewById(R.id.result_button);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}

