package Laptenkov.exceptions;

/**
 * Custom класс обработки RuntimeException исключений
 * @author habatoo
 */
public class CustomRuntimeException extends RuntimeException
{

    /**
     * Конструктор класса {@link CustomRuntimeException}
     * со строковым параметром String message.
     * @param message
     */
    public CustomRuntimeException(String message)
    {
        super("CustomRuntimeException message " + message);
    }

    /**
     * Конструктор класса {@link CustomRuntimeException} с двумя парамтерами
     * со строковым параметром String message и Throwable cause.
     * @param message
     * @param cause
     */
    public CustomRuntimeException(String message, Throwable cause)
    {
        super("CustomRuntimeException message " + message, cause);
    }

}
