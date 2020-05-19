package easyic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyComponent extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button;
    private JCheckBox checkBox;
    private JLabel label1;
    private JLabel label2;

    private boolean state;

    public MyComponent() {

        button = new JButton("....");
        button.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	               JOptionPane.showMessageDialog(button, ": Ouch!");
	         }
	     });

        checkBox = new JCheckBox("A");
        label1 = new JLabel("B");
        label2 = new JLabel("C");

        this.add(label1);
        //this.add(label2);
        this.add(button);
        //this.add(checkBox);
        

        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(button,button.hashCode());
            }
        });
    }

    public JCheckBox getCheckBox()
    {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox)
    {
        this.checkBox = checkBox;
    }
    
    public void setLable(String text)
    {
        this.label1.setText(text);
    }

    public void setState(boolean state)
    {
        this.state = state;
        checkBox.setSelected(state);
    }

}

