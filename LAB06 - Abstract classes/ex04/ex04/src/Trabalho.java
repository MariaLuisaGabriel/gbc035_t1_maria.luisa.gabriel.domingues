public class Trabalho extends Contato{
    String tipo;
    public Trabalho(String n, String e, String a, String niver, String t)
    {
        nome = n;
        email = e;
        aniversario = niver;
        apelido = a;
        tipo = t;
    }

    public void imprimirContato()
    {
        System.out.print(super.imprimirBasico());
        System.out.print(", "+tipo);
    }
}
