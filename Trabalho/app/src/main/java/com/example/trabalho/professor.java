package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class professor extends AppCompatActivity {

    private Button bt_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText)findViewById(R.id.codigo);
                EditText cpf = (EditText)findViewById((R.id.editText2));
                String nomeString = nome.getText().toString();
                String cpfString = cpf.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString,cpfString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


            }
        });
    }
}