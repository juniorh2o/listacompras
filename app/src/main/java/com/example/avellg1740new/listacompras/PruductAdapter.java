package com.example.avellg1740new.listacompras;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;
import java.util.List;

public class PruductAdapter extends ArrayAdapter<Produto> {

    private final Activity context;
    private final List<Produto> productList;

    public PruductAdapter(Activity context, List<Produto> productList) {
        //Para criar a List precisa dos nomes dos produtos, portanto é feita a extração de dados do JSON para String[] apenas com os nomes.
        super(context, R.layout.product_list, productList);

        this.productList = productList;
        this.context=context;
    }

    public View getView(int position,View view,ViewGroup parent) {

        /* Não sei o que isto está fazendo - INICIO*/
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.product_list, null,true);
        /* Não sei o que isto está fazendo - FIM */

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView);

        //Pegará da lista de objetos, existente somente após os dados do banco
        txtTitle.setText(this.productList.get(position).getNome());

        TextView txtIdProd = (TextView) rowView.findViewById(R.id.idProd);

        txtIdProd.setText("" + this.productList.get(position).getId());

        NumberPicker numberPicker = (NumberPicker) rowView.findViewById(R.id.numberPicker);

        numberPicker.setMaxValue(50);
        numberPicker.setMinValue(0);

        return rowView;
    };
}
