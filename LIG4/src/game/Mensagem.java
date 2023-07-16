package game;

public class Mensagem {
    private String divisoes = "*" + "-".repeat(28) + "*";

    public void displayMensagem(String jogador, String aviso){

        System.out.print("\033[H\033[2J");
        System.out.println('\t' + divisoes);
        System.out.println("\t  >Esolha 9 para finzalizar< \n\t  >Escolha 0 para Resetar< ");
        System.out.println("\t  >está na vez de: "+  jogador +"<");
        if( aviso != null){
            System.out.println(aviso(aviso));
        }
        System.out.println('\t' + divisoes + "\n");
    }

    public String aviso(String aviso){
        String mensagem = "";
        if (aviso.equals("empate")){
            mensagem = "\t  ! Não há mais posições a serem jogadas !";
        }
        else if(aviso.equals("reset")){
            mensagem = "\t  ! O jogo foi Resetado !";
        }
        else if(aviso.equals("indice")){
            mensagem = "\t  ! Sua escolha deve estar entre 1 e 7 !";
        }
        else if(aviso.equals("fullCol")){
            mensagem = "\t  ! Essa coluna está cheia !";
        }
        
        return mensagem;
    }

    public void displayVitoria(String jogador){
        System.out.print("\033[H\033[2J");
        System.out.println('\t' + divisoes + "\n");
        System.out.println("\t| !! Vitória de " + jogador +"!!  |");
        System.out.println('\t' + divisoes + "\n");

        // opções de voltar ou menu, sair ou jogar novamente
    }
}
