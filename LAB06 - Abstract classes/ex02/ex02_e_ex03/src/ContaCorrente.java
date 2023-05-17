abstract class ContaCorrente {
 protected float saldo ;
 protected int estado ; // 1= conta ativa 2= conta inativa
 protected int numConta ;
 protected int senha ;

 public void setEstado ( int pwd , int e ){}
 public boolean verificaEstado(int pwd){return true;}
 public void setLimite (int pwd, float lim){}
 public boolean debitaValor ( float val , int pwd ) {return true;}
 public float getSaldo ( int pwd ) {return -2.0F;}
 float getLimite(int pwd){return -2.0F;}
 int getSenha(int pwd){return pwd;}
 int getNumConta(int pwd){return -10;}
 int getEstado(int pwd){return -9;}
 ContaComum verificaLimite(int pwd){return null;}
 public void creditaValor ( int pwd , float val ) {}
}
