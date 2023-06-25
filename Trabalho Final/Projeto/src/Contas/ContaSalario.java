package Contas;

import Exceptions.SenhaException;

import java.util.Date;

public class ContaSalario extends Conta{
    private double limSaque, limTransf;
    public ContaSalario(String senha, String nroConta, double lims, double limt){
        super(senha, nroConta);
        limSaque = lims;
        limTransf = limt;
    }

    public ContaSalario(String senha, String nroConta){
        super(senha, nroConta);
        limSaque = 1500;
        limTransf = 1500;
    }

    public ContaSalario()
    {
        super();
    }

    public double getLimSaque() {
        return limSaque;
    }

    public double getLimTransf() {
        return limTransf;
    }

    public void printConta(String psw)
    {
        try
        {
            super.printConta(psw);
        }
        catch(SenhaException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(psw.equals(senha))
                System.out.println("Limite de Saque: "+limSaque
                        +"\nLimite de Transferencia: "+limTransf);
        }
    }

    public void addTransacao(TransacaoBancaria transacao) throws NullPointerException{
        if(transacao!=null)
            transacoes.add(transacao);
        else throw new NullPointerException("transacao inexistente");
    }
}
