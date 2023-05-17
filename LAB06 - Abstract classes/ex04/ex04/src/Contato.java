public abstract class Contato {
    protected String apelido;
    protected String nome;
    protected String email;
    protected String aniversario;

    public String imprimirBasico(){return nome+",chamado de "+apelido+", email: "+email+", niver: "+aniversario;}

    public abstract void imprimirContato();

}
