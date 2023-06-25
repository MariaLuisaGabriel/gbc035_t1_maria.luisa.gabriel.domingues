package Misc;

import Banco.Agencia;
import Banco.Cliente;
import Banco.Funcionario;
import Contas.Conta;
import Contas.TransacaoBancaria;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Savestate {
    //metodos para salvar todas as contas, funcionarios, transacoes, clientes e agencias em arquivos separados
    //deve ser chamado no final do programa ouuu *Fazer após cada transacao tornaria talvez mais seguro* e carregado no inicio

    //Observações: Criei um savestate para transações, mas não é necessário, como o objeto de conta já tem um array de transações, basta salvar as contas que as transações serão salvas junto.
    //O mesmo vale para tudo dentro da agencia, até mesmo contas e funcionarios, guardar o objeto agencia e criar métodos para retornar os seus atributos que são OBJETOS já é suficiente, mas não sei como vamos implementar. Então vapo modularização e redundancia

    // na main: Savestate.saveAgencia(agencia);
    // na main: Savestate.loadAgencia(agencia);
    // onde: Agencia agencia = new Agencia();
    // Foi criado um overload para agencia, agencia suporta saveAgencia(arraylist<Agencia> agencias) e saveAgencia(Agencia agencia) mesma coisa para load.

    private static String AGENCIA = "agencia.dat";
    private static String CONTAS = "contas.dat";
    private static String FUNCIONARIOS = "funcionarios.dat";
    private static String TRANSACOES = "transacoes.dat";




    public static void saveContas(ArrayList<Conta> contas){
        try {
            FileOutputStream arqGravar = new FileOutputStream(CONTAS);
            ObjectOutputStream objGravar = new ObjectOutputStream(arqGravar);
            objGravar.writeObject(contas);
            objGravar.close();
            arqGravar.close();
            System.out.println("Contas salvas em "+CONTAS); // Somente para debug REMOVER DEPOIS
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void loadContas(ArrayList<Conta> contas){
        try {
            FileInputStream arqLer = new FileInputStream(CONTAS);
            ObjectInputStream objLer = new ObjectInputStream(arqLer);
            contas = (ArrayList<Conta>) objLer.readObject();
            objLer.close();
            arqLer.close();
            System.out.println("Contas carregadas de "+CONTAS); // Somente para debug REMOVER DEPOIS
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveFuncionarios(ArrayList<Funcionario> funcionarios){
        try {
            FileOutputStream arqGravar = new FileOutputStream(FUNCIONARIOS);
            ObjectOutputStream objGravar = new ObjectOutputStream(arqGravar);
            objGravar.writeObject(funcionarios);
            objGravar.close();
            arqGravar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFuncionarios(ArrayList<Funcionario> funcionarios){
        try {
            FileInputStream arqLer = new FileInputStream(FUNCIONARIOS);
            ObjectInputStream objLer = new ObjectInputStream(arqLer);
            funcionarios = (ArrayList<Funcionario>) objLer.readObject();
            objLer.close();
            arqLer.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveTransacoes(ArrayList<TransacaoBancaria> transacoes){
        try {
            FileOutputStream arqGravar = new FileOutputStream(TRANSACOES);
            ObjectOutputStream objGravar = new ObjectOutputStream(arqGravar);
            objGravar.writeObject(transacoes);
            objGravar.close();
            arqGravar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadTransacoes(ArrayList<TransacaoBancaria> transacoes){
        try {
            FileInputStream arqLer = new FileInputStream(TRANSACOES);
            ObjectInputStream objLer = new ObjectInputStream(arqLer);
            transacoes = (ArrayList<TransacaoBancaria>) objLer.readObject();
            objLer.close();
            arqLer.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveClientes(ArrayList<Cliente> clientes){
        try {
            FileOutputStream arqGravar = new FileOutputStream("clientes.dat");
            ObjectOutputStream objGravar = new ObjectOutputStream(arqGravar);
            objGravar.writeObject(clientes);
            objGravar.close();
            arqGravar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cliente> loadClientes(){
        ArrayList<Cliente> clientes = null;
        try {
            File file = new File("clientes.dat");
            if (!file.exists()){
                return new ArrayList<Cliente>();
            }
            FileInputStream arqLer = new FileInputStream("clientes.dat");
            ObjectInputStream objLer = new ObjectInputStream(arqLer);
            clientes = (ArrayList<Cliente>) objLer.readObject();
            objLer.close();
            arqLer.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("deu bosta");
        }

        return clientes;
    }


    public static void saveAgencia(ArrayList<Agencia> agencia){
        try {
            FileOutputStream arqGravar = new FileOutputStream(AGENCIA);
            ObjectOutputStream objGravar = new ObjectOutputStream(arqGravar);
            objGravar.writeObject(agencia);
            objGravar.close();
            arqGravar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //public static ArrayList<Cliente> loadClientes(){

    public static ArrayList<Agencia> loadAgencia(){
        ArrayList<Agencia> agencia = null;
        try {
            File file = new File("agencia.dat");
            if (!file.exists()){
                return new ArrayList<Agencia>();
            }
            FileInputStream arqLer = new FileInputStream(AGENCIA);
            ObjectInputStream objLer = new ObjectInputStream(arqLer);
            agencia = (ArrayList<Agencia>) objLer.readObject();
            objLer.close();
            arqLer.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return agencia;
    }

    public static Agencia loadAgenciaObj(){
        Agencia agencia = null;
        try {
            File file = new File("agencia.dat");
            if (!file.exists()){
                return new Agencia();
            }
            FileInputStream arqLer = new FileInputStream(AGENCIA);
            ObjectInputStream objLer = new ObjectInputStream(arqLer);
            agencia = (Agencia) objLer.readObject();
            objLer.close();
            arqLer.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return agencia;
    }

    public static void saveAgencia(Agencia agencia){
        try {
            FileOutputStream arqGravar = new FileOutputStream(AGENCIA);
            ObjectOutputStream objGravar = new ObjectOutputStream(arqGravar);
            objGravar.writeObject(agencia);
            objGravar.close();
            arqGravar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadAgencia(Agencia agencia){
        try {
            FileInputStream arqLer = new FileInputStream(AGENCIA);
            ObjectInputStream objLer = new ObjectInputStream(arqLer);
            agencia = (Agencia) objLer.readObject();
            objLer.close();
            arqLer.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




}
