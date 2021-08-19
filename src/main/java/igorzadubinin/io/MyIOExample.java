package igorzadubinin.io;

import java.io.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class MyIOExample
{
    /**
     * Создать объект класса {@link File}, проверить существование и чем является (фалй или директория).
     * Если сущность существует, то вывести в консоль информацию:
     *      - абсолютный путь
     *      - родительский путь
     * Если сущность является файлом, то вывести в консоль:
     *      - размер
     *      - время последнего изменения
     * Необходимо использовать класс {@link File}
     * @param fileName - имя файла
     * @return - true, если файл успешно создан
     */
    public boolean workWithFile(String fileName) throws IOException
    {
        File file = new File(fileName);
        boolean isFileCreated = false;
        if (file.exists()) {
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());
            System.out.println("Родительский путь: " + file.getAbsoluteFile().getParent());
            if (file.isFile()) {
                System.out.println("Размер (в байтах): " + file.length());
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
                String lastModified = dtf.format(Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()));
                System.out.println("Время последнего изменения: " + lastModified);
            }
        }
        else
            isFileCreated = file.createNewFile();
        return isFileCreated;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link FileInputStream} и {@link FileOutputStream}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyFile(String sourceFileName, String destinationFileName)
    {
        boolean fileCopied = true;
        try(FileInputStream input = new FileInputStream(sourceFileName);
            FileOutputStream output = new FileOutputStream(destinationFileName))
        {
            byte[] buffer = new byte[65536];
            while (input.available() > 0)
            {
                int real = input.read(buffer);
                output.write(buffer, 0, real);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Исходный файл не найден");
            fileCopied = false;
        }
        catch (IOException e) {
            e.printStackTrace();
            fileCopied = false;
        }
        return fileCopied;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link BufferedInputStream} и {@link BufferedOutputStream}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyBufferedFile(String sourceFileName, String destinationFileName)
    {
        boolean fileCopied = true;
        try(FileInputStream input = new FileInputStream(sourceFileName);
            FileOutputStream output = new FileOutputStream(destinationFileName);
            BufferedInputStream bis = new BufferedInputStream(input);
            BufferedOutputStream bos = new BufferedOutputStream(output)) {
            int i;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Исходный файл не найден");
            fileCopied = false;
        }
        catch (IOException e) {
            e.printStackTrace();
            fileCopied = false;
        }
        return fileCopied;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link FileReader} и {@link FileWriter}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyFileWithReaderAndWriter(String sourceFileName, String destinationFileName)
    {
        boolean fileCopied = true;
        try(FileReader reader = new FileReader(sourceFileName);
            FileWriter writer = new FileWriter(destinationFileName)) {
            char[] buffer = new char[65536];
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(buffer, 0, real);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Исходный файл не найден");
            fileCopied = false;
        }
        catch (IOException e) {
            e.printStackTrace();
            fileCopied = false;
        }
        return fileCopied;
    }
}
