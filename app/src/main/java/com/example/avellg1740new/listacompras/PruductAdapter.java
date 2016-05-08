package com.example.avellg1740new.listacompras;
    import android.app.Activity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.TextView;
    import org.json.JSONObject;

public class PruductAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final JSONObject productList;

    //Poderá ser excluido quando existirem dados do banco
    private String[] productNameListFromJSON={"Pão","Batata","Cenoura","Couve-flor","Cereal","Fígado","Macarrão","Talheres","Pano de prato"};

    public PruductAdapter(Activity context, JSONObject productList) {
        //Para criar a List precisa dos nomes dos produtos, portanto é feita a extração de dados do JSON para String[] apenas com os nomes.
        super(context, R.layout.product_list, PruductAdapter.getProductNameListFromJSON(productList));

        this.productList = productList;
        this.context=context;
    }

    //Retorna apenas os nomes dos produtos da lista de produtos para que se possa criar a listView
    private static String[] getProductNameListFromJSON(JSONObject productList){

        String[] productNameListFromJSON={"Pão","Batata","Cenoura","Couve-flor","Cereal","Fígado","Macarrão","Talheres","Pano de prato"};

        return productNameListFromJSON;
    };

    public View getView(int position,View view,ViewGroup parent) {

        /* Não sei o que isto está fazendo - INICIO*/
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.product_list, null,true);
        /* Não sei o que isto está fazendo - FIM */


        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView);

        //Pegará da lista de objetos, existente somente após os dados do banco
        //txtTitle.setText(this.productList[position]);

        //Poderá ser excluido quando existirem dados do banco
        txtTitle.setText(this.productNameListFromJSON[position]);

        return rowView;
    };
}
