package br.com.jotajr.empresas;


import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by j.freitas.junior on 07/03/2017.
 */
public class ValidaDadosEmpresaTest {

    @Test
    public void isValidCNPJComSimbolos() throws Exception {

        assertEquals(true, ValidaDadosEmpresa.isValidCNPJ("93.590.188/0001-56"));

    }

    @Test
    public void isValidCNPJSemSimbolos() throws Exception {

        assertEquals(true, ValidaDadosEmpresa.isValidCNPJ("93590188000156"));

    }

    @Test
    public void isValidCNPJFalsoComSimbolos() throws Exception {

        assertEquals(false, ValidaDadosEmpresa.isValidCNPJ("93.590.188/0001-59"));

    }

    @Test
    public void isValidCNPJFalsoSemSimbolos() throws Exception {

        assertEquals(false, ValidaDadosEmpresa.isValidCNPJ("93590188000159"));

    }



}