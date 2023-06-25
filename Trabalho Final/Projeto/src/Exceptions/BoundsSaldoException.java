package Exceptions;

public class BoundsSaldoException extends RuntimeException{
    public BoundsSaldoException(String s)
    {
        super(s);
    }
    public BoundsSaldoException()
    {
        super();
    }
}
