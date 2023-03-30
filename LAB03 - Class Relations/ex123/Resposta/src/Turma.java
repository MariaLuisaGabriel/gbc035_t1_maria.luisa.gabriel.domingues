import java.util.Scanner;
public class Turma {
    private String nome;
    private int qtd;
    private Aluno[] al = new Aluno[30];
    Turma(String n,int q, Aluno a[]){
        nome = n;
        Scanner s = new Scanner(System.in);
        qtd = q;
        for(int i=0; i<qtd; i++){
            al[i]=a[i];
        }
    }

    void Show(){
        System.out.println("nome da turma: "+nome+"\nALUNOS:\n\n");
        for(int i=0; i<qtd; i++){
            al[i].Show();
            System.out.println("\n");
        }
    }
}
