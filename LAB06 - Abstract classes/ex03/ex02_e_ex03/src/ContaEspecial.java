public class ContaEspecial extends ContaCorrente{
    private float limite;
    public ContaEspecial(int nc, int s){
        limite = 0.0F;
        estado = 1;
        senha = s;
        numConta = nc;
        saldo = 0.0F;
    }

    public void setEstado ( int pwd , int e ) {
        if ( senha == pwd )
            estado = e;
    }

    public boolean verificaEstado(int pwd)
    {
        if(pwd!=senha) return false;
        if(estado!=1) return false;
        else return true;
    }

    public void setLimite (int pwd, float lim)
    {
        if(pwd == senha && lim>=0)
        {
            limite = lim;
        }
    }
    ContaComum verificaLimite(int pwd)
    {
        if(pwd != senha) return null;
        if(limite==0.0F)
        {
            ContaComum b = new ContaComum(numConta,senha);
            return b;
        }
        else return null;
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
        return (true);
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
        if (limite==0)
            estado = 2;
    }

    float getLimite(int pwd)
    {
        if(pwd == senha)
            return limite;
        else return -1;
    }

    int getSenha(int pwd)
    {
        if(pwd==senha)
            return senha;
        else return -1;
    }

    int getNumConta(int pwd)
    {
        if(pwd==senha)
            return numConta;
        else return -1;
    }
}
