package com.example.trabalho;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class Criabanco extends SQLiteOpenHelper {

    public static final String ID = "_id";
    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "professores";
    public static final String NOME = "nome";
    public static final String CPF = "cpf";
    private static final int VERSAO = 1;

    public Criabanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + CPF + " text"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }
}


