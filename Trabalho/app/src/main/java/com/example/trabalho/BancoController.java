package com.example.trabalho;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class BancoController {

    private SQLiteDatabase db;
    private Criabanco banco;

    public BancoController(Context context){
        banco = new Criabanco(context);
    }

    public String insereDado(String nome, String cpf){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(Criabanco.NOME, nome);
        valores.put(Criabanco.CPF, cpf);

        resultado = db.insert(Criabanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public List<String> carregaDados() {
        List<String> dados = new ArrayList<>();

        db = banco.getReadableDatabase();
        String[] campos = {Criabanco.ID, Criabanco.NOME, Criabanco.CPF};

        Cursor cursor = db.query(Criabanco.TABELA, campos, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(Criabanco.ID));
                String nome = cursor.getString(cursor.getColumnIndex(Criabanco.NOME));
                String cpf = cursor.getString(cursor.getColumnIndex(Criabanco.CPF));

                String dado = "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf;
                dados.add(dado);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return dados;
    }

    public boolean excluiDado(int id) {
        db = banco.getWritableDatabase();
        int linhasAfetadas = db.delete(Criabanco.TABELA, Criabanco.ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return linhasAfetadas > 0;
    }


}
