public class Main {
    public static void main(String[] args) {
        Forma[] f = new Forma[6];
        f[0] = new Circulo(2);
        f[1] = new Triangulo(2,4);
        f[2] = new Quadrado(4);
        f[3] = new Tetraedro(2);
        f[4] = new Cubo(2);
        f[5] = new Esfera(3);

        for(int i = 0; i<6; i++)
        {
            f[i].descricao();
            if(f[i] instanceof FormaTridimensional)
            {
                System.out.println("volume: "+f[i].getVolume());
            }
            else
            {
                System.out.println("Area: "+f[i].getArea());
            }
        }
    }
}