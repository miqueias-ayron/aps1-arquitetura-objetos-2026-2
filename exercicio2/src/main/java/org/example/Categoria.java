package org.example;

import java.util.ArrayList;

public class Categoria {
    private int codigo;
    private String nome;
    private ArrayList<Produto> produtos;

    public Categoria(int codigo, String nome, ArrayList<Produto> produtos){
        this.codigo = codigo;
        this.nome = nome;
        this.produtos = produtos;
    }

    public String getNome(){
        return this.nome;
    }

    public void adicionarProduto(Produto produto){
        this.produtos.add(produto);
    }

    public void listarProdutos(){
        for (Produto produto: this.produtos){
            System.out.println(produto.getNome());
        }
    }

    public Double calcularPrecoMedio(){
        if (this.produtos.size() == 0){
            return null;
        }
        double somaPrecos = 0;
        for (Produto produto: this.produtos){
            somaPrecos += produto.getPreco();
        }
        return somaPrecos/this.produtos.size();
    }

    public String buscarProdutoMaisCaro(){
        double maiorPreco = 0;
        String nomeProdutoMaisCaro = "";
        for (Produto produto: this.produtos){
            double preco = produto.getPreco();
            if (preco > maiorPreco){
                maiorPreco = preco;
                nomeProdutoMaisCaro = produto.getNome();
            }
        }
        return nomeProdutoMaisCaro;
    }

}
