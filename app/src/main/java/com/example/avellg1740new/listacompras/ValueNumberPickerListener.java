package com.example.avellg1740new.listacompras;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class ValueNumberPickerListener implements OnValueChangeListener {

    Produto prod;

    public ValueNumberPickerListener(Produto prod) {
        super();
        this.prod = prod;
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        this.prod.setAmount(i1);
    }
}
