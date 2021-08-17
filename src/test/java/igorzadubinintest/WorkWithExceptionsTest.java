package igorzadubinintest;

import igorzadubinin.exceptions.MyException;
import igorzadubinin.exceptions.WorkWithExceptions;
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
     */
    @Test
    void exceptionProcessing_Test() throws MyException {
        workWithExceptions.exceptionProcessing();
    }
}