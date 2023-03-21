public class Figurinha {
    private String nome,pais,pos;
    private int nasc;
    private float alt,pes;
    void Figurinha(String no, int na, float a, float peso, String posi, String p)
    {
        nome = no; nasc = na; alt = a; pes = peso; pos = posi; pais = p;
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
