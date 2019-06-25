package com.example.dietaflex.recursos;


import java.util.ArrayList;
import java.util.List;

public class NutricionalBancoDados {
    //private int[] energia;
    //private String[] nome = new String[10];
    //private float[] proteinas= new float[10];
    //private float[] carboidratos= new float[10];
    //private float[] gorduras= new float[10];
    //private float[] fibras= new float[10];

    public static  List <Nutricional> listarAlimentos() {

        List<Nutricional> alimentos = new ArrayList<Nutricional>();

        //abaixo deve ficar a listagem do BD NUTRICIONAL
        for(int i = 0; i < 10; i++) {

            Nutricional aaaa = new Nutricional();
            aaaa.nome = nome[i];
            aaaa.energia = energia[i];
            aaaa.proteinas= proteinas[i];
            aaaa.carboidratos= carboidratos[i];
            aaaa.gorduras= gorduras[i];
            aaaa.fibras= fibras[i];
            aaaa.codigo= i+1;

            alimentos.add(aaaa); // adiciona o objeto a lista
        }
        //FIM listagem do BD NUTRICIONAL

        return alimentos;
    }




// ESSAS ARRAYS ABAIXO SAO PROVISORIAS E OS METODOS DEVERÃO ACESAR A LISTA DE OBJETOS OU O BANCO DE DADOS DIRETAMENTE



    private static int[] energia = {
            124,
            360,
            128,
            358,
            130,
            358,
            394,
            443,
            472,
            471
    };
    private static  float[] proteinas = {
            2.6f
            ,7.3f
            ,2.5f
            ,7.2f
            ,2.6f
            ,7.2f
            ,13.9f
            ,8.1f
            ,6.4f
            ,5.4f
    };

    private static float[] carboidratos = {
            2.6f
            ,7.3f
            ,2.5f
            ,7.2f
            ,2.6f
            ,7.2f
            ,13.9f
            ,8.1f
            ,6.4f
            ,5.7f
    };
    private static float[] gorduras = {
            2.6f
            ,7.3f
            ,2.5f
            ,7.2f
            ,2.6f
            ,7.2f
            ,13.9f
            ,8.1f
            ,6.4f
            ,5.7f
    };
    private static float[] fibras = {
            2.6f
            ,7.3f
            ,2.5f
            ,7.2f
            ,2.6f
            ,7.2f
            ,13.9f
            ,8.1f
            ,6.4f
            ,5.7f
    };


    public static String[] nome = {
            "Maxixe, cru"
            ,"Mostarda, folha, crua"
            ,"Nhoque, de batata, cozido"
            ,"Nabo, cru"
            ,"Palmito, juçara, em conserva"
            ,"Arroz, tipo 2, cru"
            ,"Aveia, flocos, crua"
            ,"Biscoito, doce, maisena"
            ,"Figo, enlatado, em calda"
            ,"Fruta-pão, crua"
    };

    public String getNome(int codigo){
        return nome[codigo];
    }

    public int getEnergia(int codigo) {
        return energia[codigo];
    }

    public float getProteinas(int codigo) {
        return proteinas[codigo];
    }

    public float getCarboidratos(int codigo) {
        return carboidratos[codigo];
    }

    public float getGorduras(int codigo) {
        return gorduras[codigo];
    }

    public float getFibras(int codigo) {
        return fibras[codigo];
    }

}


