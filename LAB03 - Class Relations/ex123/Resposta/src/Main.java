public class Main {
    public static void main(String[] args) {
        //associação: aluno e professor (professor leciona aluno)
        //sim, o professor e o aluno são independentes, mesmo que interajam (professor leciona aluno)
        Aluno[] a = new Aluno[3];
        a[0] = new Aluno("jubiscreudo",18,123456);
        a[1] = new Aluno("jubiscreuda",19,123450);
        a[2] = new Aluno("jubiscreudinho",17,123451);
        for(int i=0;i<3;i++)
        {
            a[i].Show();
        }
        Professor[] p = new Professor[3];
        p[0] = new Professor("jubscreudasso",34);
        p[1] = new Professor("jubscreudassasso",40);
        p[2] = new Professor("jubscreudassoassoassoasso",55);
        for(int i=0;i<3;i++)
        {
            p[i].Show();
        }

        //agregação: aluno é parte de uma turma (um aluno participa de uma ou mais turmas)
        //enquanto aluno é independente (pode participar de mais turmas, e não é destruído quando uma turma se destrói), a turma depende de alunos para existir (ser instanciada)
        Turma t = new Turma("turminha do balacobaco",3,a);
        t.Show();
        Turma t2 = new Turma("turminha do balacobaco DOIS",3,a);
        t2.Show();
        //composição: a cabeça é uma parte essencial de um aluno (cada aluno tem uma cabeça, a nao ser que ele perca na medida em que ele avança no curso, e a cabeça é parte importantíssima de aluno)
        //se remover o objeto todo (aluno), o objeto parte (cabeça), também deixa de existir
        Cabeça c1 = new Cabeça(a[0]);
        c1.apresentar();
        Cabeça c2 = new Cabeça(a[1]);
        c2.apresentar();
        Cabeça c3 = new Cabeça(a[2]);
        c3.apresentar();

        //algumas açõeszinhas >:) :
        a[0].chorar_no_banho();
        c1.delirar();
        c1.fritar();
        c1.delirar();
        p[0].preparar_aula();
        p[0].dar_aula(a[0]);
        p[0].preparar_aula();
        p[0].dar_aula(a[1]);
        p[0].sofrer();
        p[0].dormir();

        p[1].chorar_no_banho();
        p[1].dormir();
        a[1].dormir();
        c2.sonhar();
        a[1].estudar();
        a[1].chorar_no_banho();
        c2.sofrer();

        p[2].dar_aula(a[2]);
        p[2].dar_aula(a[2]);
        a[2].estudar();
        a[2].estudar();
        a[2].estudar();
        a[2].estudar();
        a[2].estudar();
        a[2].estudar();
        c3.fritar();
        p[2].sofrer();
        c3.fritar();
        c3.fritar();
        c3.fritar();
        c3.fritar();
        c3.fritar();
        a[2].chorar_no_banho();
        a[2].chorar_no_banho();
        a[2].chorar_no_banho();
        a[2].chorar_no_banho();
        a[2].chorar_no_banho();
        a[2].chorar_no_banho();
        a[2].chorar_no_banho();
        c3.sofrer();
        c3.sofrer();
        c3.sofrer();
        c3.sofrer();
        a[2].dormir();
        c3.sonhar();
    }
}