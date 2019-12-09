package modelo;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
/**
 * The test class RepositorioPalabrasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RepositorioPalabrasTest
{
    private RepositorioPalabras repo;
    
    
    public RepositorioPalabrasTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        try{
            repo = new RepositorioPalabras("repo.txt");
        }
        catch(IOException ex){
        
        }
    }

    @Test
    public void testObtenerPalabraAleatoria(){
        Palabra palabra = repo.obtenerPalabraAleatoria();
        assertNotNull(palabra);
    }
}
