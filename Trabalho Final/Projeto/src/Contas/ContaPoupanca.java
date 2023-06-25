package Contas;

import Exceptions.SenhaException;

import java.util.Date;

public class ContaPoupanca extends Conta{

    private double rendAtual;

    public ContaPoupanca(String senha, String nroConta, double rend)
    {
        super(senha, nroConta);
        rendAtual = rend;
    }

    public ContaPoupanca()
    {
        super();
        rendAtual=0;
    }

    public double getRendAtual() {
        return rendAtual;
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
                System.out.println("Rendimento Atual: "+rendAtual);
        }
    }

    public void addTransacao(TransacaoBancaria transacao) throws NullPointerException{
        if(transacao!=null)
            transacoes.add(transacao);
        else throw new NullPointerException("transacao inexistente");
    }
}
