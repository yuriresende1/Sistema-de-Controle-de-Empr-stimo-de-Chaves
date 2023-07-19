package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private Button botao2;
    private Button botao3;
    private Button botao4;
    private Button botaoListarDisciplinas;
    private Button botaoEmprestimos;
    private TextView textView;
    private BancoController bancoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.bt_professor);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, professor.class);
                startActivity(in);
            }
        });

        botao2 = findViewById(R.id.bt_disciplina);

        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, disciplinas.class);
                startActivity(in);
            }
        });

        botao3 = findViewById(R.id.bt_emprestimo);

        botao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, EmprestimoChave.class);
                startActivity(in);
            }
        });

        botao4 = findViewById(R.id.bt_professores);
        botaoListarDisciplinas = findViewById(R.id.bt_listar_disciplinas);
        botaoEmprestimos = findViewById(R.id.bt_emprestimos);
        textView = findViewById(R.id.textViewProfessores);
        bancoController = new BancoController(MainActivity.this);

        botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfessorListActivity.class);
                startActivity(intent);
            }
        });

        botaoListarDisciplinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisciplinaListActivity.class);
                startActivity(intent);
            }
        });

        botaoEmprestimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmprestimoListActivity.class);
                startActivity(intent);
            }
        });
    }
}
