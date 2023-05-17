public class ContaComum extends ContaCorrente{
    public ContaComum(int nc, int s)
    {
        estado = 1;
        senha = s;
        numConta = nc;
        saldo = 0.0F;
    }

    public boolean debitaValor ( float val , int pwd ) {
        if (pwd != senha)
            return (false); // senha deve ser vá lida
        if (estado != 1)
            return (false); // conta deve ser ativa
        if (val <= 0)
            return (false); // val > 0
        if (val > saldo)
            return (false);

        saldo -= val;
        if (saldo==0)
            estado = 2; // torna conta inativa
        return (true);
    }

    public boolean verificaEstado(int pwd)
    {
        if(pwd!=senha) return false;
        if(estado==1) {return true;}
        else {return false;}
    }

    public float getSaldo ( int pwd ) {
        if ( senha == pwd )
            return saldo ;
        else
            return -1; // indicando que houve problema na senha
    }
    public void creditaValor ( int pwd , float val ) {
        if (estado != 1)
            return ; // conta deve ser ativa
        if (val <= 0)
            return ; // val > 0
        if ( senha == pwd )
            saldo += val ;
        if (saldo==0)
            estado = 2;
    }

    int getSenha(int pwd)
    {
        if(pwd==senha)
            return senha;
        else return -1;
    }

    int getEstado(int pwd)
    {
        if(pwd==senha)
            return estado;
        else return -1;
    }

    int getNumConta(int pwd)
    {
        if(pwd==senha)
            return numConta;
        else return -1;
    }
}
