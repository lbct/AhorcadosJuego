package vista;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import controlador.Controlador;
import modelo.EstadoJuego;
import modelo.Palabra;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PanelJuego extends Panel
{
    private JButton botonSalir;
    private JLabel[] labels;
    private JTextField texto;
    private JLabel imagen;
    private JButton botonEnviar;

    public PanelJuego(){
        super();
        int x = 0;
        Palabra palabra = Controlador.getJuego().getPalabra();
        JLabel label = new JLabel("Palabra:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label.setBounds(100, 400, 200, 50);
        super.add(label);

        imagen = new JLabel("");
        imagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        imagen.setBounds(200, 10, 288, 349);
        imagen.setBackground(Color.BLACK);
        //addIconToLabel(imagen);
        super.add(imagen);

        labels = new JLabel[palabra.getLongitudPalabra()];
        for(int i=0;i<palabra.getLongitudPalabra();i++){
            labels[i] = new JLabel("-");
            label = labels[i];
            label.setFont(new Font("Tahoma", Font.PLAIN, 30));
            label.setBounds(300 + x, 400, 50, 50);
            x+=30;
            super.add(label);
        }

        botonSalir = new JButton("Salir");
        botonSalir.setBackground(Color.WHITE);
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botonSalir.setBounds(10, 498, 150, 42);
        super.add(botonSalir);

        label = new JLabel("Escriba aquí:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label.setBounds(170, 498, 200, 42);
        super.add(label);

        texto = new JTextField("");
        texto.setBackground(Color.WHITE);
		texto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        texto.setBounds(380, 498, 50, 42);
        super.add(texto);

        botonEnviar = new JButton("Intentar");
        botonEnviar.setBackground(Color.WHITE);
		botonEnviar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botonEnviar.setBounds(440, 498, 150, 42);
        super.add(botonEnviar);
    }

    private void actualizarLabels(){
        char[] valores = Controlador.getJuego().getPalabra().getValoresOcultos();
        for(int i = 0; i< labels.length;i++){
            labels[i].setText(valores[i]+"");
        }
    }

    private void actualizarImagen(){
        int valor = Controlador.getJuego().getPalabra().getNumeroDeFallos();
        ImageIcon icon = new ImageIcon("img/"+valor+".png");
        imagen.setIcon(icon);
    }

    @Override
    public void OnClick(ActionEvent event) {
        if(event.getSource() == botonSalir)
            Controlador.abrirMenuPrincipal();
        if(event.getSource() == botonEnviar)
        {
            String txt = texto.getText().trim();
            if(txt.length() > 1 || txt.length() <= 0){
                JOptionPane.showMessageDialog(null, "Debe introducir una letra válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                char letra =  txt.toUpperCase().charAt(0);
                Controlador.getJuego().acertarLetra(letra);
                EstadoJuego estado = Controlador.getJuego().getEstadoJuego();
                actualizarImagen();
                if(estado != EstadoJuego.CONTINUA){
                    botonEnviar.setEnabled(false);
                    if(estado == EstadoJuego.PERDIDO){
                        JOptionPane.showMessageDialog(null, "PERDIO, la palabra era: "
                        +Controlador.getJuego().getPalabra().getPalabra(), "Perdió", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "GANO!!, la palabra era: "
                        +Controlador.getJuego().getPalabra().getPalabra(), "Ganó", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                actualizarLabels();
            }
            texto.setText("");
        }
    }

    @Override
    public JButton[] getButtons() {
        return new JButton[] { botonSalir, botonEnviar };
    }
}
