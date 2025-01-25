package ar.com.old.challenge_foro_hub.exceptions;

public class IncorrectLoginException extends RuntimeException {
    public IncorrectLoginException(String message) {
        super(message);
    }
}
