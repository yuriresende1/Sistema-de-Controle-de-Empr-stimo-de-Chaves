package com.example.trabalho;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BancoControllerEmprestimo {

    private SQLiteDatabase db;
    private CriaBanco_Emprestimo banco3;

    public BancoControllerEmprestimo(Context context) {
        banco3 = new CriaBanco_Emprestimo(context);
    }

    public String insereDado(String codigo, String cpf_prof, String nome_prof, String hora1, String hora2) {
        ContentValues valores;
        long resultado;

        db = banco3.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco_Emprestimo.CODIGO, codigo);
        valores.put(CriaBanco_Emprestimo.CPF_PROF, cpf_prof);
        valores.put(CriaBanco_Emprestimo.NOME_PROF, nome_prof);
        valores.put(CriaBanco_Emprestimo.HORA1, hora1);
        valores.put(CriaBanco_Emprestimo.HORA2, hora2);

        resultado = db.insert(CriaBanco_Emprestimo.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public List<String> carregaDados() {
        List<String> dados = new ArrayList<>();
        db = banco3.getReadableDatabase();

        String[] colunas = {
                CriaBanco_Emprestimo.CODIGO,
                CriaBanco_Emprestimo.CPF_PROF,
                CriaBanco_Emprestimo.NOME_PROF,
                CriaBanco_Emprestimo.HORA1,
                CriaBanco_Emprestimo.HORA2
        };

        Cursor cursor = db.query(
                CriaBanco_Emprestimo.TABELA,
                colunas,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                String codigo = cursor.getString(cursor.getColumnIndex(CriaBanco_Emprestimo.CODIGO));
                String cpfProf = cursor.getString(cursor.getColumnIndex(CriaBanco_Emprestimo.CPF_PROF));
                String nomeProf = cursor.getString(cursor.getColumnIndex(CriaBanco_Emprestimo.NOME_PROF));
                String hora1 = cursor.getString(cursor.getColumnIndex(CriaBanco_Emprestimo.HORA1));
                String hora2 = cursor.getString(cursor.getColumnIndex(CriaBanco_Emprestimo.HORA2));

                String dadosRegistro = "Código: " + codigo +
                        ", CPF: " + cpfProf +
                        ", Nome: " + nomeProf +
                        ", Hora 1: " + hora1 +
                        ", Hora 2: " + hora2;

                dados.add(dadosRegistro);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return dados;
    }

    public boolean excluiDado(int id) {
        db = banco3.getWritableDatabase();
        int excluido = db.delete(CriaBanco_Emprestimo.TABELA, "_id = ?", new String[]{String.valueOf(id)});
        db.close();
        return excluido > 0;
    }
}
