package exception;

public class QuantidadeDeDiasInvalidaException extends Exception {

    public QuantidadeDeDiasInvalidaException() {
        super("Quantidade de dias inválida. Diária miníma: 01");
    }

}
