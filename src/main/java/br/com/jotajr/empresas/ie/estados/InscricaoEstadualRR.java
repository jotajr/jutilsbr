package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualRR extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR = new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)};

    public InscricaoEstadualRR() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        if(ie.length() == 9) {
            Integer[] numeros = this.split(ie);
            Integer[] calculo = this.multiplicar(numeros, MULTIPLICADOR);
            int soma = this.somar(calculo);
            int digito = this.modulo9(soma);
            valido = numeros[8].intValue() == digito;
        }

        return valido;
    }
}

