package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualAP extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR = new Integer[]{Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualAP() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        if(ie.length() == 9 && "03".equals(ie.substring(0, 2))) {
            byte p = 0;
            byte d = 0;
            int base = this.toInt(ie.substring(0, 8));
            if(base >= 3000001 && base <= 3017000) {
                p = 5;
                d = 0;
            } else if(base >= 3017001 && base <= 3019022) {
                p = 9;
                d = 1;
            }

            Integer[] numeros = this.split(ie);
            Integer[] calculo = this.multiplicar(numeros, MULTIPLICADOR);
            int soma = p + this.somar(calculo);
            int digito = 11 - this.modulo11(soma);
            if(digito == 10) {
                digito = 0;
            } else if(digito == 11) {
                digito = d;
            }

            valido = numeros[8].intValue() == digito;
        }

        return valido;
    }
}

