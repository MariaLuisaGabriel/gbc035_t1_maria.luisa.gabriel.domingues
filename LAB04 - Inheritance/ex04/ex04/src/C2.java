public class C2 extends C1{
    public int a1;
    protected int b1;
    private int c1;
    public C2(){
        super();
        System.out.println("classe C2: construtor sem parametro");
        a1 = 3;
        b1 = 4;
        c1 = 5;
    }

    void criaC2(int p, int s, int t){
        super.criaC1(p-3,s-3,t-3);
        System.out.println("classe C2: construtor com parametro");
        a1 = p; b1 = s; c1 = t;
    }
    @Override
    void mostrar_atributos(){
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("c: "+getC());
        System.out.println("a1: "+a1);
        System.out.println("b1: "+b1);
        System.out.println("c1: "+c1);
    }
    @Override
    void mostrar_atributos_super(){
        super.mostrar_atributos_super();
        System.out.println("a1: "+a1);
        System.out.println("b1: "+b1);
        System.out.println("c1: "+c1);
    }
    int getC1(){
        return c1;
    }
}
