package game;

public class Mensagem {

    public void displayMensagem(String jogador, String aviso){
        String divisoes = "*" + "-".repeat(28) + "*";

        System.out.print("\033[H\033[2J");
        System.out.println('\t' + divisoes);
        System.out.println("\t  >Esolha 9 para finzalizar< \n\t  >Escolha 0 para Resetar<");
        System.out.println("\t  >está na vez de: "+  jogador +"<");
        if(! aviso.equals("")){
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
        
        return mensagem;
    }
}
