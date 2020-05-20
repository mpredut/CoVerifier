package easyic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
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
    
    private boolean state;

    public MyComponent() {
    	BorderLayout lay = new BorderLayout();
    	setLayout(lay);
    	//GroupLayout gl_panel_4 = new GroupLayout(panel_4); button.setBounds(40, 4, 50, 100);

        button = new JButton("  CONFIG");
        button.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	               JOptionPane.showMessageDialog(button, ": Ouch!");
	         }
	     });       

        //checkBox = new JCheckBox("A");
        label1 = new JLabel(" LABEL ");
        this.add(label1, BorderLayout.CENTER);
        this.add(button, BorderLayout.LINE_END);
        //this.add(checkBox);
        

        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(button, "APASAT " + label1.getText());
            }
        });
    }

    /////
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

