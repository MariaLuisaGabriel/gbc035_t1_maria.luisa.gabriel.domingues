public class Figurinha {
    protected String nome,pais,pos;
    protected int nasc;
    protected float alt,pes;
    public Figurinha(String p)
    {
        nome = "zezim bom de bola"; nasc = 1; alt = 1.2F; pes = 60.0F; pos = "atacante"; pais = p;
    }
    void Show()
    {
        System.out.println("nome: "+nome);
        System.out.println("data de nascimento: "+nasc);
        System.out.println("altura: "+alt);
        System.out.println("peso: "+pes);
        System.out.println("posição: "+pos);
        System.out.println("país de nascimento: "+pais+"\n");
    }
}
