package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualMG extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR_1 = new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2)};
    private static final Integer[] MULTIPLICADOR_2 = new Integer[]{Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(11), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualMG() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        if(ie.length() == 13) {
            String ie1 = ie.substring(0, 3) + "0" + ie.substring(3);
            Integer[] numeros1 = this.split(ie1);
            Integer[] calculo1 = this.multiplicar(numeros1, MULTIPLICADOR_1);
            int soma = this.reduzir(calculo1);
            int digito = this.dezena(soma) - soma;
            if(numeros1[12].intValue() == digito) {
                Integer[] numeros2 = this.split(ie);
                Integer[] calculo2 = this.multiplicar(numeros2, MULTIPLICADOR_2);
                soma = this.somar(calculo2);
                digito = 11 - this.modulo11(soma);
                if(digito == 10 || digito == 11) {
                    digito = 0;
                }

                valido = numeros2[12].intValue() == digito;
            }
        }

        return valido;
    }
}

