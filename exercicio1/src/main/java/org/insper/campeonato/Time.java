package org.insper.campeonato;
import java.util.ArrayList;

public class Time {
    private String nome;
    private String cidade;
    private ArrayList<Jogador> jogadores;
    int pontuacao = 0;

    public Time(String nome, String cidade, ArrayList<Jogador> jogadores){
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = jogadores;
    }

    public String getNome(){
        return this.nome;
    }

    public void adicionarJogador(Jogador jogador){
        jogadores.add(jogador);
    }
    public void removerJogador(Jogador jogador){
        jogadores.remove(jogador);
    }
    public ArrayList<Jogador> listarJogadores() {
        return this.jogadores;
    }
}
