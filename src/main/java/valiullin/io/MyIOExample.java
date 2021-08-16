package valiullin.io;

import java.io.File;
import java.io.IOException;

public class MyIOExample
{
    /**
     * Создать объект класса {@link java.io.File}, проверить существование и чем является (фалй или директория).
     * Если сущность существует, то вывести в консоль информацию:
     *      - абсолютный путь
     *      - родительский путь
     * Если сущность является файлом, то вывести в консоль:
     *      - размер
     *      - время последнего изменения
     * Необходимо использовать класс {@link java.io.File}
     * @param fileName - имя файла
     * @return - true, если файл успешно создан
     */
    public boolean workWithFile(String fileName){
        File file = new File(fileName);

        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getParent());
            System.out.println("----------");

            if (file.isFile()) {
                System.out.println("It is file:");
                System.out.println(file.length());
                System.out.println(file.lastModified());
            }

        } else {

            try{
                if (file.createNewFile()) {
                    System.out.println("File has been created");
                    return true;
                }
            }
            catch (IOException e){
                System.out.println("File was not created");
            }
        }

        return false;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link java.io.FileInputStream} и {@link java.io.FileOutputStream}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyFile(String sourceFileName, String destinationFileName)
    {
        /*
        ...
         */
        return false;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link java.io.BufferedInputStream} и {@link java.io.BufferedOutputStream}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyBufferedFile(String sourceFileName, String destinationFileName)
    {
        /*
        ...
         */
        return false;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link java.io.FileReader} и {@link java.io.FileWriter}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyFileWithReaderAndWriter(String sourceFileName, String destinationFileName)
    {
        /*
        ...
         */
        return false;
    }
}
