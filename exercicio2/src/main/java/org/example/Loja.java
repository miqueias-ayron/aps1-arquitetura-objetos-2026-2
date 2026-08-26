package org.example;

import java.util.ArrayList;

public class Loja {
    private String nome;
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;

    public Loja(String nome, ArrayList<Produto> produtos, ArrayList<Cliente> clientes){
        this.nome = nome;
        this.produtos = produtos;
        this.clientes = clientes;
    }

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Produto buscarProduto(int codigo){
        for (Produto produto: this.produtos){
            if (produto.getCodigo() == codigo){
                return produto;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String cpf){
        for (Cliente cliente: this.clientes){
            if (cliente.getCPF().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public void listarProdutos(){
        for (Produto produto: this.produtos){
            System.out.println(produto.getNome());
        }
    }

    public void listarProdutosPorCategoria(Categoria categoria){
        for (Produto produto: this.produtos){
            if (produto.getCategoria().getNome().equals(categoria.getNome())){
                System.out.println(categoria);
            }
        }
    }

}
