package com.example.trabalho;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BancoController2 {

    private SQLiteDatabase db;
    private CriaBanco2 banco2;

    public BancoController2(Context context) {
        banco2 = new CriaBanco2(context);
    }

    public String insereDado(String codigo, String local, String cpf_prof, String nome_prof) {
        ContentValues valores = new ContentValues();
        long resultado;

        db = banco2.getWritableDatabase();
        valores.put(CriaBanco2.CODIGO, codigo);
        valores.put(CriaBanco2.LOCAL, local);
        valores.put(CriaBanco2.CPF_PROF, cpf_prof);
        valores.put(CriaBanco2.NOME_PROF, nome_prof);

        resultado = db.insert(CriaBanco2.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public List<String> carregaDados() {
        List<String> dados = new ArrayList<>();

        db = banco2.getReadableDatabase();
        String[] colunas = {CriaBanco2.ID, CriaBanco2.CODIGO, CriaBanco2.LOCAL, CriaBanco2.CPF_PROF, CriaBanco2.NOME_PROF};
        Cursor cursor = db.query(CriaBanco2.TABELA, colunas, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(CriaBanco2.ID));
                String codigo = cursor.getString(cursor.getColumnIndex(CriaBanco2.CODIGO));
                String local = cursor.getString(cursor.getColumnIndex(CriaBanco2.LOCAL));
                String cpf_prof = cursor.getString(cursor.getColumnIndex(CriaBanco2.CPF_PROF));
                String nome_prof = cursor.getString(cursor.getColumnIndex(CriaBanco2.NOME_PROF));

                String dado = "ID: " + id + ", Código: " + codigo + ", Local: " + local + ", CPF: " + cpf_prof + ", Nome: " + nome_prof;
                dados.add(dado);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return dados;
    }

    public boolean excluiDado(int id) {
        db = banco2.getWritableDatabase();
        int linhasAfetadas = db.delete(CriaBanco2.TABELA, CriaBanco2.ID + "=?", new String[]{String.valueOf(id)});
        db.close();

        return linhasAfetadas > 0;
    }
}
