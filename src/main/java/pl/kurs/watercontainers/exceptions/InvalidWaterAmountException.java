package pl.kurs.watercontainers.exceptions;

public class InvalidWaterAmountException extends RuntimeException {
    public InvalidWaterAmountException(String message) {
        super(message);
    }

    public InvalidWaterAmountException(String message, Throwable cause) {
        super(message, cause);
    }
}
