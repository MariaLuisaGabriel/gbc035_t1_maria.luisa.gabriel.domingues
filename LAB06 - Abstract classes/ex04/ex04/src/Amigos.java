public class Amigos extends Contato{
    int grau;
    public Amigos(String n, String e, String a, String niver, int g)
    {
        nome = n;
        email = e;
        aniversario = niver;
        apelido = a;
        grau = g;
    }

    public void imprimirContato()
    {
        System.out.print(super.imprimirBasico());
        if(grau==1)
        {
            System.out.print(", melhor amigo");
        }
        if(grau==2)
        {
            System.out.print(", amigo");
        }
        if(grau==3)
        {
            System.out.print(", conhecido");
        }
    }


}
