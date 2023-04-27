public class Figurinha {
    private String nome,pais,pos;
    private int nasc;
    private float alt,pes;
    public Figurinha(String nom, String p, String po, int na, float al, float pe)
    {
        nome = nom; nasc = na; alt = al; pes = pe; pos = po; pais = p;
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

    String getNome()
    {
        return nome;
    }
    String getPais()
    {
        return pais;
    }
    String getPos()
    {
        return pos;
    }
    int getNasc()
    {
        return nasc;
    }

    float getAlt()
    {
        return alt;
    }

    float getPes()
    {
        return pes;
    }
}
