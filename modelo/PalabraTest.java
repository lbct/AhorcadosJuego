package modelo;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PalabraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PalabraTest
{
    /**
     * Default constructor for test class PalabraTest
     */
    public PalabraTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void testLetraCorrecta()
    {
        Palabra p =new Palabra("palabra");
        assertTrue(p.acertarLetra('A'));
    }
    
    @Test
     public void testLetraIncorrecta()
    {
        Palabra p =new Palabra("hola");
        assertFalse(p.acertarLetra('b'));
    }
    
    @Test
    public void numeroFallos()
    {
        Palabra palabra1 = new Palabra("palabra");
        palabra1.acertarLetra('Z');
        assertEquals(1, palabra1.getNumeroDeFallos());
        palabra1.acertarLetra('A');
        assertEquals(1, palabra1.getNumeroDeFallos());
    }
}


