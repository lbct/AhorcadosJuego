package vista;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
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
import javax.swing.JOptionPane;

public class PanelNuevaPalabra extends Panel
{
    private JButton botonAceptar;
    private JPasswordField pass;

    public PanelNuevaPalabra(){
        super();
        JLabel titulo = new JLabel("Introduce la palabra");
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 50));
        titulo.setBounds(175, 160, 450, 80);

        pass = new JPasswordField();
        pass.setBackground(Color.WHITE);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pass.setBounds(250, 260, 300, 42);
        pass.setHorizontalAlignment(JTextField.CENTER);
        super.add(pass);

        botonAceptar = new JButton("Empezar");
        botonAceptar.setBackground(Color.WHITE);
		botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonAceptar.setBounds(250, 312, 300, 42);
        super.add(botonAceptar);
        super.add(titulo);
    }

    @Override
    public void OnClick(ActionEvent event) {
        if(event.getSource() == botonAceptar){
            char[] passChars = pass.getPassword();
            pass.setText("");
            String palabra = "";
            for(char p : passChars)
                palabra += p;
            if(!Controlador.validarYGuardarPalabra(palabra))
                JOptionPane.showMessageDialog(null, "Debe introducir una palabra válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public JButton[] getButtons() {
        return new JButton[] { botonAceptar };
    }
}
