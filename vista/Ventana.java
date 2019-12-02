package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    
    public void setPanel(Panel panel){
        Panel oldPanel = getPanelActual();
        if(oldPanel != null)
        {
            JButton[] old_buttons = oldPanel.getButtons();
            for(JButton oldButton : old_buttons)
                oldButton.removeActionListener(this);
        }
        
        getContentPane().removeAll();
        getContentPane().add((JPanel)panel);
        getContentPane().revalidate(); 
        getContentPane().repaint();

        for(JButton button : panel.getButtons())
            button.addActionListener(this);
    }

    private Panel getPanelActual(){
        if(getContentPane().getComponentCount() > 0){
            return (Panel)getContentPane().getComponent(0);
        }
        return null;
    }

    public Ventana(){
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        Panel panel = getPanelActual();
        if(panel != null)
            panel.OnClick(e);
    }
}
