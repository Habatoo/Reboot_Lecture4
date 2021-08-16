package valiullin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import valiullin.exceptions.MyExeption;
import valiullin.exceptions.MyRuntimeExeption;
import valiullin.exceptions.WorkWithExceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import static org.mockito.ArgumentMatchers.anyString;

public class WorkWithExceptionTest {

    /**
     * Ожидаем исключение MyExeption
     */
    @Test
    public void exceptionProcessing_Test_Exeption(){
        WorkWithExceptions workWithException = new WorkWithExceptions();

        try {
            workWithException.exceptionProcessing();
        }
        catch (MyExeption e){
            Assertions.assertEquals(e.getMessage().contains("MyExeption"), true);
        }
    }

    /**
     * Ожидаем исключение MyRuntimeExeption
     */
    @Test
    public void exceptionProcessing_Test_Runtime_Exeption(){
        WorkWithExceptions workWithException = new WorkWithExceptions();

        try {
            workWithException.exceptionProcessing("runtime exeption");
        }
        catch (MyRuntimeExeption e){
            Assertions.assertEquals(e.getMessage().contains("MyRuntimeExeption"), true);
        }
    }
}
