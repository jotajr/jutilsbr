package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualGO extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR = new Integer[]{Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualGO() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        if(ie.length() == 9) {
            int base = this.toInt(ie.substring(0, 2));
            if(this.in(base, new Integer[]{Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(15)})) {
                int num = this.toInt(ie.substring(0, 8));
                Integer[] numeros = this.split(ie);
                Integer[] calculo = this.multiplicar(numeros, MULTIPLICADOR);
                int soma = this.somar(calculo);
                int digito = 11 - this.modulo11(soma);
                if(digito == 11) {
                    digito = 0;
                } else if(digito == 10 && num >= 10103105 && num <= 10119997) {
                    digito = 1;
                } else if(digito == 10) {
                    digito = 0;
                }

                if(num == 11094402 && numeros[8].intValue() == 1) {
                    digito = 1;
                }

                valido = numeros[8].intValue() == digito;
            }
        }

        return valido;
    }
}
