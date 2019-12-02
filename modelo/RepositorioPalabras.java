package modelo;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RepositorioPalabras
{
    private ArrayList<Palabra> palabras;

    public RepositorioPalabras(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        palabras = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            palabras.add(new Palabra(cadena));
        }
        b.close();
        System.out.println("Se crearon "+palabras.size()+" palabras");
    }

    public Palabra obtenerPalabraAleatoria(){
        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(palabras.size());
        return palabras.get(index);
    }
}
