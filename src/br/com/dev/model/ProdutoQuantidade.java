package br.com.dev.model;

public class ProdutoQuantidade extends Produto{
    
    private int quantidade;

    public ProdutoQuantidade(String codigo, String descricao, double valor, int quantidade) {
        super(codigo, descricao, valor);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public double calcular() {
        return getValor() * getQuantidade();
    }

    @Override
    public double getPesoQuantidade() {
        return getQuantidade();
    }
    
    

}
