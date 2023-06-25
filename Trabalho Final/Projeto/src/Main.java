import Banco.*;
import Misc.MenuAgencias;
import Misc.MenuCliente;
import Misc.MenuGestao;
import Misc.Savestate;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Agencia> agencias=new ArrayList<Agencia>();
        Scanner sc = new Scanner(System.in);
        agencias=Savestate.loadAgencia();
        int op,i=0;
        System.out.println("Bem vindo a nossa Instituicao Bancaria:");
        System.out.println("Escolha uma opcao:");
        do {
            for(i=0;i<agencias.size();i++)
                System.out.println((i+1)+"- Acessar "+agencias.get(i).getNome());
            System.out.println((i+1)+"- Cadastrar Nova agencia;");
            System.out.println((i+2)+"- Encerrar;");
            op=sc.nextInt();
            op-=1;
            if(op>=0 && op<i && !agencias.isEmpty())
                MenuAgencias.principal(agencias.get(op),agencias);
            else
            {
                if (op==i)
                {
                    MenuAgencias.cadastroAgencia(agencias);
                }
                else if (op==i+1)
                {
                    System.out.println("Encerrando...");
                }
                else
                {
                    System.out.println("Valor invalido");
                }
            }
        }while(op!=i+1);
        Savestate.saveAgencia(agencias);
    }
}