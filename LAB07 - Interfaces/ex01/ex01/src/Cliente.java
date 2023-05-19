public class Cliente implements Classificavel{
    private String nome;
    public Cliente(String n)
    {
        nome = n;
    }
    @Override
    public boolean eMenorQue(Classificavel obj) {
        Cliente compara = (Cliente) obj;
        if((compara.getnome()).compareTo(this.nome)>0) //significa compara.nome>this.nome
        {
            return true;
        }
        else{return false;}
    }

    String getnome()
    {
        return nome;
    }
}
