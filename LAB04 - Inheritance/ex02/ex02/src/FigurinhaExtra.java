public class FigurinhaExtra extends Figurinha{
    private String cat;
    private String cor;
    public FigurinhaExtra(String ca, String c, String p)
    {
        super(p);
        cat = ca; cor = c;
    }
    @Override
    void Show()
    {
        System.out.println("categoria da figurinha: "+cat);
        System.out.println("cor: "+cor);
        System.out.println("nome: "+nome);
        System.out.println("data de nascimento: "+nasc);
        System.out.println("altura: "+alt);
        System.out.println("peso: "+pes);
        System.out.println("posição: "+pos);
        System.out.println("país de nascimento: "+pais+"\n");
    }
}
