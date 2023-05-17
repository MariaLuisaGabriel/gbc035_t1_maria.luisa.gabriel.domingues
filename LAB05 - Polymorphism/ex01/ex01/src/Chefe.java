public class Chefe extends Funcionario{
    public Chefe(String n, int na){
        super(n,na);
    }

    void add_sal(int sal, int extra){
        this.sal = this.sal + sal; //meu valor fixo = 15k
        System.out.println("salario: "+sal);
    }
}
