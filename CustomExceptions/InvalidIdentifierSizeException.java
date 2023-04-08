package CustomExceptions;

public class InvalidIdentifierSizeException extends Exception {
    public InvalidIdentifierSizeException(String msg) {
        super(msg);
    }
}