public class Quadrado extends FormaBidimensional{
    private int l;
    public Quadrado(int lado)
    {
        l = lado;
    }

    void descricao()
    {
        System.out.println("QUADRADO: é uma forma gerada por 4 segmentos de reta iguais juntados nos extremos e paralelos em pares");
    }
    double getArea()
    {
        return l*l;
    }
}
