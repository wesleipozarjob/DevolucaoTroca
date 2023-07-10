package br.com.dev.model;

public abstract class Produto {
    
    private String codigo; 
    private String descricao;
    private double valor;

    public Produto(String codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
    
    public abstract double calcular();
    public abstract double getPesoQuantidade();
    
}
