package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import controlador.Controlador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;


public class MenuPrincipal extends Panel
{
    private JButton botonIntroducirPalabra;
    private JButton botonAleatorio;
    
    public MenuPrincipal(){
        super();
        
        JLabel titulo = new JLabel("Ahorcados");
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 50));
        titulo.setBounds(275, 160, 250, 80);
        
        super.add(titulo);

        botonIntroducirPalabra = new JButton("Introducir Palabra");
        botonIntroducirPalabra.setBackground(Color.WHITE);
		botonIntroducirPalabra.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botonIntroducirPalabra.setBounds(250, 260, 300, 42);
        super.add(botonIntroducirPalabra);
        
        botonAleatorio = new JButton("Juego aleatorio");
        botonAleatorio.setBackground(Color.WHITE);
		botonAleatorio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonAleatorio.setBounds(250, 312, 300, 42);
        super.add(botonAleatorio);
    }

    @Override
    public void OnClick(ActionEvent event) {
        JButton boton = (JButton)event.getSource();
        if(boton == botonAleatorio){
            Controlador.nuevoJuegoAleatorio();
        }
        if(boton == botonIntroducirPalabra){
            Controlador.abrirIntroducirNuevaPalabra();
        }
    }

    @Override
    public JButton[] getButtons(){
        return new JButton[] { botonAleatorio, botonIntroducirPalabra };
    }
}
