import java.util.Scanner;
import java.util.Arrays;

//questao 01
/*public class Main {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[6];

        System.out.println("escreva o valor numero 1: ");
        vetor[0] = ler.nextInt();
        System.out.println("escreva o valor numero 2: ");
        vetor[1] = ler.nextInt();
        System.out.println("escreva o valor numero 3: ");
        vetor[2] = ler.nextInt();
        System.out.println("escreva o valor numero 4: ");
        vetor[3] = ler.nextInt();
        System.out.println("escreva o valor numero 5: ");
        vetor[4] = ler.nextInt();
        System.out.println("escreva o valor numero 6: ");
        vetor[5] = ler.nextInt();

        System.out.println("valores lidos:" + Arrays.toString(vetor) );
    }
}*/

//questao 02
/*public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[6];

        for(int i = 0;i<6;i++) {
            System.out.println("\nescreva o valor numero " + (i+1) + " :");
            vetor[i] = ler.nextInt();
        }
        System.out.println("valores lidos:" + Arrays.toString(vetor));
    }
}*/

//questao 03
/*public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[6];

        for(int i = 0;i<6;i++) {
            System.out.println("\nescreva o valor numero " + (i+1) + " :");
            vetor[i] = ler.nextInt();
        }
        System.out.println("valores lidos ao contrario:");
        for(int i = 5; i>=0;i--) {
            System.out.print(vetor[i] + " ");
        }
    }
}*/

//questao 04
/*public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[6];
        int i = 0;

        while(i<6) {
            System.out.println("\nescreva o valor numero " + (i+1) + " :");
            vetor[i] = ler.nextInt();
            if(vetor[i]%2==1) System.out.println("Erro, input invalido.");
            else i++;
        }
        System.out.println("valores lidos:" + Arrays.toString(vetor));
    }
}*/

//questao 05
/*public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[5];

        for(int i = 0;i<5;i++) {
            System.out.println("\nescreva o valor numero " + (i+1) + " :");
            vetor[i] = ler.nextInt();
        }
        int max = vetor[0];
        int min = max;
        float med = 0.0F;
        for(int i=1;i<5;i++){
            med = med + vetor[i];
            if(max<vetor[i]) max = vetor[i];
            if(min>vetor[i]) min = vetor[i];
        }
        med = med/5;
        System.out.println("valores lidos:" + Arrays.toString(vetor));
        System.out.println("maior valor:" + max);
        System.out.println("menor valor:" + min);
        System.out.println("media:" + med);
    }
}*/

//questao 06
/*public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[5];

        for(int i = 0;i<5;i++) {
            System.out.println("\nescreva o valor numero " + (i+1) + " :");
            vetor[i] = ler.nextInt();
        }
        int max = vetor[0];
        int min = max;
        int imin = 0;
        int imax = 0;
        for(int i=1;i<5;i++){
            if(max<vetor[i]) {max = vetor[i];imax = i;}
            if(min>vetor[i]) {min = vetor[i];imin = i;}
        }
        System.out.println("valores lidos:" + Arrays.toString(vetor));
        System.out.println("maior valor:" + max + " , sua posicao: " + imax);
        System.out.println("menor valor:" + min + " , sua posicao: " + imin);
    }
}*/

//questao 07
/*public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[5];
        float fator = 0.0F;
        int max = 0;

        for(int i = 0;i<5;i++) {
            System.out.println("\nentre com a nota do aluno " + (i+1) + " :");
            vetor[i] = ler.nextInt();
            if(max<vetor[i]) max = vetor[i];
        }
        fator = (float) (100.0/max);
        System.out.println("Notas normalizadas" + fator);
        for(int i = 0;i<5;i++) {
            System.out.printf("\na nota do aluno " + (i+1) + " eh : %.2f",(vetor[i]*fator));
        }
    }
}*/

//questao 08
/*public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[8];
        double sum = 0.0F;

        for(int i = 0;i<8;i++) {
            System.out.println("\nescreva o valor numero " + (i+1) + " :");
            vetor[i] = ler.nextInt();
        }
        double med = 0.0F;
        for(int i=1;i<8;i++){
            med = med + vetor[i];
        }
        med = (float)(med/8);
        for(int i=0;i<8;i++){
            sum = sum + Math.pow((vetor[i]-med),2);
        }
        sum = sum/8;
        double rt = Math.sqrt(sum);
        System.out.println("valores lidos:" + Arrays.toString(vetor));
        System.out.println("media: "+med+", desvio padrao: "+rt);
    }
}*/

//questao 09
/*public class Main{
    public static void main(String[] args){
        int al=0;
        boolean ver = true;
        float med=0.0F;
        Scanner scan = new Scanner(System.in);
        while(ver)
        {
            System.out.println("entre com o numero de alunos: ");
            al = scan.nextInt();
            if(al>100)
            {
                System.out.println("Erro! o numero maximo de alunos permitidos sao 100");
            }
            else ver = false;
        }
        int[] alunos = new int[al];
        for(int i=0;i<al;i++)
        {
            System.out.println("Digite a nota do aluno "+(i+1)+":");
            alunos[i]=scan.nextInt();
            med = med+alunos[i];
        }
        med = med/al;
        for(int i=0;i<al;i++)
        {
            System.out.println("nota do aluno "+(i+1)+": "+alunos[i]);
        }
        System.out.println("a media da turma eh: "+med);
    }
}*/

//questao 10
/*public class Main{
    public static void main(String[] args){int aux;
        int[] a = new int[3];
        int[] b = new int[3];
        int[] c = new int[3];
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i<3;i++)
        {
            System.out.println("escreva o valor "+(i+1)+" de A: ");
            a[i] = scan.nextInt();
        }
        for(int i = 0;i<3;i++)
        {
            System.out.println("escreva o valor "+(i+1)+" de B: ");
            b[i] = scan.nextInt();
        }
        for(int i = 0;i<3;i++)
        {
            c[i] = a[i]-b[i];
        }
        System.out.println("o Vetor C, definido como C = A-B eh "+Arrays.toString(c));
    }
}*/

//questao 11
/*public class Main{
    public static void main(String[] args){
        int aux;
        int[] v1 = new int[5];
        int j=0;
        int[] v2 = new int[5];
        int k=0;
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i<5;i++)
        {
            System.out.println("escreva o valor "+(i+1)+": ");
            aux = scan.nextInt();
            if(aux%2==0)
            {
                v1[j] = aux;
                j++;
            }
            else
            {
                v2[k] = aux;
                k++;
            }
        }
        System.out.println("Impares: ");
        mostra(v2,k);
        System.out.println("Pares: ");
        mostra(v1,j);
    }
    static void mostra(int[] vet, int tam)
    {
        for(int i=0;i<tam;i++)
        {
            System.out.print(vet[i]+" ");
        }
        System.out.print("\n");
    }
}*/

//questao 11
/*public class Main{
    public static void main(String[] args){
        float total = 0;
        float[] vet = new float[4];
        float[] med = new float[4];
        int max=0;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a quantidade de bolinhas: ");
        System.out.println("Verde: ");
        vet[0]=s.nextInt();
        total = total + vet[0];
        if(max<vet[0]) max = 0;
        System.out.println("Azul: ");
        vet[1]=s.nextInt();
        total = total + vet[1];
        if(max<vet[1]) max = 1;
        System.out.println("Amarela: ");
        vet[2]=s.nextInt();
        total = total + vet[2];
        if(max<vet[2]) max = 2;
        System.out.println("Vermelha: ");
        vet[3]=s.nextInt();
        total = total + vet[3];
        if(max<vet[3]) max = 3;
        med[0] = vet[0]/total;
        med[1] = vet[1]/total;
        med[2] = vet[2]/total;
        med[3] = vet[3]/total;
        System.out.println("Probabilidades: ");
        for(int i=0;i<4;i++)
        {
            switch(i)
            {
                case 0:
                {
                    System.out.print("\nVerde: ");
                    System.out.print(med[i]*100 + "%");
                    break;
                }
                case 1:
                {
                    System.out.print("\nAzul: ");
                    System.out.print(med[i]*100 + "%");
                    break;
                }
                case 2:
                {
                    System.out.print("\nAmarela: ");
                    System.out.print(med[i]*100 + "%");
                    break;
                }
                case 3:
                {
                    System.out.print("\nVermelha: ");
                    System.out.print(med[i]*100 + "%");
                    break;
                }
            }
            if(max==i) System.out.print("<< Maior probabilidade");
        }
        System.out.print("\n");
    }
}*/

//questao 13
/*public class Main{
    public static void main(String[] args){
        int[] v1 = new int[5];
        Scanner scan = new Scanner(System.in);
        System.out.println("ZERANDO NEGATIVOS");
        for(int i = 0;i<5;i++)
        {
            System.out.println("escreva o valor "+(i+1)+": ");
            v1[i] = scan.nextInt();
            if(v1[i]<0)
            {
                v1[i] = 0;
            }
        }
        System.out.println("Zerando os negativos, obtém-se: "+Arrays.toString(v1));
    }
}*/

//questao 14
/*public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int q;
        System.out.println("escreva quantos alunos serao cadastrados: ");
        q = scan.nextInt();
        int[] mat = new int[q];
        String[] cl = new String[q];
        float[] CRA = new float[q];
        for(int i = 0;i<q;i++)
        {
            System.out.println("entre com o numero do aluno "+(i+1)+": ");
            mat[i] = scan.nextInt();
            System.out.println("entre com a classe social do aluno "+(i+1)+": ");
            cl[i] = scan.next();
            System.out.println("entre com o CRA do aluno "+(i+1)+": ");
            CRA[i] = scan.nextFloat();
        }
        System.out.println("--Alunos cadastrados: --");
        for(int i = 0;i<q;i++)
        {
            System.out.print("Numero: "+mat[i]+" Classe Social: "+cl[i]+" CRA: "+CRA[i]);
            System.out.print("\n");
        }
    }
}*/

//questao 15
/*public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] mat = new int[8];
        int k,j;
        boolean rep;
        for(int i = 0;i<8;i++)
        {
            System.out.println("entre com o numero "+(i+1)+": ");
            mat[i] = scan.nextInt();
        }
        System.out.println("Valores repetidos: ");
        for(k=0;k<8;k++)
        {
            rep=false;
            for(j=0;j<k;j++)
            {
                if(mat[j]==mat[k])
                {
                    rep = true;
                    break;
                }
            }
            if(!rep)
            {
                for(j=k+1;j<8;j++)
                {
                    if(mat[k]==mat[j])
                    {
                        System.out.print(mat[k]+", ");
                        break;
                    }
                }
            }
        }
    }
}*/

//questao 16
/*public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] mat = new int[8];
        int[][] aux = new int[8][2];
        int a;
        int aux1 = 0;
        boolean[] check = new boolean[8];
        for(int i=0;i<8;i++)
        {
            check[i]=true;
        }
        for(int i = 0;i<8;i++)
        {
            System.out.println("entre com o numero "+(i+1)+": ");
            mat[i] = scan.nextInt();
        }
        System.out.println("Valores repetidos: ");
        for(int i=0;i<8;i++)
        {
            aux1 = mat[i];
            a = ocorrencias(aux1,mat);
            aux[i][0]=mat[i];
            aux[i][1]=a;
        }
        for(int i=0;i<8;i++)
        {
            if(check[i])
            {
                for(int j=i+1;j<=8;j++)
                {
                    if(j==8) break;
                    if(aux[i][0] == aux[j][0])
                    {
                        check[j]=false;
                    }
                }
            }
        }
        for(int i = 0;i<8;i++)
        {
            if(check[i]) {
                if(aux[i][1]>1) System.out.println(aux[i][0] + " aparece " + aux[i][1] + " vezes;");
            }
        }
    }
    static int ocorrencias(int x,int[] v)
    {
        int a=0;
        for(int i=0;i<v.length;i++)
        {
            if(x == v[i]) a++;
        }
        return a;
    }
}*/