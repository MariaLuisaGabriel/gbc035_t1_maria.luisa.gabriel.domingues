public class Servico implements Classificavel{
    private float preco;
    public Servico(float p)
    {
        preco = p;
    }
    @Override
    public boolean eMenorQue(Classificavel obj) {
        Servico compara = (Servico) obj;
        if(this.preco<compara.preco)
        {
            return true;
        }
        else {return false;}
    }

    float getpreco()
    {
        return preco;
    }
}
