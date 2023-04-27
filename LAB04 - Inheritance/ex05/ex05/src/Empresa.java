public class Empresa {
    public static void main(String[] args) {
        Chefe[] a = new Chefe[10];
        Vendedor[] b = new Vendedor[10];
        Operario[] c = new Operario[10];
        Horista[] d = new Horista[10];

        for(int i = 0; i<2; i++ ){
            a[i] = new Chefe("robertos chefes", 10);
            b[i] = new Vendedor("robertos vendedores", 11);
            c[i] = new Operario("robertos operarios", 12);
            d[i] = new Horista("robertos horistas", 13);
        }

        for(int i = 0; i<2 ; i++){
           a[i].add_sal();
           b[i].add_sal(10, 20);
           c[i].add_sal(30.5F, 30);
           d[i].add_sal(13.3F, 35);
        }
    }
}