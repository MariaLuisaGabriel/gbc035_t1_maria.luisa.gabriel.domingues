public class Aluno {
    public String nome;
    private int idade,matricula;
    Aluno(String no, int id, int mat){
        nome = no; idade = id; matricula = mat;
    }

    void chorar_no_banho(){
        System.out.println("* "+nome+" chora no banho *");
    }

    void dormir(){
        System.out.println("* "+nome+" dorme *");
    }

    void estudar(){
        System.out.println("* "+nome+" estuda *");
    }

    void Show(){
        System.out.println("aluno: "+nome);
        System.out.println("idade: "+idade);
        System.out.println("matricula: "+matricula);
    }
}
