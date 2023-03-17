import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[] nome = new String[4];
        int[] qtd_estoque = new int[4];
        float[] preco = new float[4];
        Scanner scan = new Scanner(System.in);

        for(int i=0; i<4; i++){
            System.out.println("escreva os dados do produto n° " + (i+1));
            System.out.println("nome: ");
            nome[i] = scan.next();
            System.out.println("quantidade em estoque: ");
            qtd_estoque[i] = scan.nextInt();
            System.out.println("preco: ");
            preco[i] = scan.nextFloat();
        }
        System.out.println("\nAumentando o preco em 10%% do produto 1 e 3");

        if(altera_preco(preco,1,-110)==-1)
            System.out.println("\n\nERRO: desconto inválido, falha na alteracao de preco.");
        else
            System.out.println("\nPreco alterado com sucesso");

        if(altera_preco(preco,3,10)==-1)
            System.out.println("\n\nERRO: desconto inválido, falha na alteracao de preco.");
        else
            System.out.println("\nPreco alterado com sucesso");

        System.out.println("\nReduzindo o preco em 5%% do produto 2");

        if(altera_preco(preco,2,-5)==-1)
            System.out.println("\n\nERRO: desconto inválido, falha na alteracao de preco.");
        else
            System.out.println("\nPreco alterado com sucesso");

        System.out.println("\nAlterando o preco do prod. 4");

        if(altera_preco(preco,4,-110)==-1)
            System.out.println("\n\nERRO: desconto inválido, falha na alteracao de preco.");
        else
            System.out.println("\nPreco alterado com sucesso");

        System.out.println("produtos cadastrados: ");

        for (int i = 0; i < 4; i++){
            System.out.println("\nproduto: " + nome[i] + "\npreco: " + preco[i] + "\nestoque: " + qtd_estoque[i]);
        }
    }

    private static int altera_preco(float[] p, int pos, int d){
        if(d < -100) return -1;
        p[pos-1] = p[pos-1] * (100+d)/100;
        return 0;
    }
}