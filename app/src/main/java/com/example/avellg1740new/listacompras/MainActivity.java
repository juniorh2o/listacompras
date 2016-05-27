package com.example.avellg1740new.listacompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pega dados do banco
        ArrayList<Produto> databaseProductList = getDatabaseProductList();

        //Cria instância do adapter customizado para a lista de produtos
        PruductAdapter productAdapter = new
                PruductAdapter(this, databaseProductList);


        //Pega instância da mainList
        ListView mainList = (ListView) findViewById(R.id.listView);

        //Adequa o adapter à mainList
        mainList.setAdapter(productAdapter);
    }

    //Realiza consulta no banco e retorna os dados em formato JSON conforme explicado acima.
    protected ArrayList<Produto> getDatabaseProductList() {
        Produto prod;
        ArrayList<Preco> precos;

        //Conecta com o banco

        //Cria JSON baseado na consulta
        ArrayList<Produto> jsonObject = new ArrayList<Produto>();

        precos = new ArrayList<Preco>();
        precos.add(new Preco(1, 200));
        precos.add(new Preco(2, 250));

        prod = new Produto(1, "caixa de leite", precos);
        jsonObject.add(prod);

        precos = new ArrayList<Preco>();
        precos.add(new Preco(1, 500));
        precos.add(new Preco(2, 550));

        prod = new Produto(2, "Caixa de fósforo", precos);
        jsonObject.add(prod);

        return jsonObject;
    }

    public void calcular(View view) {

        ArrayList<Integer> ListIdProd = new ArrayList<Integer>();

        ListView mainList = (ListView) findViewById(R.id.listView);
        int j = mainList.getChildCount();
        for (int i = 0; i < j; i++) {
            View view1 = mainList.getChildAt(i);

            if (view1 instanceof RelativeLayout) {
                TextView txtidProd = (TextView) view1.findViewById(R.id.idProd);

                NumberPicker numberPicker = (NumberPicker) view1.findViewById(R.id.numberPicker);
                int num = numberPicker.getValue();


                ListIdProd.add(Integer.parseInt(txtidProd.getText().toString()));
            }
        }

        Log.d("Teste", ListIdProd.get(0).toString());
        Log.d("Teste", ListIdProd.get(1).toString());
    }
}

