package Exceptions;

public class SenhaException extends RuntimeException{
    public SenhaException()
    {
        super();
    }
    public SenhaException(String msg)
    {
        super(msg);
    }
}
