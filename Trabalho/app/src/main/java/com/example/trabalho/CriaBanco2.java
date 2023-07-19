package com.example.trabalho;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco2 extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco2.db";
    public static final String TABELA = "disciplinas";
    public static final String ID = "_id";
    public static final String CODIGO = "codigo";
    public static final String LOCAL = "local";
    public static final String CPF_PROF = "cpf_prof";
    public static final String NOME_PROF = "nome_prof";
    private static final int VERSAO = 1;

    public CriaBanco2(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + CODIGO + " text,"
                + LOCAL + " text,"
                + CPF_PROF + " text,"
                + NOME_PROF + " text"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }
}
