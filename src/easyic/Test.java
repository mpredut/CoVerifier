package easyic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Paint;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.border.MatteBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.text.html.ImageView;
import javax.swing.text.Element;
import javax.swing.JInternalFrame;

public class Test {

	private JFrame frmEasyicCoverified;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	
	Color easyicOrange = new Color(228, 131, 18);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frmEasyicCoverified.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		
		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(easyicOrange));
		uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.WHITE));
		JFrame.setDefaultLookAndFeelDecorated(true);
		initialize(easyicOrange);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Color ORANGE) {
		frmEasyicCoverified = new JFrame();
		frmEasyicCoverified.getContentPane().setForeground(ORANGE);
		frmEasyicCoverified.setForeground(ORANGE);
		frmEasyicCoverified.setBackground(ORANGE);
		frmEasyicCoverified.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmEasyicCoverified.setTitle("EasyIC CoVerifier");
		frmEasyicCoverified.setBounds(100, 100, 998, 819);
		frmEasyicCoverified.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEasyicCoverified.getContentPane().setLayout(null);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("");
		lblNewJgoodiesTitle_1.setBounds(924, 208, 61, 120);
		frmEasyicCoverified.getContentPane().add(lblNewJgoodiesTitle_1);
		lblNewJgoodiesTitle_1.setIcon(new ImageIcon("D:\\easiyc\\lvm3.gif"));
		
		JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
		lblNewJgoodiesTitle_3.setIcon(new ImageIcon("D:\\easiyc\\lvm1.gif"));
		lblNewJgoodiesTitle_3.setBounds(24, 74, 29, 70);
		frmEasyicCoverified.getContentPane().add(lblNewJgoodiesTitle_3);
		
		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
		lblNewJgoodiesTitle_2.setIcon(new ImageIcon("D:\\easiyc\\lvl2.gif"));
		lblNewJgoodiesTitle_2.setBounds(24, 220, 38, 97);
		frmEasyicCoverified.getContentPane().add(lblNewJgoodiesTitle_2);
		
		JPanel panel = new JPanel();
		
		/*** aici creez un bordar dash */
		Paint pnt = new GradientPaint(0, 0, Color.red, 100, 100, Color.pink, true); 
		float thickness = 2; float  length = 5; float  spacing= 5; boolean rounded = true;
		Border borderdash = BorderFactory.createDashedBorder(pnt, thickness, length, spacing, rounded);
		/*end border*/
		
		panel.setBorder(borderdash);
		//panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(48, 29, 886, 156);
		frmEasyicCoverified.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), null));
		panel_3.setBounds(12, 13, 260, 130);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox chckbxFvControl = new JCheckBox("FW   Control");
		chckbxFvControl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		chckbxFvControl.setBackground(new Color(242, 246, 223));
		chckbxFvControl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxFvControl.setBounds(38, 51, 150, 25);
		panel_3.add(chckbxFvControl);
		
		JCheckBox chckbxUvmControl = new JCheckBox("UVM Control");
		chckbxUvmControl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		chckbxUvmControl.setBackground(new Color(242, 246, 223));
		chckbxUvmControl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxUvmControl.setBounds(38, 21, 150, 25);
		panel_3.add(chckbxUvmControl);
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("Not used  if Emulated CPU & DPI selected");
		panel_4.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), null));
		panel_4.setBounds(307, 13, 286, 130);
		panel.add(panel_4);
		
		JLabel lblMemStart = new JLabel("MEM START");
		lblMemStart.setForeground(Color.WHITE);
		lblMemStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMemStart.setBackground(ORANGE);
		lblMemStart.setOpaque(true);
		lblMemStart.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JLabel lblMemSize = new JLabel("MEM SIZE");
		lblMemSize.setForeground(Color.WHITE);
		lblMemSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMemSize.setBackground(ORANGE);
		lblMemSize.setOpaque(true);
		lblMemSize.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setForeground(Color.WHITE);
		textField.setBackground(ORANGE);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(ORANGE);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("MEMORY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMemStart, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addComponent(lblMemSize, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(92))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMemStart, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMemSize, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("");
		lblNewJgoodiesTitle.setBounds(605, 13, 223, 130);
		panel.add(lblNewJgoodiesTitle);
		lblNewJgoodiesTitle.setIcon(new ImageIcon("D:\\easiyc\\not_used.gif"));
		lblNewJgoodiesTitle.setBackground(ORANGE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(48, 370, 886, 430);
		frmEasyicCoverified.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setForeground(Color.BLACK);
		table.setBackground(ORANGE);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"UART", null, null, null, null, null},
				{"SPI", null, null, null, null, null},
				{"HDMI", null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"EXT_PORT", "CONFIG1", "CONFIG1", "CONFIG1", "CONFIG1", "CONFIG1"
			}
		));
		table.setRowHeight(32);
		table.setRowMargin(5);
		table.getColumnModel().setColumnMargin(5);
		table.getColumnModel().getColumn(0).setPreferredWidth(152);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(152);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(152);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(152);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(152);
		table.getColumnModel().getColumn(4).setMinWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(152);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.setBounds(47, 129, 774, 288);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setVisible(true);
		panel_2.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(833, 85, 21, 319);
		panel_2.add(scrollBar);
		
		JLabel lblNewLabel_2 = new JLabel("     GENERATE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(47, 24, 231, 38);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel_2.add(lblNewLabel_2);
		
		table_1 = new JTable();
		table_1.setBackground(Color.BLACK);
		table_1.setForeground(Color.WHITE);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"EXT. PORT", "CONFIG1", "CONFIG2", "CONFIG3", "CONFIG4", "CONFIG5"},
			},
			new String[] {
				"New column", "test", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setRowHeight(52);		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(152);
		table_1.getColumnModel().getColumn(0).setMinWidth(50);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(152);
		table_1.getColumnModel().getColumn(1).setMinWidth(50);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(152);
		table_1.getColumnModel().getColumn(2).setMinWidth(50);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(152);
		table_1.getColumnModel().getColumn(3).setMinWidth(50);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(152);
		table_1.getColumnModel().getColumn(4).setMinWidth(50);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(152);
		table_1.getColumnModel().getColumn(5).setMinWidth(50);
		table_1.setBounds(47, 81, 774, 48);
		panel_2.add(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(borderdash);
		//panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(48, 198, 443, 156);
		frmEasyicCoverified.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(12, 13, 417, 130);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		panel_8.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), null));
		
		JCheckBox checkBox = new JCheckBox("USE MAILBOX DPI Emulation");
		checkBox.setBackground(new Color(242, 246, 223));
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkBox.setBounds(34, 82, 291, 25);
		panel_8.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("EMULATE CPU");
		checkBox_1.setBackground(new Color(242, 246, 223));
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkBox_1.setBounds(34, 52, 153, 25);
		panel_8.add(checkBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("EMU");
		lblNewLabel_1.setBounds(95, 13, 66, 25);
		panel_8.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
		lblNewJgoodiesTitle_4.setIcon(new ImageIcon("D:\\easiyc\\axi.gif"));
		lblNewJgoodiesTitle_4.setBounds(317, 10, 51, 38);
		panel_8.add(lblNewJgoodiesTitle_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(borderdash);
		panel_5.setBounds(602, 198, 332, 156);
		frmEasyicCoverified.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 13, 314, 130);
		panel_5.add(panel_6);
		panel_6.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), null));
		panel_6.setLayout(null);
		
		JCheckBox chckbxTodo = new JCheckBox("TODO");
		chckbxTodo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxTodo.setBounds(34, 82, 153, 25);
		panel_6.add(chckbxTodo);
		
		JCheckBox chckbxBfm = new JCheckBox("BFM ENV");
		chckbxBfm.setBackground(new Color(242, 246, 223));
		chckbxBfm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxBfm.setBounds(34, 52, 153, 25);
		panel_6.add(chckbxBfm);
		
		JLabel lblBfm = new JLabel("BFM");
		lblBfm.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBfm.setBounds(72, 13, 71, 30);
		panel_6.add(lblBfm);
		
		JLabel lblNewJgoodiesTitle_5 = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
		lblNewJgoodiesTitle_5.setIcon(new ImageIcon("D:\\easiyc\\uart.gif"));
		lblNewJgoodiesTitle_5.setBounds(177, 8, 59, 35);
		panel_6.add(lblNewJgoodiesTitle_5);
	}
}
