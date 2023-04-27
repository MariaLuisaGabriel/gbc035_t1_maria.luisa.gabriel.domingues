public class Main {
    public static void main(String[] args) {
        Ingresso i = new Ingresso(10);
        i.mostraValor();
        VIP v = new VIP(10,3);
        v.mostraValor();
        Normal n = new Normal(10);
        n.print();
        CamaroteInferior ci = new CamaroteInferior(10,3,11);
        ci.mostra();
        CamaroteSuperior cs = new CamaroteSuperior(10,3,2,12);
        cs.mostra();
    }
}