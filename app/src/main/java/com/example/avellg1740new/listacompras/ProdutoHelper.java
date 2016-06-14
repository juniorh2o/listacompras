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
                + "nome text)");

        db.execSQL("create table produto ("
                + "_id integer primary key autoincrement, "
                + "nome text)");

        db.execSQL("create table preco ("
                + "_id integer primary key autoincrement, "
                + "valor integer,"
                + "idLoja text,"
                + "idProduto integer )");

        db.execSQL("insert into loja (nome) values ('Big')"
                + "insert into loja (nome) values ('Fort Atacadista')"
                + "insert into loja (nome) values ('Angeloni')"
                + "insert into loja (nome) values ('Giassi')");

        db.execSQL("insert into produto (nome) values ('Nescau')"
                + "insert into produto (nome) values ('Leite')"
                + "insert into produto (nome) values ('Café')"
                + "insert into produto (nome) values ('Bolacha')"
                + "insert into produto (nome) values ('Sabonete')"
                + "insert into produto (nome) values ('Cerveja')"
                + "insert into produto (nome) values ('Refrigerante')"
                + "insert into produto (nome) values ('Água')"
                + "insert into produto (nome) values ('Vinho')"
                + "insert into produto (nome) values ('Macarrão')");

        db.execSQL("insert into preco (valor, idLoja, idProduto) values (390, 1, 1);"
                + "insert into preco (valor, idLoja, idProduto) values (350, 2, 1);"
                + "insert into preco (valor, idLoja, idProduto) values (400, 3, 1);"
                + "insert into preco (valor, idLoja, idProduto) values (430, 4, 1);"
                + "insert into preco (valor, idLoja, idProduto) values (120, 1, 2);"
                + "insert into preco (valor, idLoja, idProduto) values (100, 2, 2);"
                + "insert into preco (valor, idLoja, idProduto) values (140, 3, 2);"
                + "insert into preco (valor, idLoja, idProduto) values (110, 4, 2);"
                + "insert into preco (valor, idLoja, idProduto) values (500, 1, 3);"
                + "insert into preco (valor, idLoja, idProduto) values (490, 2, 3);"
                + "insert into preco (valor, idLoja, idProduto) values (550, 3, 3);"
                + "insert into preco (valor, idLoja, idProduto) values (510, 4, 3);"
                + "insert into preco (valor, idLoja, idProduto) values (110, 1, 4);"
                + "insert into preco (valor, idLoja, idProduto) values (120, 2, 4);"
                + "insert into preco (valor, idLoja, idProduto) values (090, 3, 4);"
                + "insert into preco (valor, idLoja, idProduto) values (110, 4, 4);"
                + "insert into preco (valor, idLoja, idProduto) values (070, 1, 5);"
                + "insert into preco (valor, idLoja, idProduto) values (060, 2, 5);"
                + "insert into preco (valor, idLoja, idProduto) values (100, 3, 5);"
                + "insert into preco (valor, idLoja, idProduto) values (080, 4, 5);"
                + "insert into preco (valor, idLoja, idProduto) values (115, 1, 6);"
                + "insert into preco (valor, idLoja, idProduto) values (100, 2, 6);"
                + "insert into preco (valor, idLoja, idProduto) values (130, 3, 6);"
                + "insert into preco (valor, idLoja, idProduto) values (178, 4, 6);"
                + "insert into preco (valor, idLoja, idProduto) values (390, 1, 7);"
                + "insert into preco (valor, idLoja, idProduto) values (400, 2, 7);"
                + "insert into preco (valor, idLoja, idProduto) values (380, 3, 7);"
                + "insert into preco (valor, idLoja, idProduto) values (370, 4, 7);"
                + "insert into preco (valor, idLoja, idProduto) values (090, 1, 8);"
                + "insert into preco (valor, idLoja, idProduto) values (100, 2, 8);"
                + "insert into preco (valor, idLoja, idProduto) values (110, 3, 8);"
                + "insert into preco (valor, idLoja, idProduto) values (070, 4, 8);"
                + "insert into preco (valor, idLoja, idProduto) values (1200, 1, 9);"
                + "insert into preco (valor, idLoja, idProduto) values (1500, 2, 9);"
                + "insert into preco (valor, idLoja, idProduto) values (2100, 3, 9);"
                + "insert into preco (valor, idLoja, idProduto) values (1900, 4, 9);"
                + "insert into preco (valor, idLoja, idProduto) values (580, 1, 10);"
                + "insert into preco (valor, idLoja, idProduto) values (400, 2, 10);"
                + "insert into preco (valor, idLoja, idProduto) values (300, 3, 10);"
                + "insert into preco (valor, idLoja, idProduto) values (440, 4, 10);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor getAll() {
        String selectQuery = "SELECT prod.nome as nomeProd, loja.name as nomeLoja, preco.valor as valor "
                + "FROM preco"
                + "INNER JOIN produto prod ON prod.id = preco.idProduto"
                + "INNER JOIN loja loja ON loja.id = preco.idLoja"
                + " ORDER BY nomeProd, nomeLoja ";
        Cursor cursor = getReadableDatabase().rawQuery(selectQuery, null);
        return cursor;
    }
}
