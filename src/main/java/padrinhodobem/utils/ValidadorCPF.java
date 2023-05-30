package padrinhodobem.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorCPF {

    public static String sanitizeCPF(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }
    
    
    public static boolean validarCPF(String cpf) {
        // Remove a pontuação da string de CPF
        cpf = sanitizeCPF(cpf);
        
        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais, o que torna o CPF inválido
        if (cpf.matches("(\\d)\\1*")) {
            return false;
        }
        
        // Calcula os dígitos verificadores
        int digito1 = calcularDigitoVerificador(cpf.substring(0, 9), 10);
        int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1, 11);
        
        // Verifica se os dígitos verificadores calculados são iguais aos dígitos informados
        return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
    }
    
    private static int calcularDigitoVerificador(String cpfParcial, int peso) {
        int soma = 0;
        for (int i = 0; i < cpfParcial.length(); i++) {
            soma += Character.getNumericValue(cpfParcial.charAt(i)) * peso--;
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }
   
}
