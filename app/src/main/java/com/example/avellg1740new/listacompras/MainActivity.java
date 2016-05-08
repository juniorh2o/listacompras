package com.example.avellg1740new.listacompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    /*
    * Lista de produtos:
    * Esoerado JSON no formato
    *
    * JSONObject produto {
    *   id: 01
    *   nome: Tesoura
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
        JSONObject databaseProductList = getDatabaseProductList();

        //Cria instância do adapter customizado para a lista de produtos
        PruductAdapter productAdapter=new
                PruductAdapter (this,databaseProductList);


        //Pega instância da mainList
        ListView mainList =(ListView) findViewById(R.id.listView);

        //Adequa o adapter à mainList
        mainList.setAdapter(productAdapter);
    }


    //Realiza consulta no banco e retorna os dados em formato JSON conforme explicado acima.
    protected JSONObject getDatabaseProductList(){
        //Conecta com o banco

        //Cria JSON baseado na consulta
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }
}
