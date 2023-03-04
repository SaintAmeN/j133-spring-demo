package pl.sda.j133.demo.exception;

public class IllegalValueException extends RuntimeException {
    public IllegalValueException(String nazwa) {
        super("Niepoprawna wartość pola: " + nazwa);
    }
}
