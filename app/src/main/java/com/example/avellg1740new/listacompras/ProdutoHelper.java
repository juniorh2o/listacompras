package com.example.avellg1740new.listacompras;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProdutoHelper extends SQLiteOpenHelper {
    /*
    * Lista de produtos:
    * Esoerado JSON no formato
    *
    * JSONObject produto {
    *   id: 01
    *   nome: Tesoura,
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

    private static final String DATABASE_NAME = "ListaCompras2.db";
    private static final int DATABASE_VERSION = 1;

    public ProdutoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table loja (_id integer primary key autoincrement, nome text);");
        db.execSQL("create table produto (_id integer primary key autoincrement, nome text);");
        db.execSQL("create table preco (_id integer primary key autoincrement, valor integer, idLoja integer, idProduto integer);");

        db.execSQL("INSERT INTO loja (nome) VALUES ('Big');");
        db.execSQL("INSERT INTO loja (nome) VALUES ('Fort Atacadista');");
        db.execSQL("INSERT INTO loja (nome) VALUES ('Angeloni');");
        db.execSQL("INSERT INTO loja (nome) VALUES ('Giassi');");

        db.execSQL("INSERT INTO produto (nome) VALUES ('Nescau');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Leite');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Café');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Bolacha');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Sabonete');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Cerveja');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Refrigerante');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Água');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Vinho');");
        db.execSQL("INSERT INTO produto (nome) VALUES ('Macarrão');");

        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (390, 1, 1);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (350, 2, 1);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (400, 3, 1);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (430, 4, 1);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (120, 1, 2);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (100, 2, 2);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (140, 3, 2);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (110, 4, 2);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (500, 1, 3);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (490, 2, 3);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (550, 3, 3);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (510, 4, 3);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (110, 1, 4);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (120, 2, 4);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (090, 3, 4);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (110, 4, 4);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (070, 1, 5);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (060, 2, 5);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (100, 3, 5);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (080, 4, 5);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (115, 1, 6);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (100, 2, 6);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (130, 3, 6);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (178, 4, 6);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (390, 1, 7);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (400, 2, 7);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (380, 3, 7);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (370, 4, 7);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (090, 1, 8);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (100, 2, 8);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (110, 3, 8);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (070, 4, 8);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (1200, 1, 9);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (1500, 2, 9);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (2100, 3, 9);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (1900, 4, 9);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (580, 1, 10);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (400, 2, 10);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (300, 3, 10);");
        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (440, 4, 10);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor getAllProduto() {
        try {
            String selectQuery = " SELECT _id,nome FROM produto";
            return getReadableDatabase().rawQuery(selectQuery, null);
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

    public Cursor getAllLoja() {
        try {
            String selectQuery = " SELECT _id,nome FROM loja";
            return getReadableDatabase().rawQuery(selectQuery, null);
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

    public Cursor getAllPreco(int idProduto) {
        try {
            String selectQuery = " SELECT idLoja,valor FROM preco WHERE idProduto = " + idProduto;
            return getReadableDatabase().rawQuery(selectQuery, null);
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }
}
