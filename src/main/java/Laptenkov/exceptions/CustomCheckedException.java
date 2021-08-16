package Laptenkov.exceptions;

/**
 * Custom класс обработки Checked исключений
 * @author habatoo
 */
public class CustomCheckedException extends Exception
{

    /**
     * Конструктор класса {@link CustomCheckedException}
     * со строковым параметром String message.
     * @param message
     */
    public CustomCheckedException(String message)
    {
        super("CustomException message " + message);
    }

    /**
     * Конструктор класса {@link CustomCheckedException} с двумя парамтерами
     * со строковым параметром String message и Throwable cause.
     * @param message
     * @param cause
     */
    public CustomCheckedException(String message, Throwable cause)
    {
        super("CustomException message " + message, cause);
    }
}