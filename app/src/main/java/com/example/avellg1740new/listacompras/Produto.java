package com.example.avellg1740new.listacompras;

import java.util.ArrayList;

public class Produto {

    private int id;
    private String nome;
    private ArrayList<Preco> preco;
    public Integer amount = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto(int id, String nome, ArrayList<Preco> preco) {
        this.preco = preco;
        this.id = id;
        this.nome = nome;
    }

    public ArrayList<Preco> getPrecoList() {
        return this.preco;
    }
}
