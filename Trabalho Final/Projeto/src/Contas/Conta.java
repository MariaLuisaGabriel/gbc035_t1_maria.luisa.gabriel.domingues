package Contas;

import Exceptions.SenhaException;
import  java.io.Serializable;


import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Conta implements Comparable<Conta>, Serializable {

    protected boolean status;
    protected String senha;
    protected String nroConta;
    protected double saldoAtual;
    protected LocalDate abertura;
    protected LocalDate ultimaMovimentacao;
    protected ArrayList<TransacaoBancaria> transacoes = new ArrayList<TransacaoBancaria>();

    public int compareTo(Conta conta){
        return this.nroConta.compareTo(conta.nroConta);
    }
    public Conta(String senha, String nroConta) {
        status = true;
        saldoAtual = 0;
        abertura = LocalDate.now();
        this.senha = senha;
        this.nroConta = nroConta;
    }
    public Conta()
    {
        this("00000","00000");
    }

    protected void setUltimaMovimentacao(){
        ultimaMovimentacao = LocalDate.now();
    }

    public String getNroConta(){
        return nroConta;
    }

    public LocalDate getAbertura(String psw)
    {
        if(psw.equals(senha))
            return abertura;
        else
            throw new SenhaException("SENHA INCORRETA! ACESSO NEGADO!");
    }

    public LocalDate getUltimaMovimentacao(String psw)
    {
        if(psw.equals(senha))
            return abertura;
        else
            throw new SenhaException("SENHA INCORRETA! ACESSO NEGADO!");
    }


    public double getSaldoAtual(String psw)
    {
        if(psw.equals(senha))
            return saldoAtual;
        else
            throw new SenhaException("SENHA INCORRETA! ACESSO NEGADO!");
    }

    public boolean getStatus(String psw)
    {
        if(psw.equals(senha))
            return status;
        else
            throw new SenhaException("SENHA INCORRETA! ACESSO NEGADO!");
    }

    protected boolean getStatus()
    {
        return status;
    }

    public boolean verificaSenha(String psw)
    {
        return psw.equals(senha);
    }

    public void setSaldoAtual(String psw,double saldoAtual)
    {
        if(psw.equals(senha))
            this.saldoAtual=saldoAtual;
        else
            throw new SenhaException("SENHA INCORRETA! ACESSO NEGADO!");
    }
    public void printConta(String psw)
    {
        if(psw.equals(senha))
        {
            System.out.println("\nStatus: "+status
                    +"\nNumero da Conta: "+nroConta
                    +"\nSaldo Atual: "+saldoAtual
                    +"\nData de Abertura: "+abertura
                    +"\nData da Ultima Movimentacao: "+ultimaMovimentacao);
        }
        else
            throw new SenhaException("SENHA INCORRETA! ACESSO NEGADO!");
    }

    public void printConta()
    {
        System.out.println("\nStatus: "+status
                +"\nNumero da Conta: "+nroConta
                +"\nSaldo Atual: "+saldoAtual
                +"\nData de Abertura: "+abertura
                +"\nData da Ultima Movimentacao: "+ultimaMovimentacao);
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    protected void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public void setSenha(String senhaNova,String senhaAtual) {
        if(senhaAtual.equals(senha))
            senha=senhaNova;
        else throw new IllegalArgumentException("Senha incorreta");
    }

    public abstract void addTransacao(TransacaoBancaria transacao);

    public void setStatus(boolean status,String psw) {
        if(psw.equals(senha))
            this.status = status;
        else throw new IllegalArgumentException("Senha invalida!");
    }
}
