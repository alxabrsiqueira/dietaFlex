package com.example.dietaflex;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.dietaflex.recursos.ListaAdapter;
import com.example.dietaflex.recursos.Nutricional;
import com.example.dietaflex.recursos.NutricionalBancoDados;
import com.example.dietaflex.recursos.Refeicao;
import com.example.dietaflex.recursos.RefeicoesBancoDados;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class ListarRefeicoesActivity extends AppCompatActivity {
    private RecyclerView listaDadosView;
    private ConstraintLayout layoutLista;
    private ListaAdapter listaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_refeicoes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), AdicionarAlimentoActivity.class));
            }
        });

        //*********AREA DA LISTAGEM

        List <Refeicao> lista = RefeicoesBancoDados.listarRefeicoes();

        listaDadosView = (RecyclerView) findViewById(R.id.lista_refeicoes_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listaDadosView.setHasFixedSize(true);
        listaDadosView.setLayoutManager(linearLayoutManager);
        listaAdapter = new ListaAdapter(lista);
        listaDadosView.setAdapter(listaAdapter);

        //-----Fim da area da listagem
    }
    // AREA DO MENU DO TOPO
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar,menu);

        MenuItem m1 = menu.findItem(R.id.menu_listar_refeicoes);
        m1.setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch(id){
            case R.id.menu_totais:
                startActivity(new Intent(getBaseContext(), TotaisActivity.class));
                break;
            case R.id.menu_listar_refeicoes:
                startActivity(new Intent(getBaseContext(), ListarRefeicoesActivity.class));
                break;
            case R.id.menu_configurar_metas:
                startActivity(new Intent(getBaseContext(), MetasActivity.class));
                break;
            case R.id.menu_sobre_nos:
                startActivity(new Intent(getBaseContext(), SobreNosActivity.class));
                break;
            case R.id.menu_adicionar_refeicao:
                startActivity(new Intent(getBaseContext(), AdicionarAlimentoActivity.class));
                break;
            case R.id.menu_fechar:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Deseja realmente sair?")
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finishAffinity();
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
// FIM DO MENU DO TOPO
}
