package com.example.dietaflex;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.dietaflex.recursos.Nutricional;
import com.example.dietaflex.recursos.NutricionalBancoDados;
import com.example.dietaflex.recursos.Refeicao;
import com.example.dietaflex.recursos.RefeicoesBancoDados;

import java.util.ArrayList;
import java.util.List;

public class AdicionarAlimentoActivity extends AppCompatActivity {
    String[] Countries = { "India", "USA", "Australia", "UK", "Italy", "Ireland", "Abfrica" , "UuSA", "Ausstralia", "UfK", "Iytaly", "Isreland", "Asfrica" };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_alimento);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //*********PARTE DO AUTO COMPLETE





        ArrayAdapter<Nutricional> adapter = new ArrayAdapter<Nutricional>(this,
                android.R.layout.simple_dropdown_item_1line,  NutricionalBancoDados.listarAlimentos());
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.campo_nome_alimento);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Nutricional selected = (Nutricional) parent.getAdapter().getItem(position);
            Toast.makeText(getBaseContext(),
                    "Codigo: " + selected.codigo+ " - Nome: " + selected.nome,
                    Toast.LENGTH_SHORT).show();
        }
        });





    /*    actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected Item: " + parent.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }
        });*/

        //para pegar valor do campo
        //String input = actv.getText().toString();

    }




    // AREA DO MENU DO TOPO
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar,menu);

        MenuItem m1 = menu.findItem(R.id.menu_adicionar_refeicao);
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
