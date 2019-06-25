package com.example.dietaflex.recursos;

//Essa clase é para determinar um TIPO
public class Nutricional {

    public String nome;
    public int codigo;
    public int energia;
    public float proteinas;
    public float carboidratos;
    public float gorduras;
    public float fibras;

    @Override
    public String toString() {
        return nome;
    }
}
