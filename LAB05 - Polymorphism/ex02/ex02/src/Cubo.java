public class Cubo extends FormaTridimensional{
    private int l;
    public Cubo(int lado)
    {
        l = lado;
    }
    double getArea()
    {
        return l*l*6;
    }

    void descricao()
    {
        System.out.println("CUBO: é a forma gerada pelo empilhamento de quadrados idênticos, até chegar a uma certa altura 'l'");
    }
    double getVolume()
    {
        return l*l*l;
    }
}
