package sbp.exceptions;

public class WorkWithExceptions
{
    /**
     * � ������ ������ ���������� ������� ������ throwCheckedException � throwUncheckedException.
     * ��� ���������� ������ ���� ����������
     * ���������� ������� �������� exception � stacktrace � �������
     * ���������� ���������� ���������� ��������� � ��������� ���������� � ���������� ����
     * ����� ����������� ������ ������ ����������� ���������� ������� � ������� ��������� "Finish"
     */
    public void exceptionProcessing()
    {
        /*
        ...
         */
    }

    /**
     * (* - �������������) ���. �������.
     * �������� � javadoc (�����) - ��� �������� ����������� � ���������� ��������� ������
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
