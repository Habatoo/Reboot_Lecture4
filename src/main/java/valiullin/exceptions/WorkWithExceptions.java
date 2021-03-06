package valiullin.exceptions;

import javax.xml.bind.SchemaOutputResolver;

public class WorkWithExceptions
{
    /**
     * В данном методе необходимо вызвать методы throwCheckedException и throwUncheckedException.
     * Все исключения должны быть обработаны
     * Необходимо вывести описание exception и stacktrace в консоль
     * Впойманное исключение необходимо упаковать в кастомное исключение и пробросить выше
     * Перед завершением работы метода обязательно необходимо вывести в консоль сообщение "Finish"
     */
    public void exceptionProcessing() throws MyExeption
    {
        try {
            throwCheckedException();

        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

            throw new MyExeption("MyExeption: " + e.getMessage());
        }
        finally {
            System.out.println("Finish");
        }

    }

    /**
     * Перегруженный метод
     * @param someStr
     * @throws MyRuntimeExeption
     */
    public void exceptionProcessing(String someStr) throws MyRuntimeExeption
    {
        try {
            throwUncheckedException();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();

            throw new MyRuntimeExeption(e.getMessage());
        }
        finally {
            System.out.println("Finish " + someStr);
        }
    }

    /**
     * (* - необязательно) Доп. задание.
     * Выписать в javadoc (здесь) - все варианты оптимизации и устранения недочётов метода
     * @throws IllegalStateException
     * @throws Exception
     * @throws RuntimeException
     */
    public void hardExceptionProcessing() throws IllegalStateException, Exception, RuntimeException
    {
        System.out.println("Start");
        try
        {
            System.out.println("Step 1");
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Catch IllegalArgumentException");
            throw new RuntimeException("Step 2");
        }
        catch (RuntimeException e)
        {
            System.out.println("Catch RuntimeException");
            throw new RuntimeException("Step 3");
        }
        finally
        {
            System.out.println("Step finally");
            throw new RuntimeException("From finally");
        }
    }

    private void throwCheckedException() throws Exception
    {
        throw new Exception("Checked exception");
    }

    private void throwUncheckedException()
    {
        throw new RuntimeException("Unchecked exception");
    }
}
