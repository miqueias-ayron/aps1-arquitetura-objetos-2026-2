package org.insper.campeonato;

import java.util.ArrayList;

public class Campeonato {
    private String nome;
    private int ano;
    private ArrayList<Time> times;
    private ArrayList<Partida> partidas;

    public void Campeonato(String nome, int ano, ArrayList<Time> times, ArrayList<Partida> partidas){
        this.nome = nome;
        this.ano = ano;
        this.times = times;
        this.partidas = partidas;
    }

    public void adicionarTime(Time time){
        times.add(time);
    }

    public void adicionarPartida(Partida partida){
        partidas.add(partida);
    }

    public ArrayList<Time> listarTimes(){
        return this.times;
    }

    public ArrayList<Partida> listarPartidas(){
        return this.partidas;
    }

    public Time buscarTime(String nome){
        for (Time time: times){
            if (time.equals(time)) {
                return time;
            }
        }
        return null;
    }

    public ArrayList<String> exibirClassificacao(){
        return;
    }
}
