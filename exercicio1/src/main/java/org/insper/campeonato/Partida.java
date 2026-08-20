package org.insper.campeonato;
import java.time.LocalDate;
import java.util.ArrayList;

public class Partida {
    private LocalDate data;
    private Time timeMandante;
    private Time timeVisitante;
    private Integer golMandante;
    private Integer golVisitante;
    private ArrayList<Cartao> cartoes;
    Campeonato campeonato;

    public Partida(LocalDate data, Campeonato campeonato){
        this.data = data;
        this.campeonato = campeonato;
    }
    public void registrarTimes(Time timeMandante, Time timeVisitante){
        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
    }
    public void registrarGol(int golMandante, int golVisitante){
        this.golMandante = golMandante;
        this.golVisitante = golVisitante;
    }
    public void registrarCartao(Cartao cartao){
        this.cartoes.add(cartao);
    }
    public Time buscarVencedor(){
        if (this.golVisitante > this.golMandante){
            this.timeVisitante.pontuacao += 3;
            return this.timeVisitante;
        }
        if (this.golVisitante < this.golMandante){
            this.timeMandante.pontuacao += 3;
            return this.timeMandante;
        }
        this.timeVisitante.pontuacao += 1;
        this.timeMandante.pontuacao += 1;
        return null;
    }
    public String exibirPlacar() {
        return String.format("%s %d x %d %s", this.timeMandante.getNome(), this.golMandante, this.golVisitante, this.timeVisitante.getNome());
    }
}
