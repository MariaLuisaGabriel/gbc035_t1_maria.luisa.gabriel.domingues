public class C3 extends C2{
    public int a2;
    protected int b2;
    private int c2;
    public C3(){
        super();
        System.out.println("classe C3: construtor sem parametro");
        a2 = 7;
        b2 = 8;
        c2 = 9;
    }

    void criaC3(int p, int s, int t){
        super.criaC2(p-3,s-3,t-3);
        System.out.println("classe C3: construtor com parametro");
        a2 = p; b2 = s; c2 = t;
    }

    @Override
    void mostrar_atributos(){
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("c: "+getC());
        System.out.println("a1: "+a1);
        System.out.println("b1: "+b1);
        System.out.println("c1: "+getC1());
        System.out.println("a2: "+a2);
        System.out.println("b2: "+b2);
        System.out.println("c2: "+c2);
    }

    @Override
    void mostrar_atributos_super() {
        super.mostrar_atributos_super();
        System.out.println("a2: "+a2);
        System.out.println("b2: "+b2);
        System.out.println("c2: "+c2);
    }
}
