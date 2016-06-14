package com.example.avellg1740new.listacompras;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by amand on 06/06/2016.
 */
public class ProdutoHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ListaCompras.db";
    private static final int DATABASE_VERSION = 1;

    public ProdutoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table loja ("
                + "_id integer primary key autoincrement, "
                + "nome text);");

        db.execSQL("create table produto ("
                + "_id integer primary key autoincrement, "
                + "nome text);");

        db.execSQL("create table preco ("
                + "_id integer primary key autoincrement, "
                + "valor integer,"
                + "idLoja text,"
                + "idProduto integer );");

        db.execSQL("INSERT INTO loja (nome) VALUES ('Big');"
                + "INSERT INTO loja (nome) VALUES ('Fort Atacadista');"
                + "INSERT INTO loja (nome) VALUES ('Angeloni');"
                + "INSERT INTO loja (nome) VALUES ('Giassi');");

        db.execSQL("INSERT INTO produto (nome) VALUES ('Nescau');"
                + "INSERT INTO produto (nome) VALUES ('Leite');"
                + "INSERT INTO produto (nome) VALUES ('Café');"
                + "INSERT INTO produto (nome) VALUES ('Bolacha');"
                + "INSERT INTO produto (nome) VALUES ('Sabonete');"
                + "INSERT INTO produto (nome) VALUES ('Cerveja');"
                + "INSERT INTO produto (nome) VALUES ('Refrigerante');"
                + "INSERT INTO produto (nome) VALUES ('Água');"
                + "INSERT INTO produto (nome) VALUES ('Vinho');"
                + "INSERT INTO produto (nome) VALUES ('Macarrão');");

        db.execSQL("INSERT INTO preco (valor, idLoja, idProduto) VALUES (390, 1, 1);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (350, 2, 1);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (400, 3, 1);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (430, 4, 1);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (120, 1, 2);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (100, 2, 2);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (140, 3, 2);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (110, 4, 2);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (500, 1, 3);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (490, 2, 3);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (550, 3, 3);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (510, 4, 3);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (110, 1, 4);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (120, 2, 4);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (090, 3, 4);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (110, 4, 4);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (070, 1, 5);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (060, 2, 5);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (100, 3, 5);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (080, 4, 5);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (115, 1, 6);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (100, 2, 6);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (130, 3, 6);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (178, 4, 6);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (390, 1, 7);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (400, 2, 7);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (380, 3, 7);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (370, 4, 7);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (090, 1, 8);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (100, 2, 8);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (110, 3, 8);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (070, 4, 8);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (1200, 1, 9);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (1500, 2, 9);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (2100, 3, 9);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (1900, 4, 9);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (580, 1, 10);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (400, 2, 10);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (300, 3, 10);"
                + "INSERT INTO preco (valor, idLoja, idProduto) VALUES (440, 4, 10);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor getAll() {
        String selectQuery = "SELECT prod.nome as nomeProd, loja.nome as nomeLoja, preco.valor as valor "
                + " FROM preco"
                + " INNER JOIN produto prod ON prod._id = preco.idProduto"
                + " INNER JOIN loja loja ON loja._id = preco.idLoja"
                + " ORDER BY nomeProd, nomeLoja ";
        Cursor cursor = getReadableDatabase().rawQuery(selectQuery, null);
        return cursor;
    }
}
