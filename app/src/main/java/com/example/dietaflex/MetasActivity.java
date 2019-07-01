package com.example.dietaflex;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import com.example.dietaflex.recursos.Metas;
import com.example.dietaflex.recursos.Nutricional;
import com.example.dietaflex.recursos.Totalizacao;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MetasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      //  Nutricional teste = Totalizacao.macrosGeral();

        SharedPreferences preferences =getSharedPreferences("configDietaFlex",getBaseContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

      Metas.setPadrao(getBaseContext());




/*

        TextView aaaa = (TextView) findViewById(R.id.textView2);

        String  qnt =  String.valueOf((int)teste.quantidade);
        String  pro =   String.valueOf((int)teste.proteinas);
        String  car =   String.valueOf((int)teste.carboidratos);
        String  gor =   String.valueOf((int)teste.gorduras);
        String  fib =   String.valueOf((int)teste.fibras);
        String  ene =  String.valueOf(teste.energia);

        String texto = ene+" kcal | P: "+pro+" g | C: "+car+" g | G: "+gor+" g | F: "+fib+" g ! Q: "+qnt  ;


        aaaa.setText(texto);
*/
        new AlertDialog.Builder(this).setTitle("teste").
                setMessage("tesssssssteee").show();
    }


    // AREA DO MENU DO TOPO
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar,menu);

        MenuItem m1 = menu.findItem(R.id.menu_configurar_metas);
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
