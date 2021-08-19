package Laptenkov.exceptions;

public class WorkWithExceptions
{
    /**
     * В данном методе необходимо вызвать методы throwCheckedException и throwUncheckedException.
     * Все исключения должны быть обработаны
     * Необходимо вывести описание exception и stacktrace в консоль
     * В пойманное исключение необходимо упаковать в кастомное исключение и пробросить выше
     * Перед завершением работы метода обязательно необходимо вывести в консоль сообщение "Finish"
     */
    public void exceptionProcessing() throws CustomCheckedException
    {
        try
        {
            throwUncheckedException();
            throwUncheckedException();
        }
        catch (RuntimeException re)
        {
            System.out.println("Catch UncheckedException: " + re.getMessage());
            re.getStackTrace();

            System.out.println("Throw CustomCheckedException");
            throwCustomCheckedException();
        }
        catch (Exception e)
        {
            System.out.println("Catch throwCustomCheckedException: " + e.getMessage());
            e.getStackTrace();
        }
        finally
        {
            System.out.println("Finish");
        }

    }


    /**
     * (* - необязательно) Доп. задание.
     * Выписать в javadoc (здесь) - все варианты оптимизации и устранения недочётов метода
     *
     * Step 1 - обрабатывается checked исключение IllegalArgumentException. Данное исключение относится к
     * checked исключениям и должно быть обработано.
     *
     * Step 2 - при обработке checked исключения IllegalArgumentException предполагается возникновение
     * исключения RuntimeException, данное исключение предполагается обработать.
     * Оптимизация - заменить обработку RuntimeException на обработку конкретного checked исключения, либо прописать
     * кастомное исключение учитывающее случай возникновения данного исключения.
     * Оптимизация - убрать обработку RuntimeException.
     *
     * Step 3 - отрабатывать RuntimeException нет смысла - т.к. RuntimeException наследник Exception
     * и относится к unchecked исключениям. Данные исключени возникают во время выполнения программы и
     * они не требуют обязательного заключения в блок try-catch.
     * Когда RuntimeException возникает, это свидетельствует о ошибке, допущенной программистом,
     * поэтому данное исключение не нужно обрабатывать,
     * а нужно исправлять ошибку в коде, чтобы исключение вновь не возникало.
     * Оптимизация - убрать Step 3 в части обработки RuntimeException, в данном шаге отработать
     * обработку конкретного checked исключения, либо кастномного исключения учитывающий возникновение данного случая.
     *
     * Step finally - метод finally предполагает возникновение unchecked исключения RuntimeException
     * не зависимо от отработки шагов Step 2 и Step 3. Так же отработка Step finally предполагется
     * в случаях когда вызыван System.exit() или произойдет сбой JVM.
     * Оптимизация - убрать Step finally, либо произвести закрытие потоков,
     * либо прописать кастомное исключение учитывающее случай возникновения данного исключения.
     *
     * @throws IllegalStateException
     * @throws Exception
     * @throws RuntimeException
     */
    public void hardExceptionProcessing() throws IllegalStateException, Exception, RuntimeException {
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

    /**
     * Метод вызывающий выбрасывание CustomCheckedException.
     * @throws CustomCheckedException
     */
    private void throwCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException("CustomCheckedException exception");
    }

    private void throwCheckedException() throws Exception {
        throw new Exception("Checked exception");
    }

    private void throwUncheckedException() {
        throw new RuntimeException("Unchecked exception");
    }
}
