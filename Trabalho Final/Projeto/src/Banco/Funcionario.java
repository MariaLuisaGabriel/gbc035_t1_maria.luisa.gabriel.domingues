package Banco;

import Misc.Endereco;
import Misc.Pessoa;

import java.io.Serializable;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Serializable {
    protected int cartTrab, anoIng;
    protected String cargo;
    protected Endereco end;
    protected double salario;

    public Funcionario(int cartTrab, int anoIng, String nome, String rg, String estCivil, String cargo, String cpf, LocalDate nasc, Endereco end, String sexo, double salario){
        super(nome,cpf,estCivil,sexo,nasc,rg);
        this.cartTrab = cartTrab;
        this.anoIng = anoIng;
        this.cargo  = cargo;
        this.end = end;
        this.salario = salario;
    }

    public Funcionario()
    {
        this(0,0,"Teste","MG-00.000.000","Solteiro","Funcionario","000.000.000-00",null,null,"Masculino",0);
    }

    public void printFuncionario()
    {
        System.out.println("\nNumero da carteira de trabalho: "+ cartTrab +
                           "\nAno de Ingresso: "+ anoIng +
                           "\nNome: "+ nome +
                           "\nRG: "+ rg +
                           "\nEstado Civil: " + estadoCivil +
                           "\nCargo: " + cargo +
                           "\nCPF: " + cpf +
                            "\nNascimento: " + dataNascimento +
                           "\nEndereco: " +  end +
                           "\nSexo: " + sexo +
                           "\nSalario: " + salario);
    }

    public void calcularSalario()
    {
        int anoAtual = LocalDate.now().getYear();
        if(anoAtual-anoIng>15)
        {
            salario=salario*1.1;
        }
    }

    public void setAnoIng(int anoIng) {
        this.anoIng = anoIng;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCartTrab(int cartTrab) {
        this.cartTrab = cartTrab;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public Endereco getEnd() {
        return end;
    }

    public int getAnoIng() {
        return anoIng;
    }

    public int getCartTrab() {
        return cartTrab;
    }

    public String getCargo() {
        return cargo;
    }

    public String getRG() {
        return rg;
    }
}
