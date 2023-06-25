package Misc;

import Banco.Agencia;
import Banco.Cliente;
import Contas.*;
import Exceptions.BoundsSaldoException;
import Exceptions.SenhaException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MenuCliente {
    public static void principal(Agencia a, ArrayList<Cliente> clientes, ArrayList<Agencia> agencias)
    {
        int iteradorNroConta = a.getIteradorNumConta();
        Scanner sc = new Scanner(System.in);
        String op;
        String cpf;

        do
        {
            System.out.println("\nEscolha uma das opcoes abaixo:");
            System.out.println("1- Cadastrar nova Conta;");
            System.out.println("2- Login;");
            System.out.println("3- Vincular a uma conta ja existente (Conta conjunta)");
            System.out.println("4- Desativar conta");
            System.out.println("5- Ativar conta");
            System.out.print("6- Encerrar servicos;");

            op = sc.nextLine();

            switch (op) {
                case "1":
                    MenuCliente.cadastroConta(clientes, iteradorNroConta);
                    System.out.println("O numero da sua conta e: "+iteradorNroConta);
                    iteradorNroConta++;
                    a.setIteradorNumConta(iteradorNroConta);
                    break;
                case "2":
                    cpf= MenuCliente.capturaCPF();
                    MenuCliente.login(clientes,cpf);
                    break;
                case "3":
                    cpf = MenuCliente.capturaCPF();
                    MenuCliente.cadastroCliente(clientes,cpf);
                    MenuCliente.configuraContaConjunta(a, agencias, cpf, MenuCliente.capturaCPFNoPrint());
                    break;
                case "4":
                    cpf=MenuCliente.capturaCPF();
                    alteraStatus(clientes,cpf,false);
                    break;
                case "5":
                    cpf=MenuCliente.capturaCPF();
                    alteraStatus(clientes,cpf,true);
                    break;
                    case "6":
                    System.out.println("Encerrando servicos...");
                    break;
                default:
                    System.out.println("Valor invalido!");
                    break;
            }
        }while(Integer.parseInt(op)!=6);
    }

    protected static void alteraStatus(ArrayList<Cliente> clientes, String cpf, boolean status)
    {
        int i;
        Scanner sc = new Scanner(System.in);
        String nroConta,pswd;
        try
        {
            i=MenuCliente.verifyCPFCliente(clientes,cpf);
            System.out.print("Insira o Numero da Conta: ");
            nroConta=sc.nextLine();
            Conta temp=clientes.get(i).getConta(nroConta);
            if(temp==null)
                return;
            else{
                System.out.println("\nInsira a senha: ");
                pswd=sc.nextLine();
                try{
                    if(temp.getStatus(pswd)==status)
                    {
                        if(status)
                            System.out.println("A conta ja esta ativa!");
                        else
                            System.out.println("A conta ja esta desativada!");
                        return;
                    }
                    temp.setStatus(status,pswd);
                    System.out.println("Status da Conta alterado.");
                }catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    protected static String capturaCPF()
    {
        Scanner sc=new Scanner(System.in);
        String cpf;
        while(true) {
            System.out.print("\nInforme o seu CPF: ");
            cpf = sc.nextLine();
            if(ValidaCPF.isCPF(cpf)){
                break;
            }
            System.out.println("CPF inválido, digite novamente: ");
        }
        return cpf;
    }

    protected static String capturaCPFNoPrint()
    {
        Scanner sc=new Scanner(System.in);
        String cpf;
        while(true) {
            System.out.print("\nInforme o CPF do cliente a fazer conta conjunta com: ");
            cpf = sc.nextLine();
            if(ValidaCPF.isCPF(cpf)){
                break;
            }
            System.out.println("CPF inválido, digite novamente: ");
        }
        return cpf;
    }

    protected static void cadastroCliente(ArrayList<Cliente> clientes,String cpf)
    {

        Scanner sc = new Scanner(System.in);
        String nome,estadoCivil,sexo,grauEscolaridade,rg;
        LocalDate dataNascimento;
        Endereco endereco;
        Cliente temp;
        try {
            if (verifyCPFCliente(clientes, cpf) != -1)
                return;
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Iniciando cadastro de cliente:");
        System.out.print("\nNome: ");
        nome= sc.nextLine();
        System.out.print("\nRG: ");
        rg= sc.nextLine();
        estadoCivil= MenuCliente.escolhaEstadoCivil();
        sexo= MenuCliente.escolhaSexo();
        grauEscolaridade= MenuCliente.escolhaGrauEscolaridade();
        try
        {
            dataNascimento= MenuCliente.escolhaDataNascimento();
        }catch(DateTimeException e)
        {
            System.out.println("Valores incorretos!");
            dataNascimento= MenuCliente.escolhaDataNascimento();
        }
        endereco= MenuCliente.escolhaEndereco();
        temp=new Cliente(nome,cpf,estadoCivil,sexo,dataNascimento,grauEscolaridade,endereco,rg);
        temp.printCliente();
        clientes.add(temp);
    }

    protected static String escolhaEstadoCivil()
    {
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.println("Escolha um Estado Civil:");
        System.out.println("1- Solteiro;");
        System.out.println("2- Casado;");
        System.out.println("3- Separado;");
        System.out.println("4- Divorciado;");
        System.out.println("5- Viuvo");
        op=sc.nextLine();
        while(true)
        {
            switch(op)
            {
                case "1":
                    return "Solteiro";
                case "2":
                    return "Casado";
                case "3":
                    return "Separado";
                case "4":
                    return "Divorciado";
                case "5":
                    return "Viuvo";
                default:
                    System.out.println("Valor invalido!");
                    break;
            }
            System.out.println("Escolha um Estado Civil:");
            System.out.println("1- Solteiro;");
            System.out.println("2- Casado;");
            System.out.println("3- Separado;");
            System.out.println("4- Divorciado;");
            System.out.println("5- Viuvo");
            op=sc.nextLine();
        }
    }

    protected static String escolhaSexo()
    {
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.println("Escolha um Sexo:");
        System.out.println("1- Masculino;");
        System.out.println("2- Feminino;");
        System.out.println("3- Outro;");
        op=sc.nextLine();
        while(true)
        {
            switch(op)
            {
                case "1":
                    return "Masculino";
                case "2":
                    return "Feminino";
                case "3":
                    return "Outro";
                default:
                    System.out.println("Valor invalido.");
                    break;
            }
            System.out.println("Escolha um Sexo:");
            System.out.println("1- Masculino;");
            System.out.println("2- Feminino;");
            System.out.println("3- Outro;");
            op=sc.nextLine();
        }
    }

    protected static String escolhaGrauEscolaridade()
    {
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.println("Escolha um grau de escolaridade:");
        System.out.println("1- Ensino Fundamental Incompleto;");
        System.out.println("2- Ensino Fundamental Completo;");
        System.out.println("3- Ensino Medio Incompleto;");
        System.out.println("4- Ensino Medio Completo;");
        System.out.println("5- Ensino Superior Incompleto;");
        System.out.println("6- Ensino Superior Completo;");
        op=sc.nextLine();
        while(true)
        {
            switch(op)
            {
                case "1":
                    return "Ensino Fundamental Incompleto";
                case "2":
                    return "Ensino Fundamental Completo";
                case "3":
                    return "Ensino Fundamental Completo";
                case "4":
                    return "Ensino Medio Completo";
                case "5":
                    return "Ensino Superior Incompleto";
                case "6":
                    return "Ensino Superior Completo";
                default:
                    System.out.println("Valor invalido.");
                    break;
            }
            System.out.println("Escolha um grau de escolaridade:");
            System.out.println("1- Ensino Fundamental Incompleto;");
            System.out.println("2- Ensino Fundamental Completo;");
            System.out.println("3- Ensino Medio Incompleto;");
            System.out.println("4- Ensino Medio Completo;");
            System.out.println("5- Ensino Superior Incompleto;");
            System.out.println("6- Ensino Superior Completo;");
            op=sc.nextLine();
        }
    }

    protected static LocalDate escolhaDataNascimento()
    {
        Scanner sc=new Scanner(System.in);
        String ano,mes,dia;
        int anoInt=-1,mesInt=-1,diaInt=-1;
        do {
            System.out.print("\nInsira seu ano de nascimento: ");
            ano = sc.nextLine();
            if(ano.matches("-?\\d+(\\.\\d+)?"))
                anoInt=Integer.parseInt(ano);
        }while(anoInt<0 || anoInt>LocalDate.now().getYear()-18);
        do
        {
            System.out.print("\nInsira o mes: ");
            mes=sc.nextLine();
            if(mes.matches("-?\\d+(\\.\\d+)?"))
                mesInt=Integer.parseInt(mes);
        }while(mesInt>12 || mesInt<1);
        do {
            System.out.print("\nInsira o dia: ");
            dia=sc.nextLine();
            if(dia.matches("-?\\d+(\\.\\d+)?"))
                diaInt=Integer.parseInt(dia);
        }while(diaInt<0 || diaInt>31);
        return LocalDate.of(anoInt,mesInt,diaInt);
    }

    protected static Endereco escolhaEndereco()
    {
        Scanner sc=new Scanner(System.in);
        String cidade,bairro,estado;
        System.out.print("\nIndique sua cidade: ");
        cidade=sc.nextLine();
        System.out.println("\nIndique seu bairro: ");
        bairro=sc.nextLine();
        estado= MenuCliente.escolhaEstado();
        return new Endereco(cidade,bairro,estado);
    }

    protected static String escolhaEstado()
    {
        Scanner sc=new Scanner(System.in);
        int op=-1;
        String []siglas= {"AC","AM","AP","AL","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PI","PB","PR","PE","RR","RS","RN","RO","RJ","SC","SP","SE","TO"};
        System.out.println("Escolha a sigla do seu Estado:");
        while(op<0 || op>27)
        {
            for(int j=0;j<27;j++) {
                if (j % 3 == 0)
                    System.out.print("\n");
                System.out.print((j+1) + "-" + siglas[j] + " ");
            }
            op=sc.nextInt();
            op-=1;
        }
        return siglas[op];
    }
    protected static void cadastroConta(ArrayList<Cliente> clientes, int nroCont) {
        Scanner sc = new Scanner(System.in);
        String op;
        String cpf= MenuCliente.capturaCPF();

        int i;
        try{
            if ((i = MenuCliente.verifyCPFCliente(clientes, cpf)) != -1) {
                System.out.println("Qual tipo de conta quer criar? " +
                        "\n1: Conta Corrente" +
                        "\n2: Conta Poupança" +
                        "\n3: Conta Salário");
                int o = sc.nextInt();
                try {
                    MenuCliente.opcao(clientes.get(i),o,sc,nroCont);}
                catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
            else {
                MenuCliente.cadastroCliente(clientes,cpf);
                MenuCliente.cadastroConta(clientes,nroCont,cpf);
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
            MenuCliente.cadastroCliente(clientes,cpf);
            MenuCliente.cadastroConta(clientes,nroCont,cpf);
        }
}

    protected static void cadastroConta(ArrayList<Cliente> clientes, int nroCont,String cpf) {
        Scanner sc = new Scanner(System.in);
        String op;

        int i= MenuCliente.verifyCPFCliente(clientes, cpf);
        try{
            System.out.println("Qual tipo de conta quer criar? " +
                    "\n1: Conta Corrente" +
                    "\n2: Conta Poupança" +
                    "\n3: Conta Salário");
            int o = sc.nextInt();
            try {
                MenuCliente.opcao(clientes.get(i),o,sc,nroCont);}
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
            MenuCliente.cadastroCliente(clientes,cpf);
            MenuCliente.cadastroConta(clientes,nroCont);
        }
    }

    protected static void editarCadastro(ArrayList<Cliente> clientes, String cpf)
    {
        Scanner sc=new Scanner(System.in);
        try {
            int i= MenuCliente.verifyCPFCliente(clientes,cpf);
            if (clientes.get(i).verifyConta()) {
                String pswd, str, escolha,nro;
                String op;
                int opInt;
                System.out.print("Insira o Numero da Conta: ");
                nro=sc.nextLine();
                if(!clientes.get(i).contaExistente(nro))
                {
                    System.out.println("Essa conta nao existe!");
                    return;
                }
                System.out.print("\nInsira sua senha: ");
                pswd = sc.nextLine();
                System.out.print("\n");
                if (clientes.get(i).getConta(nro).verificaSenha(pswd)) {
                    do {
                        System.out.println("Escolha o atributo que deseja modificar:");
                        System.out.println("1- Nome");
                        System.out.println("2- Estado Civil");
                        System.out.println("3- Sexo");
                        System.out.println("4- Data de Nascimento");
                        System.out.println("5- Grau de escolaridade");
                        System.out.println("6- Endereco");
                        System.out.println("7- Senha");
                        op = sc.nextLine();
                        switch (op) {
                            case "1":
                                str = sc.nextLine();
                                clientes.get(i).setNome(str);
                                break;
                            case "2":
                                str = MenuCliente.escolhaEstadoCivil();
                                clientes.get(i).setEstadoCivil(str);
                                break;
                            case "3":
                                str = MenuCliente.escolhaSexo();
                                clientes.get(i).setSexo(str);
                                break;
                            case "4":
                                LocalDate temp = MenuCliente.escolhaDataNascimento();
                                clientes.get(i).setDataNascimento(temp);
                                break;
                            case "5":
                                str = MenuCliente.escolhaGrauEscolaridade();
                                clientes.get(i).setGrauEscolaridade(str);
                                break;
                            case "6":
                                Endereco end = escolhaEndereco();
                                clientes.get(i).setEndereco(end);
                                break;
                            case "7":
                                System.out.print("Digite a nova senha: ");
                                str = sc.nextLine();
                                System.out.print("\n");
                                try {
                                    clientes.get(i).getConta(nro).setSenha(str, pswd);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            default:
                                System.out.println("Valor Invalido");
                        }
                        System.out.println("Deseja alterar mais alguma informacao? s/n");
                        escolha = sc.nextLine();
                        escolha = escolha.toLowerCase();
                    } while (!escolha.equals("n"));
                    System.out.println("Fim da edicao do registro.");
                }
                else
                    System.out.println("Senha incorreta!");
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    protected static int[] verifyNroContaConjunta(ArrayList<Agencia> agencias, String nro, String cpf) throws ArrayIndexOutOfBoundsException
    {
        int[] a = new int[2];
        if(!agencias.isEmpty())
        {
            for(int j = 0; j < agencias.size(); j++){
                for (int i = 0; i < agencias.get(j).getClientes().size(); i++) {
                    if (agencias.get(j).getClientes().get(i).getCpf().equals(cpf)) {
                        if (agencias.get(j).getClientes().get(i).getConta(nro) != null)
                        {
                            a[0] = j;//agencia na qual se encontra o cliente a fazer conta conjunta
                            a[1] = i;//conta na qual o numero bate com o do argumento do método
                            return a;
                        }
                        else
                            throw new IllegalArgumentException("numero da conta nao corresponde ao da conta do cliente buscado");
                    }
                }
            }
            throw new ArrayIndexOutOfBoundsException("elemento cujo cpf é "+cpf+" não existe em nenhuma das listas de clientes das agencias cadastradas");
        }
        else throw new ArrayIndexOutOfBoundsException("lista de agencias vazia");
    }

    protected static int verifyNroConta(ArrayList<Cliente> clientes, String nro) throws ArrayIndexOutOfBoundsException
    {
        if(!clientes.isEmpty())
        {
            for(int i = 0; i<clientes.size(); i++)
            {
                if (clientes.get(i).getConta(nro)!=null)
                {
                    return i;
                }
            }
            throw new ArrayIndexOutOfBoundsException("elemento não existe na lista de clientes");
        }
        else throw new ArrayIndexOutOfBoundsException("lista de clientes vazia");
    }

    protected static int verifyCPFCliente(ArrayList<Cliente> cliente, String cpf) throws ArrayIndexOutOfBoundsException{
        if(!cliente.isEmpty())
        {
            for(int i = 0; i<cliente.size(); i++)
            {
                if(cliente.get(i).cpf.equals(cpf)) return i;
            }
            return -1;
        }
        else throw new ArrayIndexOutOfBoundsException("lista de clientes vazia");
    }

    protected static void opcao(Cliente cliente,int flag, Scanner sc, int nroConta) throws IllegalArgumentException
    {
        String psw;
        switch(flag)
        {
            case 1:
            {
                double lim, tax;
                System.out.print("\nEscreva o limite de cheque: ");
                lim = sc.nextDouble();
                System.out.print("\nEscreva a taxa administrativa: ");
                tax = sc.nextDouble();
                System.out.print("\nEscreva a senha da conta: ");
                sc.nextLine();
                psw = sc.nextLine();
                cliente.setConta(new ContaCorrente(psw,Integer.toString(nroConta),lim,tax));
                break;
            }
            case 2:
            {
                double rendaAtual;
                System.out.print("\nEscreva sua renda atual: ");
                rendaAtual = sc.nextDouble();
                System.out.print("\nEscreva a senha da conta: ");
                sc.nextLine();
                psw = sc.nextLine();
                cliente.setConta(new ContaPoupanca(psw,Integer.toString(nroConta),rendaAtual));
                break;
            }
            case 3:
            {
                double limS, limT;
                System.out.print("\nEscreva o limite de saque: ");
                limS = sc.nextDouble();
                System.out.print("\nEscreva o limite de taxa: ");
                limT = sc.nextDouble();
                System.out.print("\nEscreva a senha da conta: ");
                sc.nextLine();
                psw = sc.nextLine();
                cliente.setConta(new ContaSalario(psw,Integer.toString(nroConta),limS,limT));
                break;
            }
            default:
            {
                throw new IllegalArgumentException("Tipo de conta inexistente");
            }
        }
    }

    protected static void login(ArrayList<Cliente> clientes, String cpf)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            int i= MenuCliente.verifyCPFCliente(clientes,cpf);
            if(i!=-1)
            {
                String pswd,nro;
                do{
                    System.out.print("\nInsira o numero da conta: ");
                    nro=sc.nextLine();
                    if(!clientes.get(i).contaExistente(nro))
                        System.out.println("Numero da conta nao consta nos registros!");
                }while(!clientes.get(i).contaExistente(nro));

                System.out.print("\nInsira sua senha: ");
                pswd = sc.nextLine();
                System.out.print("\n");
                if(clientes.get(i).getConta(nro).verificaSenha(pswd))
                {
                    System.out.println("Login efetuado com sucesso");
                    MenuCliente.menuCliente(clientes.get(i),clientes, pswd,nro);
                }
                else
                    System.out.println("Senha incorreta");
            }
            else
                System.out.println("CPF nao cadastrado");
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
    }

    protected static void menuCliente(Cliente cliente, ArrayList<Cliente> clientes, String pswd,String nroConta) //menu para cliente logado
    {
        Scanner sc = new Scanner(System.in);
        String op;
        do
        {
            System.out.println("Escolha uma opcao:");
            System.out.println("1- Editar cadastro");
            System.out.println("2- Depositar");
            System.out.println("3- Sacar");
            System.out.println("4- Consultar Saldo");
            System.out.println("5- Efetuar pagamento");
            System.out.println("6- Sair");
            op = sc.nextLine();
            switch(op)
            {
                case "1":
                {
                    editarCadastro(clientes,cliente.cpf);
                    break;
                }
                case "2":
                {
                    String canal= MenuCliente.escolhaCanaisFisicos();
                    System.out.print("Digite o valor a ser depositado: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("\n");
                    TransacaoBancaria transacao = new TransacaoBancaria(cliente.getConta(nroConta),canal);
                    try {
                        transacao.deposito(cliente.getConta(nroConta), pswd, valor);
                        System.out.print("Saldo Atual:");
                        System.out.println(cliente.getConta(nroConta).getSaldoAtual());
                        cliente.getConta(nroConta).addTransacao(transacao);
                    }catch(BoundsSaldoException | SenhaException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "3":
                {
                    String canal= MenuCliente.escolhaCanaisFisicos();
                    System.out.print("Digite o valor a ser sacado: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("\n");
                    TransacaoBancaria transacao = new TransacaoBancaria(cliente.getConta(nroConta),canal);
                    try {
                        transacao.saque(cliente.getConta(nroConta), pswd, valor);
                        System.out.print("Saldo Atual:");
                        System.out.println(cliente.getConta(nroConta).getSaldoAtual());
                        cliente.getConta(nroConta).addTransacao(transacao);
                    }catch(BoundsSaldoException | SenhaException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "4":
                {
                    String canal= MenuCliente.escolhaCanal();
                    TransacaoBancaria transacao = new TransacaoBancaria(cliente.getConta(nroConta),canal);
                    try {
                        transacao.consultarSaldo(pswd, cliente.getConta(nroConta));
                        cliente.getConta(nroConta).addTransacao(transacao);
                    }catch(SenhaException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "5":
                {
                    String canal= MenuCliente.escolhaCanal();
                    TransacaoBancaria transacaoBancaria = new TransacaoBancaria(cliente.getConta(nroConta),canal);
                    System.out.print("Informe o Numero da conta que deseja realizar transferencia: ");
                    String nro=sc.nextLine();
                    try {
                        int i = MenuCliente.verifyNroConta(clientes, nro);
                        System.out.print("Insira o valor de transferencia: ");
                        double valor = sc.nextDouble();
                        sc.nextLine();
                        transacaoBancaria.pagamento(pswd,cliente.getConta(nroConta),clientes.get(i).getConta(nro),valor);
                        cliente.getConta(nroConta).addTransacao(transacaoBancaria);
                        clientes.get(i).getConta(nro).addTransacao(transacaoBancaria);
                    }catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "6":
                {
                    System.out.println("Saindo...");
                    break;
                }
                default:
                {
                    System.out.println("Valor invalido!");
                    break;
                }
            }
        }while(Integer.parseInt(op)!=6);
    }
    protected static String escolhaCanal()
    {
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.println("Escolha um canal:");
        System.out.println("1- Internet Banking;");
        System.out.println("2- Caixa Eletrônico;");
        System.out.println("3- Caixa Fisico;");
        op=sc.nextLine();
        while(true)
        {
            switch(op)
            {
                case "1":
                    return "Internet Banking";
                case "2":
                    return "Caixa Eletronico";
                case "3":
                    return "Caixa Fisico";
                default:
                    System.out.println("Valor invalido.");
                    break;
            }
            System.out.println("Escolha um canal:");
            System.out.println("1- Internet Banking;");
            System.out.println("2- Caixa Eletrônico;");
            System.out.println("3- Caixa Fisico;");
            op=sc.nextLine();
        }
    }

    protected static String escolhaCanaisFisicos()
    {
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.println("Escolha um canal:");
        System.out.println("1- Caixa Eletrônico;");
        System.out.println("2- Caixa Fisico;");
        op=sc.nextLine();
        while(true)
        {
            switch(op)
            {
                case "1":
                    return "Caixa Eletronico";
                case "2":
                    return "Caixa Fisico";
                default:
                    System.out.println("Valor invalido.");
                    break;
            }
            System.out.println("Escolha um canal:");
            System.out.println("1- Caixa Eletrônico;");
            System.out.println("2- Caixa Fisico;");
            op=sc.nextLine();
        }
    }

    protected static void configuraContaConjunta(Agencia a, ArrayList<Agencia> agencias, String cpf, String cpfOutro){
        Scanner sc = new Scanner(System.in);
        String pswd, nro;
        System.out.println("Escreva o numero da conta que quer configurar para conta conjunta: ");
        nro = sc.nextLine();
        System.out.print("Insira a senha da conta: ");
        pswd = sc.nextLine();
        System.out.print("\n");
        int []i;
        try{
            i = verifyNroContaConjunta(agencias, nro, cpfOutro);
            if(agencias.get(i[0]).getClientes().get(i[1]).getConta(nro).verificaSenha(pswd))//verificando a senha da conta a ser configurada
            {
                try {
                        a.getClientes().get(verifyCPFCliente(a.getClientes(), cpf)).setConta(agencias.get(i[0]).getClientes().get(i[1]).getConta(nro));
                }catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else
                System.out.println("Senha incorreta!");
        } catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    protected static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
