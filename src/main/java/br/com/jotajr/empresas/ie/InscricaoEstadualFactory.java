package br.com.jotajr.empresas.ie;

import br.com.jotajr.empresas.ie.estados.*;
import br.com.jotajr.enums.EstadosEnum;

/**
 * Classe responsável por instanciar classe de inscrição estadual
 * dependendo do estado.
 */
public abstract class InscricaoEstadualFactory
{
    /**
     * Retorna uma instância de validador de Inscrição Estadual
     * @param estado o estado solicitado
     * @return instância de validado para o estado
     */
    public static InscricaoEstadual getInstance(String estado)
    {
        InscricaoEstadual ie = null;

        if (EstadosEnum.ACRE.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualDFAC();
        else if (EstadosEnum.ALAGOAS.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualAL();
        else if (EstadosEnum.AMAPA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualAP();
        else if (EstadosEnum.AMAZONAS.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualAM();
        else if (EstadosEnum.BAHIA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualBA();
        else if (EstadosEnum.CEARA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualPBSECE();
        else if (EstadosEnum.DISTRITOFEDERAL.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualDFAC();
        else if (EstadosEnum.ESPIRITOSANTO.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualES();
        else if (EstadosEnum.GOIAS.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualGO();
        else if (EstadosEnum.MARANHAO.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualMA();
        else if (EstadosEnum.MATOGROSSO.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualMT();
        else if (EstadosEnum.MATOGROSSODOSUL.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualMS();
        else if (EstadosEnum.MINASGERAIS.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualMG();
        else if (EstadosEnum.PARA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualPA();
        else if (EstadosEnum.PARAIBA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualPBSECE();
        else if (EstadosEnum.PARANA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualPR();
        else if (EstadosEnum.PERNAMBUCO.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualPE();
        else if (EstadosEnum.PIAUI.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualPI();
        else if (EstadosEnum.RIODEJANEIRO.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualRJ();
        else if (EstadosEnum.RIOGRANDEDONORTE.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualRN();
        else if (EstadosEnum.RIOGRANDEDOSUL.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualRS();
        else if (EstadosEnum.RONDONIA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualRO();
        else if (EstadosEnum.RORAIMA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualRR();
        else if (EstadosEnum.SANTACATARINA.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualSC();
        else if (EstadosEnum.SAOPAULO.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualSP();
        else if (EstadosEnum.SERGIPE.getSigla().equalsIgnoreCase(estado))
            ie = new InscricaoEstadualPBSECE();
        else if (EstadosEnum.TOCANTINS.getSigla().equalsIgnoreCase(estado)) {
            ie = new InscricaoEstadualTO();
        }

        return ie;
    }
}