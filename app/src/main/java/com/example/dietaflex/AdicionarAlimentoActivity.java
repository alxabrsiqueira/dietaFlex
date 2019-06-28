package com.example.dietaflex;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dietaflex.recursos.Nutricional;
import com.example.dietaflex.recursos.NutricionalBancoDados;
import com.example.dietaflex.recursos.Refeicao;
import com.example.dietaflex.recursos.RefeicoesBancoDados;

import java.util.ArrayList;
import java.util.List;

public class AdicionarAlimentoActivity extends AppCompatActivity {


    private EditText  campoQuantidade ;
    private AutoCompleteTextView campoNomeAlimento;
    private int id ;
    private float quantidade ;
    private int codigo;
    private boolean eEditar; // true se for para editar, false se nova inclusão
    private String nome;
    private String txtQuantidade;
    private String txtAlimento;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adicionar_alimento);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        verificaParametro(); // verififica se é para editar
        verificarNutrientes(); // chama thread que verifica os dados micronutrientes

        campoQuantidade = (EditText) findViewById(R.id.campo_quantidade);
        campoNomeAlimento = (AutoCompleteTextView) findViewById(R.id.campo_nome_alimento);



        //****** MODO EDITAR
        if(eEditar){
            campoQuantidade.setText(String.valueOf(quantidade));
            campoNomeAlimento.setText(nome);

            // chamar um botao de excluir
        }
        //*********BOTAO SAIR
        Button botaoSair = findViewById(R.id.botao_sair);
        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //*********BOTAO SALVAR
        Button botaoSalvar = findViewById(R.id.botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validaCampos()){
                    try {
                        Calendar datahorarioAgora = Calendar.getInstance();
                        SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Refeicao objeto = new Refeicao();

                        objeto.grupo = 1;
                        objeto.quantidade = Float.parseFloat(campoQuantidade.getText().toString());;
                        objeto.datahorario = dataFormatada.format(datahorarioAgora.getTime());
                        objeto.codigo = codigo;
                        objeto.id = id;

                        if(eEditar){

                            RefeicoesBancoDados.editarRefeicao(objeto); // EDITA O BD

                            Toast.makeText(getBaseContext(),  "Codigo: "+objeto.codigo, Toast.LENGTH_SHORT).show();

                            Toast.makeText(getBaseContext(),  "\n ID: "+objeto.id, Toast.LENGTH_SHORT).show();

                            Toast.makeText(getBaseContext(),  "\n Quantidade: "+objeto.quantidade, Toast.LENGTH_SHORT).show();

                           startActivity(new Intent(getBaseContext(), ListarRefeicoesActivity.class));
                        }
                        else {

                         RefeicoesBancoDados.adicionarRefeicao(objeto); // SALVA NOVO ITEM

                            Toast.makeText(getBaseContext(),  R.string.txt_salvo_com_sucesso, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getBaseContext(), ListarRefeicoesActivity.class));
                        }
                    }
                    catch (Exception e){

                        Toast.makeText(getBaseContext(),  R.string.alerta_erro_ao_salvar, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getBaseContext(), ListarRefeicoesActivity.class));

                    }
                }
            }
        });
        //----------fim BOTAO SALVAR

        //*********PARTE DO AUTO COMPLETE

        ArrayAdapter<Nutricional> adapter = new ArrayAdapter<Nutricional>(this,
                android.R.layout.simple_dropdown_item_1line,  NutricionalBancoDados.listarAlimentos());
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.campo_nome_alimento);
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
        //-----------fim auto complete
    }
 //*******FUnçÃO EDITAR
        private void verificaParametro(){
            Bundle bundle= getIntent().getExtras();
            if ((bundle != null) && (bundle.containsKey("REFEICAO"))){
                Refeicao refeicao = (Refeicao) bundle.getSerializable("REFEICAO");
                this.id = refeicao.id ;
                this.codigo = refeicao.codigo ;
                this.quantidade = refeicao.quantidade ;
                eEditar=true;
                for (Nutricional temp : NutricionalBancoDados.listarAlimentos()) {
                    if (temp.codigo == this.codigo) {
                        this.nome = temp.nome;
                        break;
                    }
                }
            }
        }
 //-------fim funcao editar

    //******* AREA DO MENU DO TOPO
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
// -------- FIM DO MENU DO TOPO


    //******* ATUALIZA MACRO NUTRIENTES
    private void verificarNutrientes(){

        Thread thread = new Thread() {

            @Override
            public void run() {
                String nomeCampo = campoNomeAlimento.getText().toString();
                if(!nomeCampo.equals(nome))   {
                    nome = nomeCampo;
                    for (Nutricional temp : NutricionalBancoDados.listarAlimentos() ) {
                        if (temp.nome.equals(txtAlimento)) {
                            codigo = temp.codigo;
                            nome = temp.nome;
                            //colocar atualizacao dos nutrientes

                        }
                    }
                }
            }
        };
        thread.start();
    }

    //------fim de verificar todos atributos

//*********METODOS AXILIARES da aç]ao salvar
    private boolean verificarCamposVazios(String valor){
            boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
            return resultado; // retorna verdadeiro se tiver vazio
    }
    private boolean verificarCodigo(String valor){//retorna false se não houver na BD
        if (!verificarCamposVazios(valor)) {
            for(Nutricional temp : NutricionalBancoDados.listarAlimentos()) {
                if(temp.nome.equals(valor)) {
                    codigo= temp.codigo;
                    return true;
                }
            }
        }
        return false;
    }
    private boolean validaCampos() {

        boolean flag = false;
         txtQuantidade = campoQuantidade.getText().toString();
         txtAlimento = campoNomeAlimento.getText().toString();
        String mensagem = "";


        if (flag = verificarCamposVazios(txtAlimento)) {
            campoNomeAlimento.requestFocus();
            mensagem = getString(R.string.msg_alimento_nao_especificado);
        }
        else
        if(!verificarCodigo(txtAlimento)){
            flag =true;
            campoNomeAlimento.requestFocus();
            mensagem = getString(R.string.msg_alimento_nao_consta);
        }
        else
        if (flag = verificarCamposVazios(txtQuantidade)){
            campoQuantidade.requestFocus();
            mensagem = getString(R.string.msg_quatidade_nao_especificada);
        }

        if(flag){
            AlertDialog.Builder janela = new AlertDialog.Builder(this);
            janela.setMessage(mensagem);
            janela.setNegativeButton("Ok", null);
            janela.show();
            return false;
        }
        else
            return true;

    }
    //--------fim dos metodos axiliares
}




