package controlador;

import java.awt.EventQueue;
import java.io.File;
import javax.swing.JOptionPane;

import vista.*;
import modelo.*;

public class Controlador
{
    private static Ventana ventana;
    private static MenuPrincipal menu;
    private static PanelNuevaPalabra panelNuevaPalabra;
    private static Juego juego;
    private static RepositorioPalabras repo;
    private static PanelJuego panelJuego;

    public static void inicializar(){
        menu = new MenuPrincipal();
        ventana = new Ventana();
        panelNuevaPalabra = new PanelNuevaPalabra();
        File file = new File("repo.txt");
        
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            repo = new RepositorioPalabras(file.getAbsolutePath());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al crear el repositorio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Juego getJuego(){
        return juego;
    }

    public static void abrirIntroducirNuevaPalabra(){
        abrirPanel(panelNuevaPalabra);
    }

    public static void abrirMenuPrincipal(){
        abrirPanel(menu);
    }

    public static boolean validarYGuardarPalabra(String palabra){
        boolean valid = false;
        if(palabra != null && palabra.length() > 0 && palabra.trim().length() > 0){
            //Controlador.palabra = palabra;
            Palabra palabraObj = new Palabra(palabra);
            comenzarJuego(palabraObj);
            valid = true;
        }
        return valid;
    }

    public static void nuevoJuegoAleatorio(){
        Palabra palabra = repo.obtenerPalabraAleatoria();
        comenzarJuego(palabra);
    }
    
    public static void comenzarJuego(Palabra palabra){
        if(juego == null){
            juego = new Juego(palabra, 8);
        }
        else
            juego.volverAJugar(palabra);
        panelJuego = new PanelJuego();
        abrirPanel(panelJuego);
    }

    private static void abrirPanel(Panel panel){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ventana.setPanel(panel);
                    ventana.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
