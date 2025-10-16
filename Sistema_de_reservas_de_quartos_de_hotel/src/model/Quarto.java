package model;

import exception.QuantidadeDeDiasInvalidaException;

public abstract class Quarto {
    
    private int numero;
    private int capacidade;
    private boolean ocupado;
    private double valorDiaria;


    public boolean marcarComoLivre() {
        return ocupado = true;
    }

    public boolean marcarComoOcupado() {
        return ocupado = false;
    }
    
    public abstract double calcularPreco(int dias) throws QuantidadeDeDiasInvalidaException;


}
