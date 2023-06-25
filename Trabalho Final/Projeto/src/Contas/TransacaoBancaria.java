package Contas;

import Exceptions.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class TransacaoBancaria implements Serializable {
    private LocalDate data;
    private String canal;
    private double valor;
    private String operacao;

    public TransacaoBancaria(Conta a, String canal)
    {
        if(!a.getStatus())
        {
            throw new StatusException("Conta inativa, nao ha como fazer transação");
        }
        else {
            data = LocalDate.now();
            a.setUltimaMovimentacao();
            this.canal = canal;
        }
    }

    public void saque(Conta c, String psw, double valor){
        operacao = "Saque";
        this.valor=valor;
        if(!(c.verificaSenha(psw)))
        {
            throw new SenhaException("Senha Inválida, impossível executar saque;");
        }
        else if(c.getStatus(psw))
        {
            if(valor>c.getSaldoAtual(psw))
            {
                throw new BoundsSaldoException("Valor Inválido para transação.");
            }
            else
            {
                double novoSaldo =(c.getSaldoAtual(psw)) - valor;
                c.setSaldoAtual(psw, novoSaldo);
                c.setUltimaMovimentacao();
            }
        }
    }

    public void consultarSaldo(String psw, Conta c)
    {
        operacao = "Consulta de Salario";
        if(!(c.verificaSenha(psw)))
        {
            throw new SenhaException("Senha Inválida, impossível executar saque;");
        }
        else
        {
            System.out.println("saldo atual: " + c.getSaldoAtual(psw));
        }
    }

    public void deposito(Conta c, String psw, double valor)
    {
        operacao = "Deposito";
        this.valor = valor;
        if(!(c.verificaSenha(psw)))
        {
            throw new SenhaException("Senha Inválida, impossível executar saque;");
        }
        else
        {
            if(valor<0)
            {
                throw new BoundsSaldoException("Valor Inválido para deposito.");
            }
            else
            {
                c.setSaldoAtual(psw, c.getSaldoAtual(psw) + valor);
                c.setUltimaMovimentacao();
            }
        }
    }

    private void deposito(Conta c, double valor)
    {
        operacao = "Deposito";
        this.valor = valor;
        if(valor<0)
        {
            throw new BoundsSaldoException("Valor Inválido para deposito.");
        }
        else
        {
            c.setSaldoAtual(c.getSaldoAtual() + valor);
            c.setUltimaMovimentacao();
        }
    }

    public void pagamento(String psw, Conta a, Conta b, double valor)
    {
        operacao = "Pagamento";
        this.valor = valor;
        if(!a.verificaSenha(psw))
        {
            throw new SenhaException("Senha Inválida, impossível executar saque;");
        }
        else
        {
            if(valor<0)
            {
                throw new BoundsSaldoException("Valor Inválido para deposito.");
            }
            else
            {
                try {
                    this.saque(a, psw, valor);
                }catch(RuntimeException e) {
                    System.out.println(e.getMessage());
                }

                try {
                    this.deposito(b, valor);
                }catch(RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
 public void printTransacaoBancaria()
    {
        {
            System.out.println("\nData: " + this.data +
                               "\nCanal: " + this.canal +
                               "\nValor" + this.valor );
        }
    }

}

