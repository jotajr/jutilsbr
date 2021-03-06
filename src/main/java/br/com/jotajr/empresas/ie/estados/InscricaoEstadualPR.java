package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualPR extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR_1 = new Integer[]{Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};
    private static final Integer[] MULTIPLICADOR_2 = new Integer[]{Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualPR() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        if(ie.length() == 10) {
            Integer[] numeros = this.split(ie);
            Integer[] calculo1 = this.multiplicar(numeros, MULTIPLICADOR_1);
            int soma = this.somar(calculo1);
            int digito = 11 - this.modulo11(soma);
            if(digito == 10 || digito == 11) {
                digito = 0;
            }

            if(numeros[8].intValue() == digito) {
                Integer[] calculo2 = this.multiplicar(numeros, MULTIPLICADOR_2);
                soma = this.somar(calculo2);
                digito = 11 - this.modulo11(soma);
                if(digito == 10 || digito == 11) {
                    digito = 0;
                }

                valido = numeros[9].intValue() == digito;
            }
        }

        return valido;
    }
}

