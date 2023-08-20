package game.ranking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.user.Jogador;

public class Ranking {
    private static Ranking ranking = new Ranking();
    private List<Jogador> listaJogadores = new ArrayList<>();;

    public static Ranking getInstance() {
        return ranking;
    }

    public List<Jogador> getListaJogadores() {
        return Collections.unmodifiableList(listaJogadores);
    }

    public void addJogador(Jogador jogador) {
        listaJogadores.add(jogador);
    }

    public void updateRanking() {
        Collections.sort(listaJogadores, new CompararJogadores().reversed());
    }
}