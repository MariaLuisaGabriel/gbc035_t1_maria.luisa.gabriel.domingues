public class Main {
    public static void main(String[] args) {
        ContaCorrente a = new ContaCorrente(1000.0F,1011010,10);
        float lim = 100.0F;
        System.out.println("saldo da conta: "+a.getSaldo(10)+"\ndebitando 1000 dinheiros...");
        a.debitaValor(1000.0F,10);
        int b = a.getEstado(10);
        if(b!=1) System.out.println("conta inativa, devido ao saldo ser "+a.getSaldo(10));
    }
}