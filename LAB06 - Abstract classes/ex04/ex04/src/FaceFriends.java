import java.util.Scanner;

public class FaceFriends {
    public static void main(String[] args) {
        Contato[] a = new Contato[100];
        int c = 0;
        int menu, sp, grau;
        String nome, parentesco, tipo, apelido, aniversario, email;
        Scanner s = new Scanner(System.in);
        while(c<100)
        {
            System.out.println("\nMENU:\n=====\n1)inserir contato;\n2)imprimir todos os contatos;\n3)imprimir contatos familiares\n4)imprimir somente amigos\n5)imprimir colegas de trabalho\n6)imprimir melhores amigos, irmaos e colegas de trabalho\n7)imprimir contato à sua escolha\n8)sair\n->");
            menu = s.nextInt();
            switch(menu)
            {
                case 1:
                {
                    System.out.println("esse contato é do tipo Familia (1), Amigo (2) ou Trabalho (3)?");
                    sp = s.nextInt();
                    switch(sp)
                    {
                        case 1:
                            System.out.println("escreva o nome: ");
                            nome = s.next();
                            System.out.println("escreva o apelido: ");
                            apelido = s.next();
                            System.out.println("escreva o email: ");
                            email = s.next();
                            System.out.println("escreva o aniversario: (molde dia/mes/ano) ");
                            aniversario = s.next();
                            System.out.println("escreva o parentesco: ");
                            parentesco = s.next();
                            a[c] = new Familia(nome, email, apelido, aniversario, parentesco);
                            c++;
                            break;
                        case 2:
                            System.out.println("escreva o nome: ");
                            nome = s.next();
                            System.out.println("escreva o apelido: ");
                            apelido = s.next();
                            System.out.println("escreva o email: ");
                            email = s.next();
                            System.out.println("escreva o aniversario: (molde dia/mes/ano) ");
                            aniversario = s.next();
                            System.out.println("escreva o grau de amizade: ");
                            grau = s.nextInt();
                            a[c] = new Amigos(nome, email, apelido, aniversario, grau);
                            c++;
                            break;
                        case 3:
                            System.out.println("escreva o nome: ");
                            nome = s.next();
                            System.out.println("escreva o apelido: ");
                            apelido = s.next();
                            System.out.println("escreva o email: ");
                            email = s.next();
                            System.out.println("escreva o aniversario: (molde dia/mes/ano) ");
                            aniversario = s.next();
                            System.out.println("escreva o tipo de convivencia: ");
                            tipo = s.next();
                            a[c] = new Trabalho(nome, email, apelido, aniversario, tipo);
                            c++;
                            break;
                    }
                    break;
                }
                case 2:
                {
                    for(int i=0; i<c; i++)
                    {
                        System.out.print((i+1)+" - ");
                        a[i].imprimirContato();
                        System.out.print("\n");
                    }
                    break;
                }
                case 3:
                {
                    for(int i=0; i<c; i++)
                    {
                        if(a[i] instanceof Familia)
                            a[i].imprimirContato();
                    }
                    break;
                }
                case 4:
                {
                    for(int i=0; i<c; i++)
                    {
                        if(a[i] instanceof Amigos)
                            a[i].imprimirContato();
                    }
                    break;
                }
                case 5:
                {
                    for(int i=0; i<c; i++)
                    {
                        if(a[i] instanceof Trabalho)
                        {
                            if(((Trabalho) a[i]).tipo.equals("colega")) {
                                a[i].imprimirContato();
                                System.out.print("\n");
                            }
                        }
                    }
                    break;
                }
                case 6:
                {
                    for(int i=0; i<c; i++)
                    {
                        if(a[i] instanceof Trabalho && ((Trabalho) a[i]).tipo.equals("colega"))
                            a[i].imprimirContato();
                        if(a[i] instanceof Amigos && ((Amigos) a[i]).grau==1)
                            a[i].imprimirContato();
                        if(a[i] instanceof Familia && ((Familia) a[i]).parentesco.equals("irmão"))
                            a[i].imprimirContato();
                        System.out.print("\n");
                    }
                    break;
                }
                case 7:
                {
                    System.out.println("escolha o contato que quer imprimir pela posição dele na lista: ");
                    sp = s.nextInt();
                    sp--;
                    if(sp<c)
                    {
                        if(a[sp] instanceof Trabalho)
                            System.out.print("Trabalho - ");
                        if(a[sp] instanceof Amigos)
                            System.out.print("Amigos - ");
                        if(a[sp] instanceof Familia)
                            System.out.print("Familia - ");
                        a[sp].imprimirContato();
                    }
                    else System.out.println("ERRO: posição nao existe na lista.");
                    break;
                }
            }
            if(menu==8) break;
        }
    }
}