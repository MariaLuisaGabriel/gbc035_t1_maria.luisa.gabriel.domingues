public class CamaroteSuperior extends VIP{
    private int extra;
    private int local;
    public CamaroteSuperior(int valor, int e, int e2, int local)
    {
        super(valor,e);
        extra = e2;
        this.local = local;
    }
    void mostra()
    {
        System.out.println("CAMAROTE SUPERIOR -> posicao: "+local+"\nvalor: "+(this.extra+super.extra+valor));
    }
}
