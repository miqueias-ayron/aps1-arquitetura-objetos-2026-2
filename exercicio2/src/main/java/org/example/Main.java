package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("Loja Virtual", new ArrayList<Produto>(), new ArrayList<Cliente>());

        Categoria eletronicos = new Categoria(1, "Eletronicos", new ArrayList<Produto>());
        Categoria livros = new Categoria(2, "Livros", new ArrayList<Produto>());
        Categoria alimentos = new Categoria(3, "Alimentos", new ArrayList<Produto>());

        Produto notebook = new Produto(101, "Notebook", 4500.0, eletronicos);
        Produto celular = new Produto(102, "Celular", 3200.0, eletronicos);
        Produto fone = new Produto(103, "Fone de Ouvido", 350.0, eletronicos);
        Produto livroJava = new Produto(201, "Livro Java", 120.0, livros);
        Produto livroPoo = new Produto(202, "Livro POO", 90.0, livros);
        Produto livroAlgoritmos = new Produto(203, "Livro Algoritmos", 150.0, livros);
        Produto cafe = new Produto(301, "Cafe", 25.0, alimentos);
        Produto chocolate = new Produto(302, "Chocolate", 12.0, alimentos);

        Produto[] produtos = {notebook, celular, fone, livroJava, livroPoo, livroAlgoritmos, cafe, chocolate};
        for (Produto produto : produtos) {
            loja.adicionarProduto(produto);
            produto.getCategoria().adicionarProduto(produto);
        }

        Cliente ana = new Cliente("Ana", "111.111.111-11", "ana@email.com", new ArrayList<Pedido>());
        Cliente bruno = new Cliente("Bruno", "222.222.222-22", "bruno@email.com", new ArrayList<Pedido>());
        Cliente carla = new Cliente("Carla", "333.333.333-33", "carla@email.com", new ArrayList<Pedido>());
        loja.adicionarCliente(ana);
        loja.adicionarCliente(bruno);
        loja.adicionarCliente(carla);

        Pedido pedido1 = new Pedido(1, ana, new ArrayList<ItemPedido>(), "NOVO");
        pedido1.adicionarProduto(notebook, 1);
        pedido1.adicionarProduto(fone, 2);
        ana.adicionarPedido(pedido1);

        Pedido pedido2 = new Pedido(2, ana, new ArrayList<ItemPedido>(), "NOVO");
        pedido2.adicionarProduto(livroJava, 3);
        pedido2.adicionarProduto(cafe, 4);
        pedido2.alterarStatus("PAGO");
        ana.adicionarPedido(pedido2);

        Pedido pedido3 = new Pedido(3, bruno, new ArrayList<ItemPedido>(), "NOVO");
        pedido3.adicionarProduto(celular, 1);
        pedido3.adicionarProduto(chocolate, 5);
        bruno.adicionarPedido(pedido3);

        Pedido pedido4 = new Pedido(4, carla, new ArrayList<ItemPedido>(), "NOVO");
        pedido4.adicionarProduto(livroPoo, 2);
        pedido4.adicionarProduto(livroAlgoritmos, 1);
        pedido4.adicionarProduto(cafe, 2);
        carla.adicionarPedido(pedido4);

        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);

        System.out.println("=== Valor de cada pedido ===");
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido " + pedido.getNumeroPedido()
                    + " (" + pedido.getStatus() + ") - cliente " + pedido.getCliente().getNome()
                    + " - total R$ " + pedido.calcularTotal()
                    + " - itens: " + pedido.calcularQuantidadeItens()
                    + " - item mais caro: " + pedido.buscarItemMaisCaro());
        }

        System.out.println("=== Total gasto por cliente ===");
        Cliente[] clientes = {ana, bruno, carla};
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " gastou R$ " + cliente.calcularTotalGasto()
                    + " - pedido mais caro: " + cliente.buscarPedidoMaisCaro());
        }

        System.out.println("=== Produto mais caro por categoria ===");
        Categoria[] categorias = {eletronicos, livros, alimentos};
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getNome() + ": " + categoria.buscarProdutoMaisCaro()
                    + " (preco medio R$ " + categoria.calcularPrecoMedio() + ")");
        }

        System.out.println("=== Preco no pedido nao muda ao alterar preco do produto ===");
        double totalAntes = pedido1.calcularTotal();
        notebook.aumentarPreco(20);
        double totalDepois = pedido1.calcularTotal();
        System.out.println("Total pedido 1 antes: R$ " + totalAntes + " | depois: R$ " + totalDepois);
    }
}
