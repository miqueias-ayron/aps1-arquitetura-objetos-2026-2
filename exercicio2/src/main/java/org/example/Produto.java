package org.example;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto(int codigo, String nome, double preco, Categoria categoria){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public void aplicarDesconto(double percentual){
        System.out.println("PRECO COM DESCONTO " + this.preco*(1 - percentual/100));
    }

    public void aumentarPreco(double percentual){
        System.out.println("NOVO PRECO " + this.preco*(1 + percentual/100));
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getNome(){
        return this.nome;
    }

    public Categoria getCategoria(){
        return this.categoria;
    }

    public double getPreco(){
        return this.preco;
    }
}
