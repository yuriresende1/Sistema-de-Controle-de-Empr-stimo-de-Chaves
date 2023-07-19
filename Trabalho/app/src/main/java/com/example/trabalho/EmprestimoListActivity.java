package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

public class EmprestimoListActivity extends AppCompatActivity {

    private ListView listView;
    private BancoControllerEmprestimo bancoControllerEmprestimo;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimo_list);

        listView = findViewById(R.id.listViewEmprestimo);
        bancoControllerEmprestimo = new BancoControllerEmprestimo(this);

        final List<String> dados = bancoControllerEmprestimo.carregaDados();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = dados.get(position);
                String[] partes = itemSelecionado.split(",");
                String idString = partes[0].replace("Código: ", "").trim();
                int idEmprestimo = Integer.parseInt(idString);


                boolean excluido = bancoControllerEmprestimo.excluiDado(idEmprestimo);

                if (excluido) {
                    dados.remove(position);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
