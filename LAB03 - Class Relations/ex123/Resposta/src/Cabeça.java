public class Cabeça {
    Aluno a;

    Cabeça(Aluno al){
        a = al;
    }
    void sofrer(){
        System.out.println("* "+a.nome+" sofre *");
    }

    void fritar(){
        System.out.println("* a cabeça de "+a.nome+" esta fritando *");
    }

    void delirar(){
        System.out.println("* a cabeça de "+a.nome+" esta delirando *");
    }

    void sonhar(){
        System.out.println("* a cabeça de "+a.nome+" esta sonhando *");
    }

    void apresentar(){
        System.out.println("Esta eh a linda e destruída cabeça de "+a.nome+".");
    }
}
