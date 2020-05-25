package easyic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import java.awt.Color;

public class ConfigPrj extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ConfigPrj frame = new ConfigPrj();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfigPrj(JFrame mainFrame) {
		
		Color checkBoxColor = new Color(242, 246, 223);
		getContentPane().setBackground(checkBoxColor);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 484, 430);
		centreWindow(this);
		setLocationRelativeTo(mainFrame);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SRC DIR");
		lblNewLabel.setBounds(25, 68, 133, 46);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIn = new JLabel("INCLUDE DIR");
		lblIn.setBounds(25, 111, 133, 46);
		getContentPane().add(lblIn);
		
		JLabel lblSrcDir = new JLabel("UVM SEQ DIR");
		lblSrcDir.setBounds(36, 267, 133, 46);
		getContentPane().add(lblSrcDir);
		
		JLabel lblUvmSeqDir = new JLabel("UVM TEST DIR");
		lblUvmSeqDir.setBounds(36, 311, 133, 46);
		getContentPane().add(lblUvmSeqDir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 191, 425, 18);
		getContentPane().add(separator);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("FW Area");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesTitle.setBounds(185, 26, 126, 25);
		getContentPane().add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("UVM Area");
		lblNewJgoodiesTitle_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesTitle_1.setBounds(185, 223, 126, 25);
		getContentPane().add(lblNewJgoodiesTitle_1);
		
		textField = new JTextField();
		textField.setBounds(185, 80, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 124, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 279, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(185, 323, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
	}
	
	public void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);	    
	}
}
