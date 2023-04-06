public class Aluno {
    public String nome;
    private int idade,matricula;
    private Cabeça C;
    Aluno(String no, int id, int mat){
        nome = no; idade = id; matricula = mat;
        C = new Cabeça(this);
    }

    void chorar_no_banho(){
        C.sofrer();
        System.out.println("* "+nome+" chora no banho *");
    }

    void dormir(){
        System.out.println("* "+nome+" dorme *");
        C.sonhar();
    }

    void estudar(){
        System.out.println("* "+nome+" estuda *");
        C.fritar();
    }

    void Show(){
        C.apresentar();
        System.out.println("aluno: "+nome);
        System.out.println("idade: "+idade);
        System.out.println("matricula: "+matricula);
    }
}
