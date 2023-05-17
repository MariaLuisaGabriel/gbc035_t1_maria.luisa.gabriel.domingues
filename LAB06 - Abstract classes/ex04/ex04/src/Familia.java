public class Familia extends Contato{
    String parentesco;
    public Familia(String n, String e, String a, String niver, String p)
    {
        parentesco = p;
        nome = n;
        email = e;
        aniversario = niver;
        apelido = a;
    }

    public void imprimirContato()
    {
        System.out.print(super.imprimirBasico());
        System.out.print(", parentesco: "+parentesco);
    }
}
