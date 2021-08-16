package valiullin.io;

import java.io.*;

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
        File sourceFile = new File(sourceFileName);
        File destinationFile = new File(destinationFileName);

        try {
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

            int i;
            while((i=fileInputStream.read())!= -1){
                fileOutputStream.write((char)i);
            }

            fileInputStream.close();
            fileOutputStream.close();

            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

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
        File sourceFile = new File(sourceFileName);
        File destinationFile = new File(destinationFileName);

        try {
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            int i;
            while((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write((char)i);
            }

            bufferedInputStream.close();
            bufferedOutputStream.close();

            fileInputStream.close();
            fileOutputStream.close();

            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

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
        File sourceFile = new File(sourceFileName);
        File destinationFile = new File(destinationFileName);

        try {
            FileReader fileReader = new FileReader(sourceFile);
            FileWriter fileWriter = new FileWriter(destinationFile);

            int i;
            while((i = fileReader.read()) != -1) {
                fileWriter.write((char)i);
            }

            fileReader.close();
            fileWriter.close();

            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}
