package padrinhodobem.utils;

import java.util.regex.Pattern;

/**
 *
 * @author herbert
 */
public class ValidadorEmail {
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }
}
