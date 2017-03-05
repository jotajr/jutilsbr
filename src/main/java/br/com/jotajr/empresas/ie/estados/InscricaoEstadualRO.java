package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualRO extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR_1 = new Integer[]{Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};
    private static final Integer[] MULTIPLICADOR_2 = new Integer[]{Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualRO() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        Integer[] calculo;
        int digito;
        if(ie.length() == 9) {
            String numeros = ie.substring(3);
            calculo = this.split(numeros);
            Integer[] soma = this.multiplicar(calculo, MULTIPLICADOR_1);
            digito = this.somar(soma);
            int digito1 = 11 - this.modulo11(digito);
            if(digito1 == 10 || digito1 == 11) {
                digito1 -= 10;
            }

            valido = calculo[5].intValue() == digito1;
        } else if(ie.length() == 14) {
            Integer[] numeros1 = this.split(ie);
            calculo = this.multiplicar(numeros1, MULTIPLICADOR_2);
            int soma1 = this.somar(calculo);
            digito = 11 - this.modulo11(soma1);
            if(digito == 10 || digito == 11) {
                digito -= 10;
            }

            valido = numeros1[13].intValue() == digito;
        }

        return valido;
    }
}

