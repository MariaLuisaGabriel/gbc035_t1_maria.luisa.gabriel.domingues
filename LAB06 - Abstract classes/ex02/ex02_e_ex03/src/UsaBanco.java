public class UsaBanco {
    public static void main(String[] args) {
        ContaCorrente[] a = new ContaCorrente[3];
        float lim = 100.0F;
        for(int i = 0; i<3; i++) {
            a[i] = new ContaEspecial(i, i);
        }

        a[0].setLimite(0,lim);//conta especial
        ContaComum b = a[0].verificaLimite(0);
        if(b!=null) System.out.println("conta especial 1 foi modificada para conta comum, visto que seu limite é 0.");

        a[0].creditaValor(0,20.0F);
        a[0].debitaValor(10.0F,0);
        System.out.println("saldo da conta 1:"+a[0].getSaldo(0));
        boolean B = a[0].verificaEstado(0);
        if(B==false) System.out.println("conta 1 esta inativa");

        a[1].setLimite(1,0.0F);//conta especial que vira conta comum, pois seu limite é zero
        b = a[1].verificaLimite(1);
        if(b!=null) System.out.println("conta especial 2 foi modificada para conta comum, visto que seu limite é 0.");

        b.creditaValor(1,20.0F);
        b.debitaValor(20.0F,1);//conta comum decorrente de a[1], que é inativa por conta do seu saldo ser zero
        System.out.println("saldo da conta 2:"+b.getSaldo(1));
        B = b.verificaEstado(1);
        if(B==false) System.out.println("conta 2 esta inativa, visto que seu saldo eh zero");

        a[2].setLimite(2,lim);//conta especial, que é inativada mais pra frente pois setou seu estado a inativo
        b = a[2].verificaLimite(2);
        if(b!=null) System.out.println("conta especial 3 foi modificada para conta comum, visto que seu limite é 0.");

        a[2].creditaValor(2,14.2F);
        a[2].debitaValor(2.2F,2);
        System.out.println("saldo da conta 3:"+a[2].getSaldo(2));
        a[2].setEstado(2,3);
        B = a[2].verificaEstado(2);
        if(B==false) System.out.println("conta especial 3 esta inativa, por modificacao do estado");
    }
}