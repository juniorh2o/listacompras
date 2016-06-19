package com.example.avellg1740new.listacompras;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

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
        ArrayList<Loja> lojas = new ArrayList<Loja>();
        ProdutoHelper produtoHelper = new ProdutoHelper(this);
        Cursor cur = produtoHelper.getAllLoja();

        while (cur.moveToNext())
            lojas.add(new Loja(cur.getInt(0), cur.getString(1)));


        //Para cada produto
        for (Produto obj : databaseProductList) {
            //Se selecionou mais de 1
            if (obj.getAmount() > 0) {
                //Para cada preço daquele produto
                for (Preco preco : obj.getPrecoList()) {
                    //Pega a loja do preco;
                    Loja loja = lojas.get(preco.getLojaId() - 1);

                    //Pega o valor atual da compra para a loja específica
                    Integer valorAtualDaCompra = loja.getValorTotal();

                    //Adiciona o preço do produto ao preço atual da compra
                    loja.setValorTotal(valorAtualDaCompra + (preco.getValor() * obj.getAmount()));
                }
            }
        }
        Loja lojaMaisBarata = null;
        Integer precoMaisBaixo = -1;

        for (Loja loja : lojas) {
            if (loja.getValorTotal() <= precoMaisBaixo || precoMaisBaixo == -1){
                lojaMaisBarata = loja;
                precoMaisBaixo = lojaMaisBarata.getValorTotal();
            }
        }

        showResultDialog(lojaMaisBarata);
    }

    public void showResultDialog(Loja loja) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.result);
        dialog.setTitle("Resultado");

        TextView txtTitle = (TextView) dialog.findViewById(R.id.result_text_mercado);
        txtTitle.setText("Mercado: " + loja.getNome());

        txtTitle = (TextView) dialog.findViewById(R.id.result_text_valor);
        txtTitle.setText("Valor: " + formatter.format(loja.getValorTotal() / 100.00));

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