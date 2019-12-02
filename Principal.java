import vista.MenuPrincipal;
import java.awt.EventQueue;

import controlador.Controlador;

public class Principal
{
    public static void main(String[] args){
        Controlador.inicializar();
        Controlador.abrirMenuPrincipal();
    }
}
