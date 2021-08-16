package valiullin;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import valiullin.io.MyIOExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;

public class MyIOExampleTest {

    String path;
    MyIOExample myIOExample;

    @BeforeEach
    public void init(){
        path = "./src/test/java/valiullin/";
        myIOExample = new MyIOExample();
    }

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
        String fileName = path + "test.txt";
        boolean result = myIOExample.workWithFile(fileName);
        Assertions.assertEquals(result, false);
    }

    /**
     * Работа с несуществующим файлом
     * Ожидаем false
     */
    @Test
    public void workWithFile_Test_with_not_exist_file(){
        String fileName = path + "not_exist.txt";
        boolean result = myIOExample.workWithFile(fileName);
        Assertions.assertEquals(result, true);
    }


    /**
     * Пытаемся скопировать файл
     * Ожидаем true
     */
    @Test
    public void copyFile_Test(){
        String sourceFileName = path + "sourceFile.txt";
        String destinationFileName = path + "destinationFile.txt";

        boolean result = myIOExample.copyFile(sourceFileName, destinationFileName);
        Assertions.assertEquals(result, true);
    }


    /**
     * Пытаемся скопировать файл
     * Ожидаем true
     */
    @Test
    public void copyBufferedFile_Test(){
        String sourceFileName = path + "sourceFile.txt";
        String destinationFileName = path + "destinationFile.txt";

        boolean result = myIOExample.copyBufferedFile(sourceFileName, destinationFileName);
        Assertions.assertEquals(result, true);
    }

    /**
     * Пытаемся скопировать файл
     * Ожидаем true
     */
    @Test
    public void copyFileWithReaderAndWriter_Test(){
        String sourceFileName = path + "sourceFile.txt";
        String destinationFileName = path + "destinationFile.txt";

        boolean result = myIOExample.copyFileWithReaderAndWriter(sourceFileName, destinationFileName);
        Assertions.assertEquals(result, true);
    }


}
