package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class DisciplinaListActivity extends AppCompatActivity {

    private ListView listView;
    private BancoController2 bancoController2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina_list);

        listView = findViewById(R.id.listViewDisciplinas);
        bancoController2 = new BancoController2(this);

        final List<String> dados = bancoController2.carregaDados();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_disciplina, R.id.textViewDisciplina, dados) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Button buttonExcluir = view.findViewById(R.id.buttonExcluir);
                buttonExcluir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String itemSelecionado = dados.get(position);
                        String[] partes = itemSelecionado.split(",");
                        String idString = partes[0].replace("ID: ", "").trim();
                        int idDisciplina = Integer.parseInt(idString);


                        boolean excluido = bancoController2.excluiDado(idDisciplina);

                        if (excluido) {
                            atualizarLista();
                        }
                    }
                });
                return view;
            }
        };
        listView.setAdapter(adapter);
    }

    private void atualizarLista() {
        List<String> dados = bancoController2.carregaDados();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_disciplina, R.id.textViewDisciplina, dados);
        listView.setAdapter(adapter);
    }
}
