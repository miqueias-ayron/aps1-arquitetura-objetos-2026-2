package org.example;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private Cliente cliente;
    private ArrayList<ItemPedido> itens;
    private String status;

    public Pedido(int numero, Cliente cliente, ArrayList<ItemPedido> itens, String status){
        this.numero = numero;
        this.cliente = cliente;
        this.itens = itens;
        this.status = status;
    }

    public void adicionarProduto(Produto produto, int quantidade){
        itens.add(new ItemPedido(produto, quantidade, produto.getPreco()));
    }

    public void removerProduto(Produto produto){
        itens.removeIf(item -> item.getProduto().getCodigo() == produto.getCodigo());
    }

    public double calcularTotal(){
        double soma = 0;
        for (ItemPedido item: itens){
            soma += item.calcularSubtotal();
        }
        return soma;
    }

    public int calcularQuantidadeItens(){
        int soma = 0;
        for (ItemPedido item: itens){
            soma += item.getQuantidade();
        }
        return soma;
    }

    public String buscarItemMaisCaro(){
        double maiorSubtotal = 0;
        String nomeItemMaisCaro = "";
        for (ItemPedido item: itens){
            double subtotal = item.calcularSubtotal();
            if (subtotal > maiorSubtotal){
                maiorSubtotal = subtotal;
                nomeItemMaisCaro = item.getProduto().getNome();
            }
        }
        return nomeItemMaisCaro;
    }

    public void alterarStatus(String status){
        this.status = status;
    }

    public int getNumeroPedido(){
        return this.numero;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public String getStatus(){
        return this.status;
    }

}
