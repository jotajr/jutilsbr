package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualMS extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR = new Integer[]{Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualMS() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        if(ie.length() == 9 && "28".equals(ie.substring(0, 2))) {
            Integer[] numeros = this.split(ie);
            Integer[] calculo = this.multiplicar(numeros, MULTIPLICADOR);
            int soma = this.somar(calculo);
            int digito = 11 - this.modulo11(soma);
            if(digito == 10 || digito == 11) {
                digito = 0;
            }

            valido = numeros[8].intValue() == digito;
        }

        return valido;
    }
}

