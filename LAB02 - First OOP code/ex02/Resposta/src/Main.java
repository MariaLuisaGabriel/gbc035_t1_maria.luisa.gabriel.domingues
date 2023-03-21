import java.lang.reflect.Method;
public class Main {
    public static void main(String[] args) throws Exception{
        Class a = Class.forName("Figurinha");
        Object f1 = a.newInstance();
        Object f2 = a.newInstance();
        Object f3 = a.newInstance();
        Method m = a.getDeclaredMethod("Figurinha",String.class, int.class, float.class, float.class, String.class, String.class);
        Method m2 = a.getDeclaredMethod("Show",null);
        m.setAccessible(true);
        m.invoke(f1,"zezin bom de bola",26,1.76F, (float) 70.8F,"atacante de cria","Brasil");
        m.invoke(f2,"zezin marromeno bom de bola",26,1.76F, (float) 70.8F,"atacante de cria","Brasil");
        m.invoke(f3,"zezin ruim de bola",26,1.76F, (float) 70.8F,"atacante de cria","Brasil");
        m2.setAccessible(true);
        m2.invoke(f1,null);
        m2.invoke(f2,null);
        m2.invoke(f3,null);
    }
}