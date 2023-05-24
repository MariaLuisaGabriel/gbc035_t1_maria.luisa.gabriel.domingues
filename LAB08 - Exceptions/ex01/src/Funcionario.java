import java.io.IOException;

public class Funcionario {
    private int CPF;
    private String nome;
    private float salario;
    private float teto;
    public Funcionario(int cpf, String n, float sal)
    {
        salario = sal;
        nome = n;
        CPF = cpf;
        teto = 40000.0F;
    }

    void alterarSalario(float percentual) throws ValorSalario
    {
        if(salario+salario*(float)(percentual/100)>teto)//excede teto
        {
            throw new ValorSalario("Valor ultrapassa o teto");
        }
        else if(percentual<-100.0F)//gera valor negativo
        {
            throw new ValorSalario("Valor inválido de salário");
        }
        else
        {
            salario = salario + salario*(float)(percentual/100);
        }
    }

    float getSalario()
    {
        return salario;
    }

    String getNome()
    {
        return nome;
    }

    int getCPF()
    {
        return CPF;
    }

}
