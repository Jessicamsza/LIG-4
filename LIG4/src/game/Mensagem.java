package game;

public class Mensagem {
    
    public void displayVitoria(String jogador){
        String divisoes = "*" + "-".repeat(28) + "*";
    
        System.out.print("\033[H\033[2J");
        System.out.println(divisoes );
        System.out.println(" !! Vitória de " + jogador +" !!");
        System.out.println("\n   > 1- jogar Novamente <");
        System.out.println("   > 2- Finalizar Jogo <");
        System.out.println(divisoes + "\n");
    }
    public void displayMensagem(String jogador, String aviso){
        String divisoes = "*" + "-".repeat(28) + "*";
        
        System.out.print("\033[H\033[2J");
        System.out.println(divisoes);
        System.out.println("   Selecione: ");
        System.out.println(" > 9 para Finzalizar Jogo <\n > 0 para Resetar Tabuleiro <");
        System.out.println(" > ESTÁ NA VEZ DE: "+  jogador +" <\n");
        if( aviso != null){
            System.out.println(aviso(aviso));
        }
        System.out.println(divisoes + "\n");
    }
    
    private String aviso(String aviso){
        String mensagem = "";
        if (aviso.equals("empate")){
            mensagem = "  ! Não há mais posições a serem jogadas !";
        }
        else if(aviso.equals("reset")){
            mensagem = "  ! O jogo foi Resetado !";
        }
        else if(aviso.equals("indice")){
            mensagem = " ! Sua escolha deve estar entre 1 e 7 !";
        }
        else if(aviso.equals("fullCol")){
            mensagem = "  ! Essa coluna está cheia !";
        }
        
        return mensagem;
    }

}
