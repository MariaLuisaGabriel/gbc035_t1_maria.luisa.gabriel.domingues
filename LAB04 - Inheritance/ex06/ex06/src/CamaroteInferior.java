public class CamaroteInferior extends VIP{
    private int local;
    public CamaroteInferior(int valor, int e, int local)
    {
        super(valor,e);
        this.local = local;
    }
    void mostra()
    {
        System.out.println("CAMAROTE INFERIOR -> valor: "+(extra+valor));
    }
}
