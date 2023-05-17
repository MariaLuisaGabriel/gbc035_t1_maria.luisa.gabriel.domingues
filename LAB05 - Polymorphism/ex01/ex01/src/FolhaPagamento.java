public class FolhaPagamento {
    void declaraFolha(Funcionario[] a, int b)
    {
        int ac = 0;
        System.out.println("FOLHA DE PAGAMENTO: ");
        for(int i=0; i<b; i++)
        {
            System.out.println(a[i].nome+": "+a[i].sal);
            ac = ac + a[i].sal;
        }
        System.out.println("pagamento total: "+ac);
    }
}
