package com.example.dietaflex.recursos;


import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import com.example.dietaflex.recursos.Refeicao;

import java.util.ArrayList;
import java.util.List;

public class RefeicoesBancoDados  {
private Context contexto;
    public RefeicoesBancoDados(Context contexto){
        this.contexto = contexto;
    }

    public void adicionarRefeicao(Refeicao alimento) {
        //adciona ao BD a partir do objeto.
    }

    public void removerRefeicao(int id) {
        //deleta do BD a partir do id.
    }

    public  List <Refeicao> listarRefeicoes(){

        List <Refeicao> alimentos = new ArrayList <Refeicao>();

        for(int i = 0; i < 20; i++) {
           Refeicao aaaa = new Refeicao();
            aaaa.codigo = 6;
            aaaa.datahorario = "2019-06-23 20:10:00";
            aaaa.quantidade = 500;
            alimentos.add(aaaa);
        }

        return alimentos;
    }

    public String dataUltimoReset() {

    Metas obj = new Metas(contexto);

        String horarioReset = obj.getReset();//"11:00";//
        String[] horarioResetArray = new String[2];
        horarioResetArray = horarioReset.split(":");
        int minR = Integer.parseInt(horarioResetArray[1]);
        int horaR = Integer.parseInt(horarioResetArray[0]);


        Calendar datahorarioAgora = Calendar.getInstance();
        Calendar datahorarioReset = Calendar.getInstance();

        float horaA =  datahorarioAgora.get(Calendar.HOUR_OF_DAY);
        float minA =  datahorarioAgora.get(Calendar.MINUTE);

        float horarioResetReal = horaR+ minR/60.0f;
        float horarioAgoraReal = horaA+ minA/60.0f;

        datahorarioReset.set(Calendar.HOUR_OF_DAY, horaR);
        datahorarioReset.set(Calendar.MINUTE, minR);
        datahorarioReset.set(Calendar.SECOND, 0);


        if(horarioResetReal > horarioAgoraReal) {
            datahorarioReset.add(datahorarioReset.DAY_OF_MONTH, -1);
        }

        SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return dataFormatada.format(datahorarioReset.getTime());

        // RETORNA NO TIPO DATE return datahorarioReset.getTime()

    }
}
