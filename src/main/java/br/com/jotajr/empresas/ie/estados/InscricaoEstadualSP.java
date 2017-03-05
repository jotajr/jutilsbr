package br.com.jotajr.empresas.ie.estados;


import br.com.jotajr.empresas.ie.InscricaoEstadualBase;

public class InscricaoEstadualSP extends InscricaoEstadualBase {
    private static final Integer[] MULTIPLICADOR_1 = new Integer[]{Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10)};
    private static final Integer[] MULTIPLICADOR_2 = new Integer[]{Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2)};

    public InscricaoEstadualSP() {
    }

    public boolean validar(String numero) {
        boolean valido = false;
        String ie = this.limpar(numero, "[^0-9P]");
        if(ie.length() == 12 || ie.length() == 13 && "P".equals(ie.subSequence(0, 1))) {
            Integer[] numeros = this.split(ie);
            Integer[] calculo1;
            int soma;
            int digito;
            if(!"P".equals(ie.subSequence(0, 1))) {
                calculo1 = this.multiplicar(numeros, MULTIPLICADOR_1);
                soma = this.somar(calculo1);
                digito = this.right(this.modulo11(soma));
                if(numeros[8].intValue() == digito) {
                    Integer[] calculo2 = this.multiplicar(numeros, MULTIPLICADOR_2);
                    soma = this.somar(calculo2);
                    digito = this.right(this.modulo11(soma));
                    valido = numeros[11].intValue() == digito;
                }
            } else {
                calculo1 = this.multiplicar(numeros, MULTIPLICADOR_1);
                soma = this.somar(calculo1);
                digito = this.right(this.modulo11(soma));
                valido = numeros[8].intValue() == digito;
            }
        }

        return valido;
    }
}

