package game;
import user.jogadores.Jogador;

public class Mensagem {

    private String divisoes = "*" + "-".repeat(28) + "*";
    private Jogador jog1;
    private Jogador jog2;

    public Mensagem(Jogador jog1, Jogador jog2){
        this.jog1 =jog1;
        this.jog2 = jog2;
    }
    
    public void displayVitoria(Jogador jogadorDaRodada){
    System.out.print("\033[H\033[2J");
        System.out.println(divisoes);
        infoJogadores();
        System.out.printf(" !! Vitória de %s !!", jogadorDaRodada.getNome());
        System.out.println("\n   > 1- jogar Novamente <");
        System.out.println("   > 2- Voltar ao MENU <");
        System.out.println(divisoes + "\n");
    }

    public void displayEmpate(){
        System.out.print("\033[H\033[2J");
        System.out.println(divisoes);
        infoJogadores();
        System.out.println("\t  !! EMPATE !!");
        System.out.println("  *O tabuleiro está cheio*");
        System.out.println("\n  > 1- jogar Novamente <");
        System.out.println("  > 2- Voltar ao MENU <");
        System.out.println(divisoes + "\n");
    
    }
    
    public void displayMensagem(Jogador jogadorDaRodada){
        System.out.print("\033[H\033[2J");
        System.out.println("Selecione: 9 para Voltar ao MENU");
        System.out.println("           0 para Resetar Tabuleiro \n");
        infoJogadores();
        System.out.printf(" > ESTÁ NA VEZ DE: %s <\n\n",jogadorDaRodada.getNome());
    }
    public void displayMensagem(Jogador jogadorDaRodada,String aviso){
        displayMensagem(jogadorDaRodada);
        System.out.println(aviso);
    }

    private void infoJogadores(){
        System.out.printf("%s(%s)  Vs  ", jog1.getNome(), jog1.getPeca());
        System.out.printf("%s(%s)\n", jog2.getNome(), jog2.getPeca());

        System.out.printf( "\t   [%d x %d]\n\n",jog1.getWins(),jog2.getWins());
    }
}
