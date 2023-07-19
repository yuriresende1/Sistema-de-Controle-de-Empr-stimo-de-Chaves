package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class disciplinas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);

        Button botao = (Button)findViewById(R.id.button2);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController2 crud = new BancoController2(getBaseContext());
                EditText codigo = (EditText)findViewById(R.id.codigo);
                EditText local = (EditText)findViewById((R.id.local));
                EditText cpf_prof = (EditText)findViewById(R.id.cpf_prof);
                EditText nome_prof = (EditText)findViewById(R.id.nome_prof);
                String codigoString = codigo.getText().toString();
                String localString = local.getText().toString();
                String cpf_profString = cpf_prof.getText().toString();
                String nome_profString = nome_prof.getText().toString();
                String resultado;

                resultado = crud.insereDado(codigoString,localString,cpf_profString,nome_profString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}