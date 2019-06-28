package com.example.dietaflex.recursos;

import android.icu.text.DecimalFormat;

import java.math.RoundingMode;

public class Totalizacao {

    public int id ;
    public int grupo;
    public float quantidade ;
    public String datahorario;
    public int codigo;
    private int energia;
    private String nome ;
    private float proteinas;
    private float carboidratos;
    private float gorduras;
    private float fibras;


    public Totalizacao(){


    }

    public static int proporcao(float quantidade, int valor){

        return (int)(valor*quantidade)/100; // proporacao baseada em 100g
    }
    public static float proporcao(float quantidade, float valor){
        return (valor*quantidade)/100.0f; // proporacao baseada em 100g
    }



      /*  public static float truncar(float valor) {
            DecimalFormat decimalFormat = new DecimalFormat("#,#0.0");
            return  Float.parseFloat(decimalFormat.format(valor)) ;
        }
*/

//*********RETORNA UM OBJETO COM OS VALORES PROPORCIONAIS DE MACRONUTRIENTES
    public  static Nutricional macrosIndividual(int codigo, float quantidade) {
        Nutricional retorno = new Nutricional();
        for (Nutricional temp : NutricionalBancoDados.listarAlimentos() ) {
            if (codigo == temp.codigo) {
                retorno.nome = temp.nome;
                retorno.energia = proporcao(quantidade, temp.energia);
                retorno.proteinas = proporcao(quantidade, temp.proteinas);
                retorno.carboidratos = proporcao(quantidade, temp.carboidratos);
                retorno.gorduras = proporcao(quantidade, temp.gorduras);
                retorno.fibras = proporcao(quantidade, temp.fibras);
                retorno.quantidade = quantidade;
                return retorno;
            }
        }
        retorno.nome = "Item não encontrado";
        retorno.energia = 0;
        retorno.proteinas = 0;
        retorno.carboidratos = 0;
        retorno.gorduras = 0;
        retorno.fibras = 0;
        retorno.quantidade = 0;
        return retorno;
    }
    //*********RETORNA UM OBJETO COM OS VALORES TOTAIS DE MACRONUTRIENTES
    public  static Nutricional macrosGeral() {
        Nutricional retorno = new Nutricional();
        for (Refeicao temp : RefeicoesBancoDados.listarRefeicoes() ) {

            Nutricional nutriTemp =  macrosIndividual(temp.codigo, temp.quantidade);

            retorno.energia += nutriTemp.energia;
            retorno.proteinas += nutriTemp.proteinas;
            retorno.carboidratos += nutriTemp.carboidratos;
            retorno.gorduras += nutriTemp.gorduras;
            retorno.fibras += nutriTemp.fibras;
            retorno.quantidade += nutriTemp.quantidade;
        }
        retorno.nome= "Valores Totais de Macros";
        return retorno;
    }


}
