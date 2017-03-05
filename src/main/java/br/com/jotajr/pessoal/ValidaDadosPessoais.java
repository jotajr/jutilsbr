package br.com.jotajr.pessoal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by j.freitas.junior on 05/03/2017.
 */
public class ValidaDadosPessoais {

    private static ValidaDadosPessoais ourInstance;

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static ValidaDadosPessoais getInstance() {
        if(ourInstance != null) {
            ourInstance = new ValidaDadosPessoais();
        }
        return ourInstance;
    }

    private ValidaDadosPessoais() {
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf==null) || (cpf.length()!=11)) {
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }

    public static boolean isValidCNPJ(String cnpj) {

        if ((cnpj==null)||(cnpj.length()!=14)) {
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    /**
     * Método responsável por validar um endereco de email
     * @param email email a ser validado
     * @return true para um email valido e false caso contrário
     */
    public static boolean validaEmail(String email) {

        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
