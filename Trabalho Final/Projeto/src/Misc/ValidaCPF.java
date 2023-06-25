package Misc;
import br.com.caelum.stella.validation.CPFValidator;
import java.util.InputMismatchException;

public class ValidaCPF {

    public static boolean isCPF(String cpf)
    {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
