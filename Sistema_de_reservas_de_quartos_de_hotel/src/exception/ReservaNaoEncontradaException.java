package exception;

public class ReservaNaoEncontradaException extends Exception {

    public ReservaNaoEncontradaException() {
        super("Reserva não encontrada.");
    }
}
