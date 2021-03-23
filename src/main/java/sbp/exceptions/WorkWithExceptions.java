package sbp.exceptions;

public class WorkWithExceptions
{
    /**
     * В данном методе необходимо вызвать методы throwCheckedException и throwUncheckedException.
     * Все исключения должны быть обработаны
     * Необходимо вывести описание exception и stacktrace в консоль
     * Впойманное исключение необходимо упаковать в кастомное исключение и пробросить выше
     * Перед завершением работы метода обязательно необходимо вывести в консоль сообщение "Finish"
     */
    public void exceptionProcessing()
    {

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
