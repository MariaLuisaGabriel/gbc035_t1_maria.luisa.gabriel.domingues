public class Empresa {
    public static void main(String[] args) {
        Funcionario[] a = new Funcionario[10];

        for(int i = 0; i<4; i++ ) {
            switch (i) {
                case 0:
                    a[i] = new Chefe("robertos chefes", 10);
                    break;
                case 1:
                    a[i] = new Vendedor("robertos vendedores", 11);
                    break;
                case 2:
                    a[i] = new Operario("robertos operarios", 12);
                    break;
                case 3:
                    a[i] = new Horista("robertos horistas", 13);
                    break;
            }
        }

        for(int i = 0; i<4 ; i++){
           if(i == 0) a[i].add_sal(12000, 0);
           else a[i].add_sal(120, 13);
        }
        FolhaPagamento fp = new FolhaPagamento();
        fp.declaraFolha(a,4);
    }
}