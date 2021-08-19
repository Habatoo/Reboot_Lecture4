package Laptenkov.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Тестирование методов класса {@link MyIOExample}.
 * @author habatoo
 */
public class MyIOExampleTest
{

    private MyIOExample myIOExample;

    /**
     * Файлы созданные для тестов.
     * {@link MyIOExampleTest#file} объект файл.
     * {@link MyIOExampleTest#sourceFileName_test} исходный файл.
     * {@link MyIOExampleTest#destinationFileName_test} файл в который будет осуществлено копирование.
     */
    private File file;
    private String sourceFileName_test = "MyFile";
    private String destinationFileName_test = "MyFileTest";

    /**
     * Инициализация экземпляра тестируемого класса {@link MyIOExample}
     * и объекта {@link File# file}.
     */
    @BeforeEach
    void setUp()
    {
        myIOExample = new MyIOExample();
        file = new File(sourceFileName_test);
    }

    /**
     * Удаление файла {@link MyIOExampleTest#destinationFileName_test}
     * в который производится копирование.
     */
    @AfterEach
    void clearFile()
    {
        file = new File(destinationFileName_test);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyIOExample#workWithFile(String)},
     * при подаче входящуго параметра типа String с адресом файла
     * {@link MyIOExample#workWithFile#fileName}.
     * <br>Сценарий, при котором файл существует метод {@link MyIOExample#workWithFile(String)}
     * возвращает <code>true</code>.
     * @return - true;
     */
    @Test
    void workWithFileExistsObject_Test() throws IOException
    {
        boolean result = myIOExample.workWithFile(sourceFileName_test);
        Assertions.assertEquals(result, true);
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyIOExample#workWithFile(String)},
     * при подаче входящуго параметра типа String с адресом не существующего файла.
     * <br>Сценарий, при котором файл не существует метод {@link MyIOExample#workWithFile(String)}
     * возвращает <code>false</code>.
     * @return - false;
     */
    @Test
    void workWithFileNotExistsObject_Test() throws IOException
    {
        boolean result = myIOExample.workWithFile(destinationFileName_test);
        Assertions.assertEquals(result, false);
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyIOExample#workWithFile(String)},
     * при подаче входящуго параметра типа String с адресом директории
     * {@link MyIOExample#workWithFile#destinationFileName}.
     * <br>Сценарий, при котором файл не существует метод {@link MyIOExample#workWithFile(String)}
     * возвращает <code>false</code>.
     * @return - false;
     */
    @Test
    void workWithFileNotFile_Test() throws IOException
    {
        boolean result = myIOExample.workWithFile("/");
        Assertions.assertEquals(result, false);
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyIOExample#copyFile(String, String)},
     * при подаче входящуго параметра типа String с адресом существующего файла
     * {@link MyIOExample#copyFile#sourceFileName}.
     * <br>Сценарий, при котором файл скопирован {@link MyIOExample#copyFile(String, String)}
     * возвращает <code>true</code>, скопированный файл расположен
     * {@link MyIOExample#copyFile#destinationFileName}.
     * @return - true;
     */
    @Test
    void copyFileSuccess_Test()
    {
        boolean result = myIOExample.copyFile(sourceFileName_test, destinationFileName_test);
        Assertions.assertEquals(result, true);
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyIOExample#copyFile(String, String)},
     * при подаче входящуго параметра типа String с адресом не существующего файла.
     * <br>Сценарий, при котором файл не скопирован {@link MyIOExample#copyFile(String, String)}
     * возвращает <code>false</code>.
     * @return - false;
     */
    @Test
    void copyFileFail_Test()
    {
        boolean result = myIOExample.copyFile("failAddress", destinationFileName_test);
        Assertions.assertEquals(result, false);
    }

    /**
     * Проверка значения, которое возвращает метод
     * {@link MyIOExample#copyBufferedFile(String, String)},
     * при подаче входящуго параметра типа String с адресом существующего файла
     * {@link MyIOExample#copyBufferedFile#sourceFileName}.
     * <br>Сценарий, при котором файл скопирован
     * {@link MyIOExample#copyBufferedFile(String, String)}
     * возвращает <code>true</code>, , скопированный файл расположен
     * {@link MyIOExample#copyBufferedFile#destinationFileName}.
     * @return - true;
     */
    @Test
    void copyBufferedFileSuccess_Test()
    {
        boolean result = myIOExample.copyBufferedFile(sourceFileName_test, destinationFileName_test);
        Assertions.assertEquals(result, true);
    }

    /**
     * Проверка значения, которое возвращает метод
     * {@link MyIOExample#copyBufferedFile(String, String)},
     * при подаче входящуго параметра типа String с адресом не существующего файла.
     * <br>Сценарий, при котором файл не скопирован {@link MyIOExample#workWithFile(String)}
     * возвращает <code>false</code>.
     * @return - false;
     */
    @Test
    void copyBufferedFileFail_Test()
    {
        boolean result = myIOExample.copyBufferedFile(
                "failAddress", destinationFileName_test);
        Assertions.assertEquals(result, false);
    }

    /**
     * Проверка значения, которое возвращает метод
     * {@link MyIOExample#copyFileWithReaderAndWriter(String, String)},
     * при подаче входящуго параметра типа String с адресом существующего файла
     * {@link MyIOExample#copyFileWithReaderAndWriter#sourceFileName}.
     * <br>Сценарий, при котором файл скопирован
     * {@link MyIOExample#copyFileWithReaderAndWriter(String, String)}
     * возвращает <code>true</code>, , скопированный файл расположен
     * {@link MyIOExample#copyFileWithReaderAndWriter#destinationFileName}.
     * @return - true;
     */
    @Test
    void copyFileWithReaderAndWriterSuccess_Test()
    {
        boolean result = myIOExample.copyFileWithReaderAndWriter(
                sourceFileName_test, destinationFileName_test);
        Assertions.assertEquals(result, true);
    }

    /**
     * Проверка значения, которое возвращает метод
     * {@link MyIOExample#copyFileWithReaderAndWriter(String, String)},
     * при подаче входящуго параметра типа String с адресом не существующего файла.
     * <br>Сценарий, при котором файл не скопирован
     * {@link MyIOExample#copyFileWithReaderAndWriter(String, String)}
     * возвращает <code>false</code>.
     * @return - false;
     */
    @Test
    void copyFileWithReaderAndWriterFail_Test()
    {
        boolean result = myIOExample.copyFileWithReaderAndWriter(
                "failAddress", destinationFileName_test);
        Assertions.assertEquals(result, false);
    }

}