package Banco;

import java.time.LocalDate;

public class Gerente extends Funcionario{
    private LocalDate dataIng;
    private String agencia;
    private boolean cursoBasico;
    private static double comissao;

    public Gerente(Funcionario f, String nomeAgencia, boolean c)
    {
        super(f.getCartTrab(),f.getAnoIng(),f.getNome(),f.getRG(),f.getEstadoCivil(),f.getCargo(),f.getCpf(),f.getDataNascimento(),f.getEnd(),f.getSexo(),f.getSalario());
        dataIng = LocalDate.now();
        agencia = nomeAgencia;
        cursoBasico = c;
    }



    public static double getComissao() {
        return comissao;
    }

    public static void setComissao(double comissao) {
        Gerente.comissao = comissao;
    }

    public LocalDate getDataIng(){
        return dataIng;
    }

    public void setDataIng(LocalDate novo){
        dataIng = novo;
    }

    public String getAgencia(){
        return agencia;
    }

    public void setAgencia(String novo){
        agencia = novo;
    }

    public boolean getCursoBsico(){
        return cursoBasico;
    }

    public void setCursoBasico(boolean novo){
        cursoBasico = novo;
    }

    public void calcularSalario()
    {
        super.calcularSalario();
        salario+=comissao;
    }

    public void printFuncionario() //override para gerente
    {
        super.printFuncionario();
        String bool = "";
        if(!cursoBasico) bool = "não ";
        System.out.println("\nData de ingresso: "+dataIng
                        +"\nAgencia que rege: "+agencia
                        +"\nComissâo: "+comissao
                        +"\nCurso Básico: "+bool+"possui");
    }
}
