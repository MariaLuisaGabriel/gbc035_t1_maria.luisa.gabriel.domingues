public class FigurinhaExtra {
    private String nome,pais,pos;
    private int nasc;
    private float alt,pes;
    private String cat;
    private String cor;
    public FigurinhaExtra(String ca, String c)
    {
        nome = "zezim bom de bola"; nasc = 1; alt = 1.2F; pes = 60.0F; pos = "atacante"; pais = "Brasil";
        cat = ca; cor = c;
    }
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
