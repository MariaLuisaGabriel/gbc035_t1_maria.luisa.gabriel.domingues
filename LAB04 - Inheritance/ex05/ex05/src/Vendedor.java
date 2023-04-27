public class Vendedor extends Funcionario{
    public Vendedor(String n, int na){
        super(n,na);
    }

    void add_sal(int com, int vend){
        sal = sal + 5000 + com*vend;
        System.out.println("salario: "+sal);
    }
}
