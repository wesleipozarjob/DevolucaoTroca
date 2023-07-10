package br.com.dev.model;

public class ProdutoPeso extends Produto{
    
    private double peso;

    public ProdutoPeso(String codigo, String descricao, double valor, double peso) {
        super(codigo, descricao, valor);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public double calcular() {
        return getValor() * getPeso();
    }

    @Override
    public double getPesoQuantidade() {
        return getPeso();
    }

}
