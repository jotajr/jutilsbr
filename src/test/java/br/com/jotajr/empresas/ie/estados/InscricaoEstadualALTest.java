package br.com.jotajr.empresas.ie.estados;

import br.com.jotajr.empresas.ie.InscricaoEstadual;
import br.com.jotajr.empresas.ie.InscricaoEstadualFactory;
import br.com.jotajr.enums.EstadosEnum;
import org.junit.Assert;
import org.junit.Test;

public class InscricaoEstadualALTest {

    @Test
    public void validar() {

        InscricaoEstadual inscricaoEstadual = InscricaoEstadualFactory.getInstance(EstadosEnum.ALAGOAS.getSigla());

        Assert.assertTrue(inscricaoEstadual.validar("240000048"));

    }
}