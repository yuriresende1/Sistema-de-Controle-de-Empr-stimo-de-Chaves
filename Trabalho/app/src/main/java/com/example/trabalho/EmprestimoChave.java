package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmprestimoChave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimo_chave);

        Button botao = (Button)findViewById(R.id.button3);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoControllerEmprestimo crud = new BancoControllerEmprestimo(getBaseContext());
                EditText codigo = (EditText)findViewById(R.id.codigo);
                EditText cpf_prof = (EditText)findViewById((R.id.cpf_prof));
                EditText nome_prof = (EditText)findViewById((R.id.nome_prof));
                EditText horario_1 = (EditText)findViewById((R.id.horario_1));
                EditText horario_2 = (EditText)findViewById((R.id.horario_2));
                String codigoString = codigo.getText().toString();
                String cpf_profString = cpf_prof.getText().toString();
                String nome_profString = nome_prof.getText().toString();
                String horario_1String = horario_1.getText().toString();
                String horario_2String = horario_2.getText().toString();
                String resultado;

                resultado = crud.insereDado(codigoString,cpf_profString,nome_profString,horario_1String,horario_2String);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}