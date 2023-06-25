package Misc;

import Banco.Agencia;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAgencias {
    public static void principal(Agencia agencia, ArrayList<Agencia> agencias)
    {
        Scanner sc = new Scanner(System.in);
        String op;

        System.out.println("Qual Menu você deseja acessar:");
        do {
            System.out.println("1- Gestão de Funcionários");
            System.out.println("2- Área do Cliente");
            System.out.println("3- sair");
            op = sc.nextLine();
            switch (op)
            {
                case "1":
                    MenuGestao.principal(agencia);
                    break;
                case "2":
                    MenuCliente.principal(agencia,agencia.getClientes(),agencias);
                    break;
                case "3":
                    System.out.println("Encerrando");
                    break;
                default:
                    System.out.println("Invalido!");
                    break;
            }
        }while(Integer.parseInt(op)!=3);
    }

    public static void cadastroAgencia(ArrayList<Agencia> agencias)
    {
        String nome;
        int num;
        Endereco end;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        nome=sc.nextLine();

        System.out.print("\nNumero: ");
        num=sc.nextInt();

        end=MenuCliente.escolhaEndereco();

        agencias.add(new Agencia(num,nome,end));
    }
}
