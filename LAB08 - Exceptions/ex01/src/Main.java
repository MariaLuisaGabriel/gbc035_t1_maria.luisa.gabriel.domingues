public class Main {
    public static void main(String[] args) {
        Funcionario f = new Funcionario(1234567, "Roberto", 30000);
        for(int i = 120; i>-130;)
        {
            try{
                System.out.println("percentual adicionado ao salário: "+i+"%");
                f.alterarSalario(i);
            }catch(ValorSalario vs)
            {
                System.out.println("ERRO: "+vs.getMessage());
            }finally {
                System.out.print("valor atual do salario de "+f.getNome()+": ");
                System.out.printf("%.2fR$\n\n",f.getSalario());
            }
            i -= 10;
        }
    }
}