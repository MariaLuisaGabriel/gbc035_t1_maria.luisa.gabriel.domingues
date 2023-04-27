public class Main {
    public static void main(String[] args) {
        Figurinha f = new Figurinha("zezim bao de bola", "Brasil", "atacante", 12, 1.78F, 63.4F);
        FigurinhaExtra fe = new FigurinhaExtra("Rookie", "Bordô", f);

        f.Show();
        fe.Show();
    }
}