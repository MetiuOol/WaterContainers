package pl.kurs.watercontainers.exceptions;

public class InvalidLevelException extends RuntimeException {
    public InvalidLevelException(String message) {
        super(message);
    }

    public InvalidLevelException(String message, Throwable cause) {
        super(message, cause);
    }
}
