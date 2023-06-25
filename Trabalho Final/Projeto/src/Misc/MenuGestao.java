package Misc;

import Banco.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuGestao {
    public static void principal(Agencia agencia){
        if(agencia==null) return;
        int iteradorNroConta = 0;
        Scanner sc = new Scanner(System.in);
        String op;
        String cpf;
        String senha;

        do
        {
            System.out.println("\nEscolha uma das opcoes abaixo:");
            System.out.println("1- Contratar Funcionário;");
            System.out.println("2- Demitir Funcionário;");
            System.out.println("3- Promover Funcionário;");
            System.out.println("4- Visualizar Banco de Dados dos Clientes cadastrados;");
            System.out.println("5- Visualizar Banco de Dados dos Funcionários cadastrados;");
            System.out.println("6- Buscar Funcionario pelo CPF;");
            System.out.println("7- Contratar Gerente;");
            System.out.println("8- Encerrar servicos;");

            op = sc.nextLine();

            switch (op) {
                case "1":
                {
                    MenuGestao.contratar(agencia);
                    break;
                }
                case "2":
                {
                    cpf=MenuCliente.capturaCPF();
                    MenuGestao.demitir(agencia,cpf);
                    break;
                }
                case "3":
                {
                    cpf=MenuCliente.capturaCPF();
                    MenuGestao.promove(agencia,cpf);
                    break;
                }
                case "4":
                {
                    MenuGestao.bancoDadosCliente(agencia);
                    break;
                }
                case "5":
                {
                    MenuGestao.bancoDadosFunc(agencia);
                    break;
                }
                case "6":
                {
                    System.out.println("Funcionario baseado no cpf: ");
                    cpf = MenuCliente.capturaCPF();
                    Funcionario f = (Funcionario) agencia.getFuncionario(cpf);
                    if(f==null) System.out.println("Funcionario nao encontrado.");
                    else f.printFuncionario();
                    break;
                }
                case "7":
                {
                    MenuGestao.contratarGerente(agencia);
                    break;
                }
                case "8":
                {
                    System.out.println("Encerrando serviços...");
                    break;
                }
                default:
                {
                    System.out.println("Valor Invalido.");
                    break;
                }
            }
        }while(Integer.parseInt(op)!=8);
    }

    public static void contratar(Agencia agencia)
    {
        if(agencia==null) return;
        Scanner sc = new Scanner(System.in);
        String nome,estadoCivil,sexo,rg,cargo,cpf;
        LocalDate dataNascimento;
        Endereco endereco;
        Funcionario temp;
        String cartTrab,anoIngresso;
        double salario=0;

        System.out.println("Iniciando cadastro de funcionario:");
        cpf=MenuCliente.capturaCPF();
        if(agencia.getFuncionario(cpf)==null) {
            System.out.print("\nNome: ");
            nome = sc.nextLine();
            estadoCivil = MenuCliente.escolhaEstadoCivil();
            sexo = MenuCliente.escolhaSexo();
            try {
                dataNascimento = MenuCliente.escolhaDataNascimento();
            } catch (DateTimeException e) {
                System.out.println("Valores incorretos!");
                dataNascimento = MenuCliente.escolhaDataNascimento();
            }
            endereco = MenuCliente.escolhaEndereco();

            do {
                System.out.print("\nNumero da Carteira de Trabalho: ");
                cartTrab = sc.nextLine();
            } while (!MenuCliente.isNumeric(cartTrab));

            do {
                System.out.print("\nAno de Ingresso: ");
                anoIngresso = sc.nextLine();
            } while (!MenuCliente.isNumeric(anoIngresso));

            System.out.print("\nRG: ");
            rg = sc.nextLine();

            cargo = escolhaCargo();
            while (salario == 0) {
                switch (cargo) {
                    case "TI":
                        salario = 3500;
                        break;
                    case "RH":
                        salario = 3750;
                        break;
                    case "Limpeza":
                        salario = 2250;
                        break;
                    case "Alimentacao":
                        salario = 2300;
                        break;
                    case "Atendimento ao cliente":
                        salario = 2100;
                        break;
                    default:
                        System.out.println("Valor invalido");
                }
            }
            temp = new Funcionario(Integer.parseInt(cartTrab), Integer.parseInt(anoIngresso), nome, rg, estadoCivil, cargo, cpf, dataNascimento, endereco, sexo, salario);
            agencia.addFuncionarios(temp);
        }
        else
            System.out.println("CPF ja cadastrado!");
    }
    public static void contratarGerente(Agencia agencia)
    {
        if(agencia==null) return;
        if(!agencia.verificaGerente()) {
            Scanner sc = new Scanner(System.in);
            String nome, estadoCivil, sexo, rg, cargo, cpf;
            LocalDate dataNascimento;
            Endereco endereco;
            Funcionario temp;
            String cartTrab, anoIngresso;
            double salario = 0;

            System.out.println("Iniciando cadastro de funcionario:");
            cpf=MenuCliente.capturaCPF();
            if(agencia.getFuncionario(cpf)==null) {
                System.out.print("\nNome: ");
                nome = sc.nextLine();
                estadoCivil = MenuCliente.escolhaEstadoCivil();
                sexo = MenuCliente.escolhaSexo();
                try {
                    dataNascimento = MenuCliente.escolhaDataNascimento();
                } catch (DateTimeException e) {
                    System.out.println("Valores incorretos!");
                    dataNascimento = MenuCliente.escolhaDataNascimento();
                }
                endereco = MenuCliente.escolhaEndereco();

                do {
                    System.out.print("\nNumero da Carteira de Trabalho: ");
                    cartTrab = sc.nextLine();
                } while (!MenuCliente.isNumeric(cartTrab));

                do {
                    System.out.print("\nAno de Ingresso: ");
                    anoIngresso = sc.nextLine();
                } while (!MenuCliente.isNumeric(anoIngresso));

                System.out.print("\nRG: ");
                rg = sc.nextLine();

                cargo = escolhaCargo();
                while (salario == 0) {
                    switch (cargo) {
                        case "TI":
                            salario = 3500;
                            break;
                        case "RH":
                            salario = 3750;
                            break;
                        case "Limpeza":
                            salario = 2250;
                            break;
                        case "Alimentacao":
                            salario = 2300;
                            break;
                        case "Atendimento ao cliente":
                            salario = 2100;
                            break;
                        default:
                            System.out.println("Valor invalido");
                    }
                }
                temp = new Funcionario(Integer.parseInt(cartTrab), Integer.parseInt(anoIngresso), nome, rg, estadoCivil, cargo, cpf, dataNascimento, endereco, sexo, salario);
                agencia.addFuncionarios(temp);
            }
            else
                System.out.println("CPF ja cadastrado!");
            promove(agencia, cpf);
        }
        else System.out.println("Essa agência já possui um gerente!");
    }

    protected static String escolhaCargo()
    {
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.println("Escolha um cargo:");
        System.out.println("1- TI;");
        System.out.println("2- RH;");
        System.out.println("3- Limpeza;");
        System.out.println("4- Alimentacao;");
        System.out.println("5- Atendimento ao cliente;");
        op=sc.nextLine();
        while(true)
        {
            switch(op)
            {
                case "1":
                    return "TI";
                case "2":
                    return "RH";
                case "3":
                    return "Limpeza";
                case "4":
                    return "Alimentacao";
                case "5":
                    return "Atendimento ao cliente";
                default:
                    System.out.println("Valor invalido.");
                    break;
            }
            System.out.println("Escolha um cargo:");
            System.out.println("1- TI;");
            System.out.println("2- RH;");
            System.out.println("3- Limpeza;");
            System.out.println("4- Alimentacao;");
            System.out.println("5- Atendimento ao cliente;");
            op=sc.nextLine();
        }
    }

    public static void demitir(Agencia a ,String cpf)
    {
        if(a==null) return;
        if(ValidaCPF.isCPF(cpf)) {
            Scanner sc = new Scanner(System.in);
            String op;
            try {
                do {
                    System.out.println("Escolha uma opção:" +
                            "\n1- Demitir funcionarios normais;" +
                            "\n2- Demitir gerente;");
                    op = sc.nextLine();
                    switch (op) {
                        case "1": {
                            a.removeFuncionarios(cpf);
                            return;
                        }
                        case "2": {
                            if (a.verificaGerente()) {
                                a.removeGerente();
                            } else System.out.println("Nao há gerente a demitir!");
                            return;
                        }
                        default: {
                            System.out.println("Valor invalido");
                        }
                    }
                } while (true);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("CPF inválido");
        }
    }

    public static void promove(Agencia a,String cpf)
    {
        if(!a.verificaGerente()) {
            Scanner sc = new Scanner(System.in);
            boolean cb;
            String c;
            while (true) {
                System.out.println("Possui curso básico de Gestão? s/n");
                c = sc.nextLine();
                if (c.compareTo("s") != 0 && c.compareTo("n") != 0) {
                    System.out.println("Comando não existe! digite novamente...");
                } else break;
            }
            if (c.compareTo("s") == 0) {
                cb = true;
            } else {
                cb = false;
            }

            //teste para ver se esta conseguindo o funcionario
            if (a.getFuncionario(cpf) == null) {
                System.out.println("Funcionario não encontrado para tal cpf");
                System.out.println("Cpf: " + cpf);
                return;
            }

            //pega o funcionário a promover e o promove
            Funcionario f = (Funcionario) a.getFuncionario(cpf);
            f.printFuncionario();

            Gerente g = new Gerente(f, a.getNome(), cb);
            a.setGerente(g);

            //tira ele da lista de funcionários normais, pois já está presente no objeto da classe Gerente
            try {
                a.removeFuncionarios(cpf);
            }catch(NullPointerException e)
            {
                System.out.println(e.getMessage());
            }

        }
        else{
            System.out.println("Essa agência já possui um gerente");
        }
    }

    protected static void bancoDadosFunc(Agencia a)
    {
        System.out.println("Informações da agência: ");
        a.printaInfoAgencia();

        if(a.verificaGerente())
        {
            a.getGerente().printFuncionario();
        }
        System.out.print("\n");
        for(int i = 0; i<a.getTamFunc(); i++)
        {
            a.printElemFunc(i);
        }
    }

    protected static void bancoDadosCliente(Agencia a)
    {
        if(!a.getClientes().isEmpty())
        {
            System.out.println("Clientes Cadastrados na Agencia "+a.getNome()+":\n");
            for(int i = 0; i<a.getClientes().size(); i++)
            {
                a.getClientes().get(i).printCliente();
                a.getClientes().get(i).printContas(a.getClientes().get(i).getCpf());
            }
        }
        else{
            System.out.println("Banco de Dados de Clientes Vazio");
        }
    }
}
