package org.example;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String cpf, String email, ArrayList<Pedido> pedidos){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.pedidos = pedidos;
    }

    public String getCPF(){
        return this.cpf;
    }

    public void adicionarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void listarPedidos(){
        for (Pedido pedido: this.pedidos){
            System.out.println(pedido.getNome());
        }
    }

    public Double calcularTotalGasto(){
        double gasto = 0;
        for (Pedido pedido: this.pedidos){
            gasto += pedido.getPreco();
        }
        return gasto;
    }

    public String buscarPedidoMaisCaro(){
        double valorMaisCaro = 0;
        String nomePedidoMaisCaro = "";
        for (Pedido pedido: this.pedidos){
            if (pedido.getPreco() > valorMaisCaro){
                valorMaisCaro = pedido.getPreco();
                nomePedidoMaisCaro = pedido.getNome();
            }
        }
        return nomePedidoMaisCaro;
    }

}
