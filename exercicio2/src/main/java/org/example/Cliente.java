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

    public String getNome(){
        return this.nome;
    }

    public String getCPF(){
        return this.cpf;
    }

    public void adicionarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void listarPedidos(){
        for (Pedido pedido: this.pedidos){
            System.out.println(pedido.getNumeroPedido());
        }
    }

    public Double calcularTotalGasto(){
        double gasto = 0;
        for (Pedido pedido: this.pedidos){
            gasto += pedido.calcularTotal();
        }
        return gasto;
    }

    public int buscarPedidoMaisCaro(){
        double valorMaisCaro = 0;
        int numeroPedidoMaisCaro = 0;
        for (Pedido pedido: this.pedidos){
            if (pedido.calcularTotal() > valorMaisCaro){
                valorMaisCaro = pedido.calcularTotal();
                numeroPedidoMaisCaro = pedido.getNumeroPedido();
            }
        }
        return numeroPedidoMaisCaro;
    }

}
