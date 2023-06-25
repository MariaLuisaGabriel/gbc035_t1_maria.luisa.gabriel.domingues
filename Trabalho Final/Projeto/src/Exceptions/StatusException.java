package Exceptions;

public class StatusException extends RuntimeException{
    public StatusException()
    {
        super();
    }
    public StatusException(String msg)
    {
        super(msg);
    }
}
