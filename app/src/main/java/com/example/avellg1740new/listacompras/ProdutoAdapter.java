package com.example.avellg1740new.listacompras;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private final Activity context;
    private final List<Produto> productList;
    private final ArrayList<Integer> numberPickerValueList;
    LayoutInflater inflater;

    public ProdutoAdapter(Activity context, List<Produto> productList) {
        super(context, R.layout.product_list, productList);
        inflater = context.getLayoutInflater();
        numberPickerValueList = new ArrayList<Integer>();

        this.productList = productList;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        ClassOla productOBj;
        if (view == null) {

            view = inflater.inflate(R.layout.product_list, null, true);
            productOBj = new ClassOla();
            productOBj.textView = (TextView) view.findViewById(R.id.textView);
            productOBj.idProd = (TextView) view.findViewById(R.id.idProd);

            productOBj.numberPicker = (NumberPicker) view.findViewById(R.id.numberPicker);
            view.setTag(productOBj);
        } else {
            productOBj = (ClassOla) view.getTag();
        }

        productOBj.textView.setText(this.productList.get(position).getNome());

        numberPickerValueList

        productOBj.numberPicker.setOnValueChangedListener( new ValueNumberPickerListener);
        productOBj.numberPicker.setMinValue(0);
        productOBj.numberPicker.setMaxValue(50);
        return view;
    }
}