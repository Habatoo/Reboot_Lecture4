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
