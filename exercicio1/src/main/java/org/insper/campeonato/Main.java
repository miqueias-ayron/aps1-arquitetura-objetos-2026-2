package org.insper.campeonato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Campeonato campeonato = new Campeonato("Brasileirao Insper", 2026, new ArrayList<>(), new ArrayList<>());

        Time flamengo = new Time("Flamengo", "Rio de Janeiro");
        Time palmeiras = new Time("Palmeiras", "Sao Paulo");
        Time gremio = new Time("Gremio", "Porto Alegre");
        Time corinthians = new Time("Corinthians", "Sao Paulo");

        campeonato.adicionarTime(flamengo);
        campeonato.adicionarTime(palmeiras);
        campeonato.adicionarTime(gremio);
        campeonato.adicionarTime(corinthians);

        Jogador gabigol = new Jogador("Gabigol", 9, "Atacante", flamengo);
        Jogador arrascaeta = new Jogador("Arrascaeta", 14, "Meia", flamengo);
        Jogador rodrigoCaio = new Jogador("Rodrigo Caio", 3, "Zagueiro", flamengo);
        flamengo.adicionarJogador(gabigol);
        flamengo.adicionarJogador(arrascaeta);
        flamengo.adicionarJogador(rodrigoCaio);

        Jogador rony = new Jogador("Rony", 11, "Atacante", palmeiras);
        Jogador dudu = new Jogador("Dudu", 7, "Atacante", palmeiras);
        Jogador gomez = new Jogador("Gomez", 15, "Zagueiro", palmeiras);
        palmeiras.adicionarJogador(rony);
        palmeiras.adicionarJogador(dudu);
        palmeiras.adicionarJogador(gomez);

        Jogador diegoSouza = new Jogador("Diego Souza", 22, "Atacante", gremio);
        Jogador villasanti = new Jogador("Villasanti", 5, "Volante", gremio);
        Jogador geromel = new Jogador("Geromel", 4, "Zagueiro", gremio);
        gremio.adicionarJogador(diegoSouza);
        gremio.adicionarJogador(villasanti);
        gremio.adicionarJogador(geromel);

        Jogador yuriAlberto = new Jogador("Yuri Alberto", 9, "Atacante", corinthians);
        Jogador rodrigoGarro = new Jogador("Rodrigo Garro", 10, "Meia", corinthians);
        Jogador fagner = new Jogador("Fagner", 23, "Lateral", corinthians);
        corinthians.adicionarJogador(yuriAlberto);
        corinthians.adicionarJogador(rodrigoGarro);
        corinthians.adicionarJogador(fagner);

        Partida partida1 = new Partida(LocalDate.of(2026, 3, 1), campeonato);
        partida1.registrarTimes(flamengo, palmeiras);
        partida1.registrarGol(gabigol);
        partida1.registrarGol(gabigol);
        partida1.registrarGol(rony);
        partida1.registrarCartao(dudu, new Cartao(dudu, 33, "amarelo", partida1));
        partida1.buscarVencedor();
        campeonato.adicionarPartida(partida1);

        Partida partida2 = new Partida(LocalDate.of(2026, 3, 8), campeonato);
        partida2.registrarTimes(gremio, corinthians);
        partida2.registrarGol(yuriAlberto);
        partida2.registrarCartao(geromel, new Cartao(geromel, 41, "amarelo", partida2));
        partida2.buscarVencedor();
        campeonato.adicionarPartida(partida2);

        Partida partida3 = new Partida(LocalDate.of(2026, 3, 15), campeonato);
        partida3.registrarTimes(palmeiras, gremio);
        partida3.registrarGol(rony);
        partida3.registrarGol(dudu);
        partida3.registrarGol(diegoSouza);
        partida3.registrarCartao(villasanti, new Cartao(villasanti, 60, "vermelho", partida3));
        partida3.buscarVencedor();
        campeonato.adicionarPartida(partida3);

        Partida partida4 = new Partida(LocalDate.of(2026, 3, 22), campeonato);
        partida4.registrarTimes(corinthians, flamengo);
        partida4.registrarGol(yuriAlberto);
        partida4.registrarGol(gabigol);
        partida4.registrarGol(arrascaeta);
        partida4.registrarCartao(fagner, new Cartao(fagner, 12, "amarelo", partida4));
        partida4.buscarVencedor();
        campeonato.adicionarPartida(partida4);

        Partida partida5 = new Partida(LocalDate.of(2026, 3, 29), campeonato);
        partida5.registrarTimes(flamengo, gremio);
        partida5.registrarGol(gabigol);
        partida5.registrarCartao(rodrigoCaio, new Cartao(rodrigoCaio, 20, "amarelo", partida5));
        partida5.buscarVencedor();
        campeonato.adicionarPartida(partida5);

        Partida partida6 = new Partida(LocalDate.of(2026, 4, 5), campeonato);
        partida6.registrarTimes(palmeiras, corinthians);
        partida6.registrarGol(rodrigoGarro);
        partida6.registrarGol(dudu);
        partida6.registrarGol(rony);
        partida6.registrarCartao(fagner, new Cartao(fagner, 55, "vermelho", partida6));
        partida6.buscarVencedor();
        campeonato.adicionarPartida(partida6);

        System.out.println("RESULTADOS DAS PARTIDAS");
        for (Partida partida : campeonato.listarPartidas()) {
            System.out.println(partida.exibirPlacar());
        }

        System.out.println("\nCLASSIFICACAO");
        Map<String, Integer> classificacao = campeonato.exibirClassificacao();
        int posicao = 1;
        for (Map.Entry<String, Integer> entrada : classificacao.entrySet()) {
            System.out.println(posicao + "o - " + entrada.getKey() + " - " + entrada.getValue() + " pontos");
            posicao++;
        }

        System.out.println("\nARTILHEIRO DO CAMPEONATO");
        Jogador artilheiro = null;
        for (Time time : campeonato.listarTimes()) {
            for (Jogador jogador : time.listarJogadores()) {
                if (artilheiro == null || jogador.getGols() > artilheiro.getGols()) {
                    artilheiro = jogador;
                }
            }
        }
        System.out.println(artilheiro.getNome() + " - " + artilheiro.getGols() + " gols");
    }
}
