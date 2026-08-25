package org.insper.campeonato;

public class Jogador {
    private String nome;
    private Integer numero;
    private String posicao;
    private Time time;

    public Jogador(String nome, Integer numero, String posicao, Time time){
        this.nome = nome;
        this.numero = numero;
        this.posicao = posicao;
        this.time = time;
    }

    public String getNome(){
        return this.nome;
    }
}
