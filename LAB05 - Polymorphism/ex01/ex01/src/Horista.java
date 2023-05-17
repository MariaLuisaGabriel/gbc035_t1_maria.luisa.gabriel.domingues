public class Horista extends Funcionario{
    public Horista(String n, int na){
        super(n,na);
    }

    void add_sal(int valorhora, int horas){
        sal = sal + valorhora*horas;
        System.out.println("salario: "+sal);
    }
}
