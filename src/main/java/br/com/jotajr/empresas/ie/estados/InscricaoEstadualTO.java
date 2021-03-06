package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualTO extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR = new Integer[]{Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualTO() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        if(ie.length() == 11) {
            int num = this.toInt(ie.substring(2, 4));
            if(this.in(num, new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(99)})) {
                String ie2 = ie.substring(0, 2) + ie.substring(4);
                Integer[] numeros = this.split(ie2);
                Integer[] calculo = this.multiplicar(numeros, MULTIPLICADOR);
                int soma = this.somar(calculo);
                int digito = 11 - this.modulo11(soma);
                if(digito == 10 || digito == 11) {
                    digito = 0;
                }

                valido = numeros[8].intValue() == digito;
            }
        }

        return valido;
    }
}

