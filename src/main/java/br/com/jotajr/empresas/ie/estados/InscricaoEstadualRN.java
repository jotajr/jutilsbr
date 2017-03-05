package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualRN extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR_1 = new Integer[]{Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};
    private static final Integer[] MULTIPLICADOR_2 = new Integer[]{Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualRN() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        Integer[] numeros;
        Integer[] calculo;
        int soma;
        int digito;
        if(ie.length() == 9 && "20".equals(ie.substring(0, 2))) {
            numeros = this.split(ie);
            calculo = this.multiplicar(numeros, MULTIPLICADOR_1);
            soma = this.somar(calculo);
            digito = this.modulo11(soma * 10);
            if(digito == 10) {
                digito = 0;
            }

            valido = numeros[8].intValue() == digito;
        } else if(ie.length() == 10 && "20".equals(ie.substring(0, 2))) {
            numeros = this.split(ie);
            calculo = this.multiplicar(numeros, MULTIPLICADOR_2);
            soma = this.somar(calculo);
            digito = this.modulo11(soma * 10);
            if(digito == 10) {
                digito = 0;
            }

            valido = numeros[9].intValue() == digito;
        }

        return valido;
    }
}

