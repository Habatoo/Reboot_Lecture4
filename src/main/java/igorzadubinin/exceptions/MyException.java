package igorzadubinin.exceptions;

public class MyException extends Exception {
    public MyException(Throwable cause) {
        super("My Exception", cause);
    }
}
