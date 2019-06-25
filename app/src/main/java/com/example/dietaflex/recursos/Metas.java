package com.example.dietaflex.recursos;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/*
    public Metas(Context context)   *obs: contexto podem usar: getBaseContext()  se tiver dentro de uma activity ou "this"

    public  float getProteinas()

    public  void setProteinas(float proteinas)

    public  float getCarboidratos()

    public  void setCarboidratos(float carboidratos)

    public  float getGorduras()

    public  void setGorduras(float gorduras)

    public  float getFibras()

    public  void setFibras(float fibras, Context context)

    public  String getReset()

    public  void setReset(String reset)

    public  int getEnergia()

    public  void setEnergia(int energia)

  */


public final class Metas  {
    private static final int energiaDefault = 2000 ;
    private static final float proteinasDefault= 75;
    private static final float carboidratosDefault= 300 ;
    private static final float gordurasDefault= 55 ;
    private static final float fibrasDefault= 25 ;
    private static final String resetDefault= "00:00" ;
    private  SharedPreferences config;
    private  SharedPreferences.Editor metas;
    private Context contexto;

    public  Metas(Context context){
        contexto = context;
        config = contexto.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        metas = config.edit();
    }

    public void alertaDeExcecao(Exception e){
        Toast.makeText(contexto,"Erro ao salvar dado",Toast.LENGTH_LONG).show();
    }

    public  float getProteinas() {
        return config.getFloat("proteinas",proteinasDefault);
    }

    public  void setProteinas(float proteinas) {
        try {
            metas.putFloat("proteinas", proteinas);
            metas.apply();
        }
        catch (Exception e){
            alertaDeExcecao(e);
        }
    }

    public  float getCarboidratos() {
        return config.getFloat("carboidratos",carboidratosDefault);
    }

    public  void setCarboidratos(float carboidratos) {
        try {
            metas.putFloat("carboidratos", carboidratos);
            metas.apply();
        }
        catch (Exception e){
            alertaDeExcecao(e);
        }
    }

    public  float getGorduras() {
        return config.getFloat("gorduras",gordurasDefault);
    }

    public  void setGorduras(float gorduras) {
        try {
            metas.putFloat("gorduras", gorduras);
            metas.apply();
        }
        catch (Exception e){
            alertaDeExcecao(e);
        }
    }

    public  float getFibras() {
        return config.getFloat("fibras",fibrasDefault);
    }

    public  void setFibras(float fibras, Context context) {
        try {
            metas.putFloat("fibras", fibras);
            metas.apply();
        }
        catch (Exception e){
            alertaDeExcecao(e);
        }
    }

    public  String getReset() {
        return config.getString("reset",resetDefault);
    }

    public  void setReset(String reset) {
        try {
            metas.putString("reset", reset);
            metas.apply();
        }
        catch (Exception e){
            alertaDeExcecao(e);
        }
    }

    public  int getEnergia() {
        return config.getInt("energia",energiaDefault);
    }

    public  void setEnergia( int energia) {
        try {
            metas.putFloat("energia", energia);
            metas.apply();
        }
        catch (Exception e){
            alertaDeExcecao(e);
        }
    }


}
/*
Activity.getApplicationContext(): Retorna o contexto do aplicativo inteiro (o processo dentro do qual todas as Activities estão sendo executadas). Use este no lugar do contexto da Activity ativa no momento se você estiver precisando de um contexto vinculado ao ciclo de vida do aplicativo inteiro.

ContextWrapper.getBaseContext(): É um método da classe ContextWrapper. E ContextWrapper é "uma implementação proxy de Context que simplesmente delega todas as suas chamadas para um outro Context. Pode ser estendida para modificar comportamentos sem alterar o Context original."

Fragment.getActivity(): Retorna a Activity à qual está anexado este fragmento. Um fragmento não possui Context por si só; porém, quando se encontra ligado (attached ou added) a uma Activity tem acesso ao contexto dessa Activity, ou então se guarda uma instância de Application tem acesso a essa instância mesmo estando desligado da Activity.








    public static float getProteinas(Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        return config.getFloat("proteinas",proteinasDefault);
    }

    public static void setProteinas(float proteinas, Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        SharedPreferences.Editor metas = config.edit();
         metas.putFloat("proteinas", proteinas);
         metas.apply();
    }

    public static float getCarboidratos(Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        return config.getFloat("carboidratos",carboidratosDefault);
    }

    public static void setCarboidratos(float carboidratos, Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        SharedPreferences.Editor metas = config.edit();
        metas.putFloat("carboidratos", carboidratos);
        metas.apply();
    }

    public static float getGorduras(Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        return config.getFloat("gorduras",gordurasDefault);
    }

    public static void setGorduras(float gorduras, Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        SharedPreferences.Editor metas = config.edit();
        metas.putFloat("gorduras", gorduras);
        metas.apply();
    }

    public static float getFibras(Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        return config.getFloat("fibras",fibrasDefault);
    }

    public static void setFibras(float fibras, Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        SharedPreferences.Editor metas = config.edit();
        metas.putFloat("fibras", fibras);
        metas.apply();
    }

    public static String getReset(Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        return config.getFloat("reset",resetDefault);
    }

    public static void setReset(Calendar reset, Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        SharedPreferences.Editor metas = config.edit();
        metas.putString("reset", reset);
        metas.apply();
    }

    public static int getEnergia(Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        return config.getFloat("energia",energiaDefault);
    }

    public static void setEnergia( int energia, Context context) {
        SharedPreferences config = context.getSharedPreferences("configDietaFlex", Context.MODE_PRIVATE);
        SharedPreferences.Editor metas = config.edit();
        metas.putFloat("energia", energia);
        metas.apply();
    }

 */