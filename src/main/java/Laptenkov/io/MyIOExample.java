package Laptenkov.io;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.*;

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
        if (null != file && file.exists() ) {
            out.println(file.getAbsolutePath());
            out.println(file.getParent());

            if (file.isFile())
            {
                out.println(file.length());
                out.println(file.lastModified());

                return true;
            }

        }

        return false;
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
        try
        {
            InputStream fileInputStream = new FileInputStream(sourceFileName);
            OutputStream fileOutputStream = new FileOutputStream(destinationFileName);

            while (fileInputStream.available() > 0)
            {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();

            return workWithFile(destinationFileName) && checkFileContentEqual(sourceFileName, destinationFileName);
        }

        catch (IOException ioException)
        {

            return false;
        }

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
        try
        {
            InputStream fileInputStream = new FileInputStream(sourceFileName);
            OutputStream fileOutputStream = new FileOutputStream(destinationFileName);

            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            while (bufferedInputStream.available() > 0)
            {
                bufferedOutputStream.write(bufferedInputStream.read());
            }

            bufferedOutputStream.close();;
            bufferedInputStream.close();

            fileOutputStream.close();
            fileInputStream.close();

            return workWithFile(destinationFileName) && checkFileContentEqual(sourceFileName, destinationFileName);
        }

        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
            return false;
        }

        catch (IOException ioException)
        {
            ioException.printStackTrace();
            return false;
        }

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

        File sourceFile = new File(sourceFileName);
        File destinationFile = new File(destinationFileName);

        try
        {
            Reader reader = new FileReader(sourceFile);
            Writer writer = new FileWriter(destinationFile);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                writer.write(line + System.lineSeparator());
            }

            writer.close();
            reader.close();

            return workWithFile(destinationFileName) && checkFileContentEqual(sourceFileName, destinationFileName);
        }

        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
            return false;
        }

        catch (IOException ioException)
        {
            ioException.printStackTrace();
            return false;
        }

    }

    /**
     * Метод {@link MyIOExample#checkFileContentEqual} проверяет идентичность
     * двух файлов.
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя созданной копии файла
     * @return - true, если файлы идентичны, false, если файлы отличаются.
     */
    public boolean checkFileContentEqual(String sourceFileName, String destinationFileName)
    {

        try
        {
            InputStream fileInputStream = new FileInputStream(sourceFileName);
            InputStream fileOutputStream = new FileInputStream(destinationFileName);

            while (fileInputStream.available() > 0)
            {
                int dataInput = fileInputStream.read();
                int dataOutput = fileOutputStream.read();
                if (!(dataInput == dataOutput))
                {
                    return false;
                }
            }

            fileOutputStream.close();
            fileInputStream.close();

            return true;

        }

        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
            return false;
        }

        catch (IOException ioException)
        {
            ioException.printStackTrace();
            return false;
        }

    }
}