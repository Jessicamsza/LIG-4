package exceptions;

public class NomeException extends Exception {
    public NomeException(String motivo){
        super("Nome inválido: " + motivo);
    }
}
