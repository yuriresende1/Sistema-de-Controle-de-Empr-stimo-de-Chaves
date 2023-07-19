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

public class ProfessorListActivity extends AppCompatActivity {

    private ListView listView;
    private BancoController bancoController;
    private ProfessorListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_list);

        listView = findViewById(R.id.listViewProfessores);
        bancoController = new BancoController(this);

        final List<String> dados = bancoController.carregaDados();

        adapter = new ProfessorListAdapter(dados);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = dados.get(position);
                String[] partes = itemSelecionado.split(",");
                String idString = partes[0].replace("ID: ", "").trim();
                int idProfessor = Integer.parseInt(idString);


                boolean excluido = bancoController.excluiDado(idProfessor);

                if (excluido) {
                    atualizarLista();
                }
            }
        });
    }

    private void atualizarLista() {
        List<String> dados = bancoController.carregaDados();
        adapter.clear();
        adapter.addAll(dados);
        adapter.notifyDataSetChanged();
    }

    private class ProfessorListAdapter extends ArrayAdapter<String> {

        private List<String> professorList;

        public ProfessorListAdapter(List<String> professorList) {
            super(ProfessorListActivity.this, R.layout.item_professor, professorList);
            this.professorList = professorList;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View itemView = convertView;

            if (itemView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                itemView = inflater.inflate(R.layout.item_professor, parent, false);
            }

            String professor = professorList.get(position);

            TextView textViewProfessor = itemView.findViewById(R.id.textViewProfessor);
            textViewProfessor.setText(professor);

            Button buttonExcluir = itemView.findViewById(R.id.buttonExcluir);
            buttonExcluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String itemSelecionado = professorList.get(position);
                    String[] partes = itemSelecionado.split(",");
                    String idString = partes[0].replace("ID: ", "").trim();
                    int idProfessor = Integer.parseInt(idString);

                    // Chamar o método para excluir o professor pelo ID
                    boolean excluido = bancoController.excluiDado(idProfessor);

                    if (excluido) {
                        atualizarLista();
                    }
                }
            });

            return itemView;
        }
    }
}
