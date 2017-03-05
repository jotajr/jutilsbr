
import br.com.jotajr.empresas.ie.InscricaoEstadual;
import br.com.jotajr.empresas.ie.InscricaoEstadualFactory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Test.*;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by j.freitas.junior on 05/03/2017.
 */

public class InscricaoEstadualFactoryTest {

    InscricaoEstadual ie;

    @Before
    public void getInstanciaBefore() {
        ie = InscricaoEstadualFactory.getInstance("RJ");
    }

    @Test
    public void getInstanceTest() throws Exception {
        assertEquals(true, ie.validar("06.495.52-4"));
    }

    @Test
    public void testaSemSimbolos() {
        assertEquals(true, ie.validar("06495524"));
    }

    @Test
    public void testaIEInvalida() {
        assertEquals(false, ie.validar("8984932234982394"));
    }

    @Test
    public void testaInstanciaNula() {
        assertNotNull(ie);
    }

}