import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String lixo;
        String nome, pos, pais, Nome, nometec;
        int na;
        float peso, al;
        Scanner s = new Scanner(System.in);
        System.out.println("Selecao 1: ");
        System.out.println("escreva o nome da selecao: ");
        Nome = s.nextLine();
        lixo = s.nextLine();
        System.out.println("escreva o nome do tecnico: ");
        nometec = s.nextLine();
        lixo = s.nextLine();
        System.out.println("escreva o país de nascimento do jogador: ");
        pais = s.nextLine();
        lixo = s.nextLine();
        Selecao s1 = new Selecao(Nome, nometec,pais);
        System.out.println("Selecao 2: ");
        System.out.println("escreva o nome da selecao: ");
        Nome = s.nextLine();
        lixo = s.nextLine();
        System.out.println("escreva o nome do tecnico: ");
        nometec = s.nextLine();
        lixo = s.nextLine();
        System.out.println("escreva o país de nascimento do jogador: ");
        pais = s.nextLine();
        Selecao s2 = new Selecao(Nome, nometec, pais);
        s1.Show();
        System.out.println("\n");
        s2.Show();
    }
}