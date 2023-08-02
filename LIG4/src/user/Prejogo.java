package user;
import exceptions.ForaDoIndice;
import exceptions.NomeException;
import game.Jogo;

public class Prejogo {

    private Jogo jogo;
    private String modoJogo;
    private boolean singlePlayer = false;
    private String nome1 = "Jogador 1";
    private String nome2 = "Jogador 2";

    public void escolherModo(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t MODO DE JOGO");
        System.out.println(" 1- Modo Clássico");
        System.out.println(" 2- LIG4 Turbo (ao fazer a jogada, transforma as peças vizinhas horizontalmente na sua peça)");
        System.out.println(" 3- LIG4 Turbo Maluco (todas as peças vizinhas tem chance de virarem sua peça, de acordo com a probabilidade escolhida a seguir)");
        while(true){
            try{
                int escolha = InputHandler.getIntInput(3);
                if(escolha ==1){
                    modoJogo = "normal";
                }
                else if (escolha ==2){
                    modoJogo = "turbo";
                }
                else if(escolha == 3){
                    modoJogo = escolherNivelMaluco();
                }
                break;
            } catch(ForaDoIndice e){
                System.out.println(e.getMessage());
            }

        }
        escolherJogadores();
        jogo = new Jogo(modoJogo, singlePlayer,nome1, nome2);
        jogo.jogar();     
    }

    
    private void escolherJogadores(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t JOGADORES");
        System.out.println(" 1 - jogar com 2 Jogadores");
        System.out.println(" 2 - jogar Contra a Máquina");
        while(true){
            try{
                int escolha = InputHandler.getIntInput(2);
                if(escolha == 1) {
                    break;
                }
                else if (escolha ==2){
                    this.singlePlayer = true;
                    this.nome2 = "Máquina";
                    break;
                }
            } catch(ForaDoIndice e){
                System.out.println(e.getMessage());
            }
            
        }

        System.out.print("\033[H\033[2J");
        System.out.println("\t\t NOME DOS JOGADORES");
        System.out.println("  Digite \"1\" para pular essa etapa");

        
        while(true){
            System.out.print("digite o nome do jogador 1 --> ");
            this.nome1 = InputHandler.getStringInput();

            if(this.nome1.equals("1")){
                this.nome1 = "Jogador 1";
                return;
            }

            try{
                validarNome(this.nome1);
                break;
            }catch(NomeException e){
                System.out.println(e.getMessage());
            }
        }


        if (!singlePlayer){
            while(true){
                System.out.print("digite o nome do jogador 2 --> ");
                this.nome2 = InputHandler.getStringInput();

                if(this.nome2.equals("1")){
                    this.nome2 = "Jogador 2";
                    return;
                }

                try{
                    validarNome(this.nome2);
                    break;
                }catch(NomeException e){
                    System.out.println(e.getMessage());
                }
        }  

        }
    }
    
    private String escolherNivelMaluco(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t Escolha o NÍVEL DE MALUQUICE");
        System.out.println(" 1- Leve (10%)");
        System.out.println(" 2- Controlável (30%)");
        System.out.println(" 3- Super Maluco (60%)");
        while(true){
            try{
                int escolha = InputHandler.getIntInput(3);
                if(escolha ==1){
                    return "turbo maluco 1";
                }
                else if (escolha ==2){
                    return "turbo maluco 2";
                }
                else if (escolha ==3){
                    return "turbo maluco 3";
                }
            } catch(ForaDoIndice e){
                System.out.println(e.getMessage());
            }
    
        }
    }

    private void validarNome(String nome) throws NomeException{
        if (nome.length() < 3){
             throw new NomeException("devem haver no Mínimo 3 caracteres");
        } 
        else if(nome.length() > 8) {
            throw new NomeException("devem haver no Máximo 8 caracteres");
        }
        int letterCount = 0;
        for (char c : nome.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount +=1;
            }
        }
        if(letterCount < 3){
            throw new NomeException("devem haver Pelo Menos 3 LETRAS");
        }
    }
}
