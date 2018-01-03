package exceptions;

public class DBException extends Exception {
    public DBException() {
        super();
    }

    public DBException(String message) {
        super(message);
    }
}
