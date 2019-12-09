package controlador;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ControladorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ControladorTest
{
    @Before
    public void setUp()
    {
        Controlador.inicializar();
    }

    @Test
    public void testGetJugo(){
        assertNotNull(Controlador.getJuego());
    }
    
    @Test
    public void testValidarYGuardarPalabra(){
        assertFalse(Controlador.validarYGuardarPalabra(null));
        assertFalse(Controlador.validarYGuardarPalabra(""));
        assertTrue(Controlador.validarYGuardarPalabra("Prueba"));
    }
}
