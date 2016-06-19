package com.example.avellg1740new.listacompras;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private final Activity context;
    private final List<Produto> productList;
    LayoutInflater inflater;

    public ProdutoAdapter(Activity context, List<Produto> productList) {
        super(context, R.layout.product_list, productList);
        inflater = context.getLayoutInflater();

        this.productList = productList;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.product_list, null, true);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        TextView idProd = (TextView) view.findViewById(R.id.idProd);

        NumberPicker numberPicker = (NumberPicker) view.findViewById(R.id.numberPicker);

        textView.setText(this.productList.get(position).getNome());
        numberPicker.setOnValueChangedListener(new ValueNumberPickerListener(this.productList.get(position)));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(50);
        numberPicker.setValue(this.productList.get(position).getAmount());
        return view;
    }
}