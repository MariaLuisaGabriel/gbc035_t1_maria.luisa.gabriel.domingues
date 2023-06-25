package Banco;

import Contas.*;
import Misc.Endereco;

import java.io.Serializable;
import java.util.ArrayList;

public class Agencia implements Serializable {
    private int num;
    private String nome;
    private Endereco endereco;
    private ArrayList<Funcionario> func = new ArrayList<Funcionario>();
    private ArrayList<Conta> conta = new ArrayList<Conta>();

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    private Gerente gerente;

    private int iteradorNumConta=0;

    public int getIteradorNumConta(){
        return iteradorNumConta;
    }

    public void setIteradorNumConta(int iteradorNumConta){
        this.iteradorNumConta=iteradorNumConta;
    }


    public Agencia()
    {
    }

    public Agencia(int num, String nome, Endereco endereco, Gerente gerente)
    {
        this.num=num;
        this.nome=nome;
        this.endereco=endereco;
        this.gerente = gerente;
    }
    public Agencia(int num, String nome, Endereco endereco)
    {
        this(num,nome,endereco,null);
    }

    public void removeGerente(){gerente=null;}

    public Gerente getGerente(){return gerente;}

    public void printElemFunc(int pos)
    {
        func.get(pos).printFuncionario();
        System.out.println("");
    }

    public void setGerente(Gerente g){gerente = g;}

    public boolean verificaGerente(){
        if(gerente==null)return false;
        else return true;
    }

    public int getTamFunc(){return func.size();}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public int getNum() {
        return num;
    }

    public void addContas(Conta conta) throws NullPointerException
    {
        if(conta!=null)
            this.conta.add(conta);
        else throw new NullPointerException("Conta inexistente");
    }

    public void addFuncionarios(Funcionario funcionario) throws NullPointerException
    {
        if(funcionario!=null)
            func.add(funcionario);
        else throw new NullPointerException("Funcionario nao existente.");
    }

    public void removeFuncionarios(String cpf) throws NullPointerException
    {
        if(!func.isEmpty())
        {
            try{
                if(!func.remove(func.get(procuraCPF(cpf))))
                {
                    throw new ArrayIndexOutOfBoundsException("elemento não está presente no Banco de Dados");
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        else throw new NullPointerException("Banco de dados Vazio");
    }

    public int procuraCPF(String cpf) throws ArrayIndexOutOfBoundsException
    {
        for(int i = 0; i < func.size(); i++)
        {
            if(func.get(i).getCpf().equals(cpf)) return i;
        }
        throw new ArrayIndexOutOfBoundsException("elemento nao está presente no Banco de Dados");
    }

    public Funcionario getElemFunc(int i) throws ArrayIndexOutOfBoundsException
    {
        if(i>=0 && i<func.size())
        {
            return func.get(i);
        }
        throw new ArrayIndexOutOfBoundsException("elemento nao está presente no Banco de Dados");
    }

    public Conta buscaConta(String nroConta) throws ArrayIndexOutOfBoundsException{
        if(conta.isEmpty()==false){
            for(int i = 0; i<conta.size(); i++){
                if(conta.get(i).getNroConta().equals(nroConta)){
                    return conta.get(i);
                }
                else throw new ArrayIndexOutOfBoundsException("conta nao encontrada");
            }
        }
        else throw new ArrayIndexOutOfBoundsException("lista de contas vazia");

        return null;
    }

    public void printaInfoAgencia(){
        System.out.println("Numero da agencia: "+num);
        System.out.println("Nome da agencia: "+nome);

        if (gerente == null) System.out.println("Agencia sem gerente");
        else
            System.out.println("Gerente da agencia: "+gerente.getNome());
    }

    public Object getFuncionario(String cpf) {
        for(int i = 0; i < func.size(); i++)
        {
            System.out.println("Cpf:" +func.get(i).getCpf());
            if(func.get(i).getCpf().equals(cpf)) return func.get(i);
        }
        return null;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
