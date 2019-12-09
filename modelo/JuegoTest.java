package modelo;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class JuegoTest
{
    @Test
    public void AcertarLetraCorrecta()
    {
        Palabra p = new Palabra("hola");
        Juego juego = new Juego(p,5);
        assertTrue(juego.acertarLetra('A'));
    }
    
    @Test
    public void AcertarLetraIncorrecta()
    {
        Palabra p = new Palabra("hola");
        Juego juego = new Juego(p,5);
        assertFalse(juego.acertarLetra('B'));
    }

    @Test
    public void palabraEsIgualALaRegreso()
    {
        modelo.Palabra palabra1 = new modelo.Palabra("palabra");
        modelo.Juego juego1 = new modelo.Juego(palabra1, 5);
        assertEquals(palabra1, juego1.getPalabra());
    }
}


