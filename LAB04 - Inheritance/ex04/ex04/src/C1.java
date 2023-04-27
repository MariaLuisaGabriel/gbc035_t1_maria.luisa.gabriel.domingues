public class C1 {
    public int a;
    protected int b;
    private int c;
    public C1(){
        System.out.println("classe C1: construtor sem parametro");
        a = 1;
        b = 2;
        c = 3;
    }

    void criaC1(int p, int s, int t){
        System.out.println("classe C1: construtor com parametro");
        a = p; b = s; c = t;
    }

    void mostrar_atributos(){
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("c: "+c);
    }

    void mostrar_atributos_super(){
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("c: "+c);
    }

    int getC(){
        return c;
    }
}
