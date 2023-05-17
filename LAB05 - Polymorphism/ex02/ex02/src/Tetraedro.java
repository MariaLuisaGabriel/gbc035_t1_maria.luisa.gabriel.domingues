public class Tetraedro extends FormaTridimensional{
    private int l;
    public Tetraedro(int lado)
    {
        l = lado;
    }
    double getArea()
    {
        return l*l*(Math.sqrt(3));
    }

    void descricao()
    {
        System.out.println("TETRAEDRO: é a forma gerada pela disposoção de 4 triângulos unidos pelos seus vértices");
    }
    double getVolume()
    {
        return (l*l*l*(Math.sqrt(2)))/12; //jeito de conseguir volume só com o lado do tetraedro (regular)
    }
}
