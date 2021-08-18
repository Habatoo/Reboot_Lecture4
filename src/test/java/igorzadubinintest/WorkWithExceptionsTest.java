package igorzadubinintest;

import igorzadubinin.exceptions.MyException;
import igorzadubinin.exceptions.WorkWithExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class WorkWithExceptionsTest {
    WorkWithExceptions workWithExceptions;

    /**
     * Создание объекта тестируемого класса WorkWithExceptions
     */
    @BeforeEach
    void init() {
        workWithExceptions = new WorkWithExceptions();
    }

    /**
     * Тестирование работы метода {@link WorkWithExceptions#exceptionProcessing()}
     * Проверяется: метод должен выбросить исключение {@link MyException}
     * Перед завершением работы метода выводится сообщение Finish.
     */
    @Test
    void exceptionProcessing_Test() throws MyException {
        Assertions.assertThrows(MyException.class, () -> {
            workWithExceptions.exceptionProcessing();
        });
    }
}