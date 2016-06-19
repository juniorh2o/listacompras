package com.example.avellg1740new.listacompras;

public class Loja {
    private int id;
    private String nome;
    private int valorTotal = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valor) {
        this.valorTotal = valor;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Loja(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
