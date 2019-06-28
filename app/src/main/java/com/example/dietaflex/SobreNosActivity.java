package com.example.dietaflex;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.dietaflex.recursos.Metas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dietaflex.R;

public class SobreNosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //*********BOTAO SAIR
        Button botaoSair = findViewById(R.id.botao_sair2);
        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

/*
        final Metas metas = new Metas(this);//new Metas(getBaseContext());
        final EditText nome = (EditText) findViewById(R.id.editText);
        Button gravar = (Button) findViewById(R.id.gravar);
        gravar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try{
                    metas.setProteinas(Float.parseFloat(nome.getText().toString()));
                }
                catch (Exception e){
                    metas.alertaDeExcecao(e);
                }
            }
        });

        Button limpar = (Button) findViewById(R.id.apagar);
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome.setText("");
            }
        });
        Button recuperar = (Button) findViewById(R.id.recuperar);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome.setText(String.valueOf(metas.getProteinas()));
            }
        });
       */
    }


    // AREA DO MENU DO TOPO
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar,menu);

        MenuItem m1 = menu.findItem(R.id.menu_sobre_nos);
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
