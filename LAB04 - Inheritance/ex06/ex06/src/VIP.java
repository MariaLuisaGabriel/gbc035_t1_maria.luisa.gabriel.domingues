public class VIP extends Ingresso{
    protected int extra;
    public VIP(int v,int e)
    {
        super(v);
        extra = e;
    }

    @Override
    void mostraValor() {
        System.out.println("INGRESSO VIP -> valor: "+(extra+valor));
    }
}
