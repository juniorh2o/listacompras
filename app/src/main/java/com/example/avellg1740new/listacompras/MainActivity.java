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
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ArrayList<Produto> databaseProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pega dados do banco
        databaseProductList = getDatabaseProductList();

        //Cria instância do adapter customizado para a lista de produtos
        ProdutoAdapter produtoAdapter = new ProdutoAdapter(this, databaseProductList);

        //Pega instância da mainList
        ListView mainList = (ListView) findViewById(R.id.listView);

        //Adequa o adapter à mainList
        mainList.setAdapter(produtoAdapter);
    }

    //Realiza consulta no banco e retorna os dados em formato JSON conforme explicado acima.
    protected ArrayList<Produto> getDatabaseProductList() {
        ArrayList<Produto> jsonObject = new ArrayList<Produto>();
        Produto prod;
        ArrayList<Preco> precos = new ArrayList<Preco>();

        //Conecta com o banco
        ProdutoHelper produtoHelper = new ProdutoHelper(this);
        Cursor cur = produtoHelper.getAllProduto();

        //Iterate sobre os produtos
        while (cur.moveToNext()) {
            precos = new ArrayList<Preco>();
            //Iterate sobre os preços do produto iterado
            Cursor cur2 = produtoHelper.getAllPreco(cur.getInt(0));
            while (cur2.moveToNext()) {
                precos.add(new Preco(cur2.getInt(0), cur2.getInt(1)));
            }

            prod = new Produto(cur.getInt(0), cur.getString(1), precos);

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
        for (Produto obj : databaseProductList) {
            Log.d("Object id: ", "" + obj.getId());
            Log.d("Object name: ", "" + obj.getNome());
            Log.d("Object amount: ", "" + obj.getAmount());
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