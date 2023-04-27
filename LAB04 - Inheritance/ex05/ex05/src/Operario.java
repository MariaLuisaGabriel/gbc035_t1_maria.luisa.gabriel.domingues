public class Operario extends Funcionario{
    public Operario(String n, int na){
        super(n,na);
    }

    void add_sal(float valorproducao, int produzido){
        sal = sal + valorproducao*produzido;
        System.out.println("salario: "+sal);
    }
}
