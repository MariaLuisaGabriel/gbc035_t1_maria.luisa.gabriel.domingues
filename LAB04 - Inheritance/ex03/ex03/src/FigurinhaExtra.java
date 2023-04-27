public class FigurinhaExtra extends Figurinha{
    private String cat;
    private String cor;
    public FigurinhaExtra(String ca, String c, Figurinha f)
    {
        super(f.getNome(), f.getPais(), f.getPos(), f.getNasc(), f.getAlt(), f.getPes());
        cat = ca; cor = c;
    }
    @Override
    void Show()
    {
        System.out.println("categoria da figurinha: "+cat);
        System.out.println("cor: "+cor);
        super.Show();
    }
}
