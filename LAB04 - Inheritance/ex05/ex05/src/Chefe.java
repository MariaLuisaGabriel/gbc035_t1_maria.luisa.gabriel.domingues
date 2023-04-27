public class Chefe extends Funcionario{
    public Chefe(String n, int na){
        super(n,na);
    }

    void add_sal(){
        sal = sal + 15000; //meu valor fixo = 15k
        System.out.println("salario: "+sal);
    }
}
