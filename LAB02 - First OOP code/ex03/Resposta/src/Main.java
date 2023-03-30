import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int n;
        String lixo;
        String nome, pos, pais;
        int na;
        float peso, al;
        Scanner s = new Scanner(System.in);
        System.out.println("escreva a quantidade de jogadores que quer instanciar: ");
        n = s.nextInt();
        lixo = s.nextLine();
        Figurinha[] jogadores = new Figurinha[n];
        for(int i=0; i<n; i++)
        {
            System.out.println("escreva o nome do jogador: ");
            nome = s.nextLine();
            System.out.println("escreva a data de nascimento: ");
            na = s.nextInt();
            System.out.println("escreva a altura do jogador: ");
            al = s.nextFloat();
            System.out.println("escreva o peso do jogador: ");
            peso = s.nextFloat();
            System.out.println("escreva a posiçao do jogador: ");
            lixo = s.nextLine();
            pos = s.nextLine();
            System.out.println("escreva o país de nascimento do jogador: ");
            pais = s.nextLine();
            jogadores[i] = new Figurinha(nome,na,al,peso,pos,pais);
        }

        for(int i=0; i<n; i++)
        {
            jogadores[i].Show();
        }
    }
}