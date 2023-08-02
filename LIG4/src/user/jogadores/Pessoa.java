package user.jogadores;

public abstract class Pessoa {
    
    private String nome;
    private int wins = 0;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void addWin(){
        this.wins += 1;
    }
    public int getWins(){
        return wins;
    }
}
