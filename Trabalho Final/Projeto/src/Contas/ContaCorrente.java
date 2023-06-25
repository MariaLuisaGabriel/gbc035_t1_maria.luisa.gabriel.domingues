package Contas;

import Exceptions.SenhaException;

public class ContaCorrente extends Conta{
    private double limCheque, taxAdmin;
    public ContaCorrente(String senha, String nroConta, double lim, double tax)
    {
        super(senha, nroConta);
        limCheque = lim;
        taxAdmin = tax;
    }
    public ContaCorrente()
    {
        super();
        limCheque=0;
        taxAdmin=0;
    }

    public double getLimCheque() {
        return limCheque;
    }

    public double getTaxAdmin() {
        return taxAdmin;
    }

    public void setLimCheque(double limCheque) {
        this.limCheque = limCheque;
    }

    public void setTaxAdmin(double taxAdmin) {
        this.taxAdmin = taxAdmin;
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
                System.out.println("Limite de Cheque: "+limCheque
                        +"\nTaxa Admin: "+taxAdmin);
        }
    }

    public void addTransacao(TransacaoBancaria transacao) throws NullPointerException{
        if(transacao!=null)
            transacoes.add(transacao);
        else throw new NullPointerException("transacao inexistente");
    }
}
