package vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;

public abstract class Panel extends JPanel{
    private static final long serialVersionUID = 1L;

    public abstract JButton[] getButtons();
    public abstract void OnClick(ActionEvent event);

    public Panel(){
        super();
        setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
    }
}