package igorzadubinintest;

import igorzadubinin.io.MyIOExample;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MyIOExampleTest {
    MyIOExample myIOExample;
    final String TEST_DATA_DIR = "src\\test\\java\\igorzadubinintest\\TestData\\MyIOExampleTest\\";

    /**
     * Создание объекта тестируемого класса MyIOExample
     */
    @BeforeEach
    void init() {
        myIOExample = new MyIOExample();
    }

    /**
     * Тестирование метода {@link MyIOExample#workWithFile(String)}
     * Сценарий 1: Сущность существует, является файлом
     * Проверяется:
     * 1. Выводимые значения соответствуют реальным параметрам файла
     * 2. Метод возвращает false
     *
     */
    @Test
    void workWithFileS1_Test() throws IOException {
        final String fileName = TEST_DATA_DIR + "workWithFileS1\\File.txt";
        Assertions.assertFalse(myIOExample.workWithFile(fileName));
    }

    /**
     * Тестирование метода {@link MyIOExample#workWithFile(String)}
     * Сценарий 2: Сущность существует, является папкой
     * Проверяется:
     * 1. Выводимые значения соответствуют реальным параметрам папки
     * 2. Метод возвращает false
     */
    @Test
    void workWithFileS2_Test() throws IOException {
        final String fileName = TEST_DATA_DIR + "workWithFileS2\\Folder";
        Assertions.assertFalse(myIOExample.workWithFile(fileName));
    }

    /**
     * Тестирование метода {@link MyIOExample#workWithFile(String)}
     * Сценарий 3: Сущность не существует
     * Проверяется:
     * 1. Метод возвращает true
     * 2. Файл успешно создан
     */
    @Test
    void workWithFileS3_Test() throws IOException {
        final String fileName = TEST_DATA_DIR + "workWithFileS3\\NewFile.txt";
        Assertions.assertTrue(myIOExample.workWithFile(fileName));
    }

    /**
     * Тестирование метода {@link MyIOExample#copyFile(String, String)}
     * Сценарий 1: Исходный файл отсутствует.
     * Проверяется:
     * 1. Файл 2 не создавался, либо остался без изменений.
     * 2. Метод вернул false.
     */
    @Test
    void copyFileS1_Test() {
        final String sourceFileName = TEST_DATA_DIR + "copyFileS1\\File1.txt";
        final String destinationFileName = TEST_DATA_DIR + "copyFileS1\\File2.txt";
        File file2 = new File(destinationFileName);
        Long file2LastModified = file2.lastModified();
        Assertions.assertFalse(myIOExample.copyFile(sourceFileName, destinationFileName));
        Assertions.assertEquals(file2LastModified, file2.lastModified());
    }

    /**
     * Тестирование метода {@link MyIOExample#copyFile(String, String)}
     * Сценарий 2: Исходный файл присутствует.
     * Проверяется:
     * 1. Скопированный файл аналогичен исходному.
     * 2. Метод вернул true.
     */
    @Test
    void copyFileS2_Test() throws IOException {
        final String sourceFileName = TEST_DATA_DIR + "copyFileS2\\File1.txt";
        final String destinationFileName = TEST_DATA_DIR + "copyFileS2\\File2.txt";
        File file1 = new File(sourceFileName);
        File file2 = new File(destinationFileName);
        Assertions.assertTrue(myIOExample.copyFile(sourceFileName, destinationFileName));
        Assertions.assertTrue(FileUtils.contentEquals(file1, file2));
    }

    /**
     * Тестирование метода {@link MyIOExample#copyBufferedFile(String, String)}
     * Сценарий 1: Исходный файл отсутствует.
     * Проверяется:
     * 1. Файл 2 не создавался, либо остался без изменений.
     * 2. Метод вернул false.
     */
    @Test
    void copyBufferedFileS1_Test() {
        final String sourceFileName = TEST_DATA_DIR + "copyFileS1\\File1.txt";
        final String destinationFileName = TEST_DATA_DIR + "copyFileS1\\File2.txt";
        File file2 = new File(destinationFileName);
        Long file2LastModified = file2.lastModified();
        Assertions.assertFalse(myIOExample.copyBufferedFile(sourceFileName, destinationFileName));
        Assertions.assertEquals(file2LastModified, file2.lastModified());
    }

    /**
     * Тестирование метода {@link MyIOExample#copyBufferedFile(String, String)}
     * Сценарий 2: Исходный файл присутствует.
     * Проверяется:
     * 1. Скопированный файл аналогичен исходному.
     * 2. Метод вернул true.
     */
    @Test
    void copyBufferedFileS2_Test() throws IOException {
        final String sourceFileName = TEST_DATA_DIR + "copyFileS2\\File1.txt";
        final String destinationFileName = TEST_DATA_DIR + "copyFileS2\\File2.txt";
        File file1 = new File(sourceFileName);
        File file2 = new File(destinationFileName);
        Assertions.assertTrue(myIOExample.copyBufferedFile(sourceFileName, destinationFileName));
        Assertions.assertTrue(FileUtils.contentEquals(file1, file2));
    }

    /**
     * Тестирование метода {@link MyIOExample#copyFileWithReaderAndWriter(String, String)}
     * Сценарий 1: Исходный файл отсутствует.
     * Проверяется:
     * 1. Файл 2 не создавался, либо остался без изменений.
     * 2. Метод вернул false.
     */
    @Test
    void copyFileWithReaderAndWriterS1_Test() {
        final String sourceFileName = TEST_DATA_DIR + "copyFileS1\\File1.txt";
        final String destinationFileName = TEST_DATA_DIR + "copyFileS1\\File2.txt";
        File file2 = new File(destinationFileName);
        Long file2LastModified = file2.lastModified();
        Assertions.assertFalse(myIOExample.copyFileWithReaderAndWriter(sourceFileName, destinationFileName));
        Assertions.assertEquals(file2LastModified, file2.lastModified());
    }

    /**
     * Тестирование метода {@link MyIOExample#copyFileWithReaderAndWriter(String, String)}
     * Сценарий 2: Исходный файл присутствует.
     * Проверяется:
     * 1. Скопированный файл аналогичен исходному.
     * 2. Метод вернул true.
     */
    @Test
    void copyFileWithReaderAndWriterS2_Test() throws IOException {
        final String sourceFileName = TEST_DATA_DIR + "copyFileS2\\File1.txt";
        final String destinationFileName = TEST_DATA_DIR + "copyFileS2\\File2.txt";
        File file1 = new File(sourceFileName);
        File file2 = new File(destinationFileName);
        Assertions.assertTrue(myIOExample.copyFileWithReaderAndWriter(sourceFileName, destinationFileName));
        Assertions.assertTrue(FileUtils.contentEquals(file1, file2));
    }


}