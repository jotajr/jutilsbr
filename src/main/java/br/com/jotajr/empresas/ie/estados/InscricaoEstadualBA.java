package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualBA extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR_8_1 = new Integer[]{Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};
    private static final Integer[] MULTIPLICADOR_8_2 = new Integer[]{Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3)};
    private static final Integer[] MULTIPLICADOR_9_1 = new Integer[]{Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};
    private static final Integer[] MULTIPLICADOR_9_2 = new Integer[]{Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3)};

    public InscricaoEstadualBA() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9]");
        int inicial;
        Integer[] numeros;
        Integer[] calculo1;
        int soma;
        int digito;
        Integer[] calculo2;
        if(ie.length() == 8) {
            inicial = this.toInt(ie.substring(0, 1));
            if(this.in(inicial, new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(8)})) {
                numeros = this.split(ie);
                calculo1 = this.multiplicar(numeros, MULTIPLICADOR_8_1);
                soma = this.somar(calculo1);
                digito = 10 - this.modulo10(soma);
                if(digito == 10) {
                    digito = 0;
                }

                if(numeros[7].intValue() == digito) {
                    calculo2 = this.multiplicar(numeros, MULTIPLICADOR_8_2);
                    soma = this.somar(calculo2) + 2 * digito;
                    digito = 10 - this.modulo10(soma);
                    if(digito == 10) {
                        digito = 0;
                    }

                    valido = numeros[6].intValue() == digito;
                }
            } else if(this.in(inicial, new Integer[]{Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(9)})) {
                numeros = this.split(ie);
                calculo1 = this.multiplicar(numeros, MULTIPLICADOR_8_1);
                soma = this.somar(calculo1);
                digito = 11 - this.modulo11(soma);
                if(digito == 10 || digito == 11) {
                    digito = 0;
                }

                if(numeros[7].intValue() == digito) {
                    calculo2 = this.multiplicar(numeros, MULTIPLICADOR_8_2);
                    soma = this.somar(calculo2) + 2 * digito;
                    digito = 11 - this.modulo11(soma);
                    if(digito == 10 || digito == 11) {
                        digito = 0;
                    }

                    valido = numeros[6].intValue() == digito;
                }
            }
        } else if(ie.length() == 9) {
            inicial = this.toInt(ie.substring(0, 1));
            if(this.in(inicial, new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(8)})) {
                numeros = this.split(ie);
                calculo1 = this.multiplicar(numeros, MULTIPLICADOR_9_1);
                soma = this.somar(calculo1);
                digito = 10 - this.modulo10(soma);
                if(digito == 10) {
                    digito = 0;
                }

                if(numeros[8].intValue() == digito) {
                    calculo2 = this.multiplicar(numeros, MULTIPLICADOR_9_2);
                    soma = this.somar(calculo2) + 2 * digito;
                    digito = 10 - this.modulo10(soma);
                    if(digito == 10) {
                        digito = 0;
                    }

                    valido = numeros[7].intValue() == digito;
                }
            } else if(this.in(inicial, new Integer[]{Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(9)})) {
                numeros = this.split(ie);
                calculo1 = this.multiplicar(numeros, MULTIPLICADOR_9_1);
                soma = this.somar(calculo1);
                digito = 11 - this.modulo11(soma);
                if(digito == 10 || digito == 11) {
                    digito = 0;
                }

                if(numeros[8].intValue() == digito) {
                    calculo2 = this.multiplicar(numeros, MULTIPLICADOR_9_2);
                    soma = this.somar(calculo2) + 2 * digito;
                    digito = 11 - this.modulo11(soma);
                    if(digito == 10 || digito == 11) {
                        digito = 0;
                    }

                    valido = numeros[7].intValue() == digito;
                }
            }
        }

        return valido;
    }
}