public class Selecao {
    private String Nome;
    private Figurinha[] titulares = new Figurinha[11];
    private String tecnico;
    public Selecao(String nome,String tec,String p){
        Nome = nome;
        tecnico = tec;
        for(int i = 0; i<11; i++){
            titulares[i] = new Figurinha(p);
        }
    }
    void Show(){
        System.out.println("nome da Selecao: "+Nome);
        System.out.println("nome do tecnico: "+tecnico);
        for(int i = 0; i<11; i++){
            System.out.println("titular "+(i+1)+" :");
            titulares[i].Show();
            System.out.println("\n");
        }
    }
}
