package Laptenkov.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WorkWithExceptionsTest {

    private WorkWithExceptions workWithExceptions;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Инициализация экземпляра тестируемого класса {@link WorkWithExceptions}.
     * Инициализация экземпляра класса {@link PrintStream} для контроля отображаемых сообщений.
     */
    @BeforeEach
    void setUp()
    {
        workWithExceptions = new WorkWithExceptions();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Восстановление состояния переменной {@link WorkWithExceptions# outContent}
     * для контроля отображаемых сообщений.
     */
    @AfterEach
    void restoreStreams()
    {
        System.setOut(originalOut);
    }

    /**
     * Метод exceptionProcessing_Test проверяет работу метода {@link WorkWithExceptions#exceptionProcessing}
     * при вызове методов {@link WorkWithExceptions# throwCheckedException} и
     * {@link WorkWithExceptions# throwUncheckedException}.
     *
     * Сценарий, при котором метод отрабатывает и выбрасывает кастомное исключение CustomCheckedException
     * и возвращает сообщение
     * <br>
     * <br>Catch UncheckedException: Unchecked exception
     * <br>Throw CustomCheckedException
     * <br>Finish
     */
    @Test
    public void exceptionProcessing_Test()
    {
        Throwable throwable = Assertions.assertThrows(
                CustomCheckedException.class, () -> workWithExceptions.exceptionProcessing());
        Assertions.assertEquals(
                "CustomException message CustomCheckedException exception", throwable.getMessage());
        Assertions.assertEquals("Catch UncheckedException: Unchecked exception" + System.lineSeparator() +
                "Throw CustomCheckedException" + System.lineSeparator() +
                "Finish", outContent.toString().trim());
    }

    /**
     * Метод hardExceptionProcessing_Test проверяет работу метода {@link WorkWithExceptions#hardExceptionProcessing}
     * Сценарий при вызове метода {@link WorkWithExceptions#hardExceptionProcessing}
     * выбрасывается
     * @throws IllegalStateException
     * @throws Exception
     * @throws RuntimeException
     */
    @Test
    public void hardExceptionProcessing_Test() throws RuntimeException
    {

        Throwable throwable = Assertions.assertThrows(RuntimeException.class, () -> workWithExceptions.hardExceptionProcessing());
        Assertions.assertEquals("From finally", throwable.getMessage());

    }

}