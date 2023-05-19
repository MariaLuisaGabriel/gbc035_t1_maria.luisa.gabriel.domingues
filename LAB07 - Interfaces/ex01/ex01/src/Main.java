import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Classificador c = new Classificador();
        Produto[] p = new Produto[15];
        Servico[] s = new Servico[15];
        Cliente[] cl = new Cliente[10];

        int a = 9, C = 7, m = 50;
        for(int i = 0; i<15; i++) {
            p[i] = new Produto((a * i + C) % m);//oh yes função rand à mão :)
            s[i] = new Servico((float)((a*i+C)%m)/0.1F + (float)((a * i + C)/3));//oh yes função rand float à mão :)
            C++;
        }
        cl[0] = new Cliente("roberto");
        cl[1] = new Cliente("robson");
        cl[2] = new Cliente("cleide");
        cl[3] = new Cliente("clotilde");
        cl[4] = new Cliente("ana vitoria");
        cl[5] = new Cliente("bruno");
        cl[6] = new Cliente("geraldo");
        cl[7] = new Cliente("giovana");
        cl[8] = new Cliente("maira");
        cl[9] = new Cliente("simplicio");

        System.out.println("vetores antes de ordenar:\nProdutos:");
        for(int i = 0; i<15; i++)
        {
            System.out.print(p[i].getcodigo()+" ");
        }
        System.out.println("\nServicos:");
        for(int i = 0; i<15; i++)
        {
            System.out.print(s[i].getpreco()+" ");
        }
        System.out.println("\nClientes:");
        for(int i = 0; i<10; i++)
        {
            System.out.print(cl[i].getnome()+" ");
        }

        c.ordena(p);
        c.ordena(s);
        c.ordena(cl);

        System.out.println("\nvetores pos ordenacao:\nProdutos:");
        for(int i = 0; i<15; i++)
        {
            System.out.print(p[i].getcodigo()+", ");
        }
        System.out.println("\nServicos:");
        for(int i = 0; i<15; i++)
        {
            System.out.print(s[i].getpreco()+", ");
        }
        System.out.println("\nClientes:");
        for(int i = 0; i<10; i++)
        {
            System.out.print(cl[i].getnome()+", ");
        }
    }
}