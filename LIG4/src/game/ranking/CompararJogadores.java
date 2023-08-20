package game.ranking;
import java.util.Comparator;
import game.user.Jogador;

public class CompararJogadores implements Comparator<Jogador> {
    @Override
    public int compare(Jogador jogador1, Jogador jogador2) {
        // Compara jogadores baseado no número total de vitorias
        return Integer.compare(jogador1.getWins(), jogador2.getWins());
    }
}