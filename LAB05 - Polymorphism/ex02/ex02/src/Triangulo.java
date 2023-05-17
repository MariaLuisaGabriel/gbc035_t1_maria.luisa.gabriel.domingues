public class Triangulo extends FormaBidimensional{
    private int b, h;
    public Triangulo(int base, int altura)
    {
        b = base;
        h = altura;
    }

    void descricao()
    {
        System.out.println("TRIÂNGULO: é uma forma gerada ao unir três segmentos de reta pelos seus extremos.");
    }
    double getArea()
    {
        return (b*h)/2;
    }
}
