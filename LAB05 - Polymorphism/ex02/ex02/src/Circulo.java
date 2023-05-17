public class Circulo extends FormaBidimensional{
    private int r;
    public Circulo(int raio){
        r = raio;
    }

    void descricao()
    {
        System.out.println("CÍRCULO: é uma forma geométrica gerada por infinitos pontos que distam exatamente r unidades de distância a um ponto no espaço.");
    }
    double getArea()
    {
        return (Math.PI)*r*r;
    }
}
