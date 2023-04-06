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

    void sonhar(){
        System.out.println("* a cabeça de "+a.nome+" esta sonhando *");
    }

    void apresentar(){
        System.out.println("\n"+a.nome+" possui uma cabeça, mesmo que nao pareca.");
    }
}
