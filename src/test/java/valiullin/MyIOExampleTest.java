package valiullin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import valiullin.io.MyIOExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;

public class MyIOExampleTest {

    @AfterAll
    public static void clean(){
        File file = new File("./src/test/java/valiullin/not_exist.txt");
        file.delete();

    }

    /**
     * Работа с существующим файлом
     * Ожидаем true
     */
    @Test
    public void workWithFile_Test_with_exist_file(){
        String fileName = "./src/test/java/valiullin/test.txt";
        MyIOExample myIOExample = new MyIOExample();
        boolean result = myIOExample.workWithFile(fileName);
        Assertions.assertEquals(result, false);
    }

    /**
     * Работа с несуществующим файлом
     * Ожидаем false
     */
    @Test
    public void workWithFile_Test_with_not_exist_file(){
        String fileName = "./src/test/java/valiullin/not_exist.txt";
        MyIOExample myIOExample = new MyIOExample();
        boolean result = myIOExample.workWithFile(fileName);
        Assertions.assertEquals(result, true);
    }


}
