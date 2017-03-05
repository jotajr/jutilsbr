package br.com.jotajr.empresas.ie;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class InscricaoEstadualBase
        implements InscricaoEstadual
{
    private final Pattern patternNumber = Pattern.compile("[0-9]");

    protected boolean isNumero(String numero) {
        return this.patternNumber.matcher(numero).matches();
    }

    protected String limpar(String numero, String regEx) {
        return numero.toUpperCase().replaceAll(regEx, "");
    }

    protected int toInt(String num) {
        return Integer.parseInt(num);
    }

    protected String toStr(int num) {
        return Integer.toString(num);
    }

    protected Integer[] split(String numero) {
        List itens = new ArrayList();
        for (int i = 0; i < numero.length(); i++) {
            String digito = numero.substring(i, i + 1);
            if (isNumero(digito)) {
                itens.add(Integer.valueOf(toInt(digito)));
            }
        }
        return (Integer[])itens.toArray(new Integer[0]);
    }

    protected Integer[] multiplicar(Integer[] numeros, Integer[] multiplicadores) {
        Integer[] resultado = new Integer[multiplicadores.length];
        for (int i = 0; i < multiplicadores.length; i++) {
            int multiplicador = multiplicadores[i].intValue();
            int numero = numeros.length > i ? numeros[i].intValue() : 0;
            resultado[i] = Integer.valueOf(numero * multiplicador);
        }
        return resultado;
    }

    protected int somar(Integer[] numeros) {
        int resultdado = 0;
        Integer[] arr$ = numeros; int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int num = arr$[i$].intValue();
            resultdado += num;
        }
        return resultdado;
    }

    protected int reduzir(Integer[] numeros) {
        int resultdado = 0;
        Integer[] arr$ = numeros; int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int num = arr$[i$].intValue();
            if (num < 10)
                resultdado += num;
            else {
                resultdado += reduzir(split(toStr(num)));
            }
        }
        return resultdado;
    }

    protected int right(int numero) {
        String num = toStr(numero);
        if (num.length() == 1) return numero;
        return toInt(num.substring(num.length() - 1, num.length()));
    }

    protected int round(double num) {
        return (int)num;
    }

    protected int dezena(int num) {
        if (num % 10.0D == 0.0D) return num;
        int digito = round(num / 10.0D);
        return (digito + 1) * 10;
    }

    protected int modulo11(int numero) {
        return numero % 11;
    }

    protected int modulo10(int numero) {
        return numero % 10;
    }

    protected int modulo9(int numero) {
        return numero % 9;
    }

    protected boolean in(int num, Integer[] lista) {
        Integer[] arr$ = lista; int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int i = arr$[i$].intValue();
            if (num == i) return true;
        }
        return false;
    }
}
