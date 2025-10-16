package exception;

public class QuartoOcupadoException extends Exception {
    
    public QuartoOcupadoException() {
        super("O quarto selecionado já está ocupado.");
    }

}
