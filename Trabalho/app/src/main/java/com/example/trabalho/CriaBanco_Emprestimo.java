package com.example.trabalho;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco_Emprestimo extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco3.db";
    public static final String TABELA = "emprestimo";
    private static final String ID = "_id";
    public static final String CODIGO = "codigo";
    public static final String CPF_PROF = "cpf_prof";
    public static final String NOME_PROF = "nome_prof";
    public static final String HORA1 = "hora1";
    public static final String HORA2 = "hora2";
    private static final int VERSAO = 1;

    public CriaBanco_Emprestimo(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CODIGO + " TEXT,"
                + CPF_PROF + " TEXT,"
                + NOME_PROF + " TEXT,"
                + HORA1 + " TEXT,"
                + HORA2 + " TEXT"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
