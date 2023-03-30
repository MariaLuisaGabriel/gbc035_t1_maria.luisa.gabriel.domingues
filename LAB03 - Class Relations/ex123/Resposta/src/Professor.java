public class Professor {
    private String nome;
    private int idade;
    Professor(String no, int id){
        nome = no; idade = id;
    }
    void sofrer(){
        System.out.println("* professor(a) "+nome+" sofre *");
    }

    void chorar_no_banho(){
        System.out.println("* professor(a) "+nome+" chora no banho *");
    }

    void dormir(){
        System.out.println("* professor(a) "+nome+" dorme *");
    }

    void preparar_aula(){
        System.out.println("* professor(a) "+nome+" prepara aula *");
    }

    void dar_aula(Aluno a){
        System.out.println("* professor(a) "+nome+" dá aula para "+a.nome+" *");
    }

    void Show(){
        System.out.println("Professor: "+nome);
        System.out.println("idade: "+idade);
    }
}
