public class Esfera extends FormaTridimensional{
    private int r;
    public Esfera(int raio)
    {
        r = raio;
    }
    double getArea()
    {
        return 4*(Math.PI)*r*r;
    }

    void descricao()
    {
        System.out.println("ESFERA: é o traço formado pela rotação de um círculo em volta de seu próprio centro, em 180°");
    }

    double getVolume()
    {
        return (4*(Math.PI)*r*r*r)/3;
    }
}
