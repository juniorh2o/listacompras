package com.example.avellg1740new.listacompras;

public class Preco {
    private int lojaId;
    private int valor;

    public int getLojaId() {
        return lojaId;
    }

    public void setLojaId(int lojaId) {
        this.lojaId = lojaId;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Preco(int lojaId, int valor) {
        this.lojaId = lojaId;
        this.valor = valor;
    }
}
