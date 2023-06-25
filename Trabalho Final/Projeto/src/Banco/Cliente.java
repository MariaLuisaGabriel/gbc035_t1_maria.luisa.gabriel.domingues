package Banco;

import Contas.*;
import Misc.Endereco;
import Misc.Pessoa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Serializable {
    private String grauEscolaridade;
    private Endereco endereco;
    private ArrayList<Conta> conta;


    public Cliente(String nome, String cpf, String estadoCivil, String sexo, LocalDate dataNascimento, String grauEscolaridade, Endereco endereco,String rg)
    {
        super(nome,cpf,estadoCivil,sexo,dataNascimento,rg);
        this.grauEscolaridade=grauEscolaridade;
        this.endereco=endereco;
        conta=new ArrayList<Conta>();
    }

    public Cliente(String nome, String cpf)
    {
        super(nome,cpf,"Solteiro", "Masculino", null,null);
        grauEscolaridade=null;
        endereco=null;
        conta=new ArrayList<Conta>();
    }

    public boolean verifyConta(){
        if(conta.isEmpty()) return false;
        return true;
    }

    public void setConta(Conta conta)
    {
        if(conta!=null)
            this.conta.add(conta);
        else throw new IllegalArgumentException("Valor invalido!");
    }

    public Cliente()
    {
        this("Teste","000.000.000-00");
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getGrauEscolaridade(){
        return grauEscolaridade;
    }

    public void setGrauEscolaridade(String grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    public void printCliente() {
        System.out.println("\nNome: " + nome +
                "\nCPF: " + cpf +
                "\nEstado Civil: " + estadoCivil +
                "\nSexo: " + sexo +
                "\nNascimento: " + dataNascimento +
                "\nGrau de Escolaridade: " + grauEscolaridade +
                "\nEndereco: ");
                endereco.print();
    }

    public boolean contaExistente(String nroConta)
    {
        if(getConta(nroConta)==null)
            return false;
        return true;
    }
    public Conta getConta(String nroConta) {
        for(int i=0;i<conta.size();i++)
        {
            if(conta.get(i).getNroConta().equals(nroConta))
                return conta.get(i);
        }
        return null;
    }

    public void printContas(String cpf)
    {
        if(cpf.equals(this.cpf))
        {
            for(int i=0;i<conta.size();i++)
            {
                conta.get(i).printConta();
            }
        }
    }
}