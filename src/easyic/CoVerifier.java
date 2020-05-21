package easyic;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.border.MatteBorder;

import com.jgoodies.common.base.Strings;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.swing.text.html.ImageView;
import javax.swing.text.Element;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.util.List;
import java.util.Properties;
import java.util.prefs.Preferences;
import java.util.ArrayList;
//import java.awt.List;



public class CoVerifier {

	private Properties configProps;
	
	private JFrame frmEasyicCoverified;
	private ConfigPrj frmConfigPrj;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	

	
	private Color easyicOrange = new Color(228, 131, 18);
	private Color checkBoxColor = new Color(242, 246, 223);
	
	public static List<Component> getAllComponents(final Container c) {
	    Component[] comps = c.getComponents();
	    List<Component> compList = new ArrayList<Component>();
	    for (Component comp : comps) {
	        compList.add(comp);
	        if (comp instanceof Container)
	            compList.addAll(getAllComponents((Container) comp));
	    }
	    return compList;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoVerifier window = new CoVerifier();
					window.frmEasyicCoverified.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void TableAddNewRow() {
		DefaultTableModel  model = (DefaultTableModel)table_2.getModel();
		Object[] arrObj = new Object [model.getColumnCount()];
		arrObj[0] = "NEW ROW";
		arrObj[1] = true;
		for(int i = 2; i < model.getColumnCount(); i++) {
			arrObj[i] = false;
		}
		model.insertRow(model.getRowCount(), arrObj);
	}
	
	private void TableAddNewColumn() {
		DefaultTableModel  model = (DefaultTableModel)table_2.getModel();
		//TableColumn c = new TableColumn(i);
        //c.setHeaderValue(getColNam(i))
		model.addColumn("Config " + (model.getColumnCount() - 1));
		//TODO: repeat that!
	    table_2.getColumn("EXTERNAL PORT").setCellRenderer(new MyCellComponentRenderer());
	    table_2.getColumn("EXTERNAL PORT").setCellEditor(new MyCellComponentEditor(new JCheckBox()));
	}

	/**
	 * Create the application.
	 */
	public CoVerifier() {
		
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
		frmEasyicCoverified.setResizable(false);
		frmEasyicCoverified.getContentPane().setForeground(ORANGE);
		frmEasyicCoverified.setForeground(ORANGE);
		frmEasyicCoverified.setBackground(ORANGE);
		frmEasyicCoverified.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmEasyicCoverified.setTitle("EasyIC CoVerifier");
		frmEasyicCoverified.setBounds(100, 100, 966, 851);
		frmEasyicCoverified.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEasyicCoverified.getContentPane().setLayout(null);
		
		/*** aici configurez bordere unul normal si un border dash ***/
		LineBorder border = new LineBorder(new Color(0, 0, 0), 3, true);		
		Paint pnt = new GradientPaint(0, 0, Color.red, 100, 100, Color.pink, true);
		//Color easyicOrange = new Color(228, 131, 18);
		float thickness = 2; float  length = 50; float  spacing = 23; boolean rounded = true;
		Border borderdash = BorderFactory.createDashedBorder(easyicOrange, thickness, length, spacing, rounded);
		/*end border dash*/
				
		JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
		lblNewJgoodiesTitle_3.setVisible(false);
		lblNewJgoodiesTitle_3.setIcon(new ImageIcon("res\\lvm1.gif"));
		lblNewJgoodiesTitle_3.setBounds(24, 74, 29, 70);
		frmEasyicCoverified.getContentPane().add(lblNewJgoodiesTitle_3);
		
		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
		lblNewJgoodiesTitle_2.setVisible(false);
		lblNewJgoodiesTitle_2.setIcon(new ImageIcon("res\\lvl2.gif"));
		lblNewJgoodiesTitle_2.setBounds(24, 220, 38, 97);
		frmEasyicCoverified.getContentPane().add(lblNewJgoodiesTitle_2);
		
		JPanel panel = new JPanel();
				
		panel.setBorder(borderdash);
		//panel.setBorder(border);
		panel.setBounds(48, 29, 886, 156);
		frmEasyicCoverified.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(border);
		panel_3.setBounds(12, 13, 424, 130);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox chckbxFvControl = new JCheckBox("FW   Control");
		chckbxFvControl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		chckbxFvControl.setBackground(checkBoxColor);
		chckbxFvControl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxFvControl.setBounds(37, 78, 150, 25);
		panel_3.add(chckbxFvControl);
		
		JCheckBox chckbxUvmControl = new JCheckBox("UVM Control");
		chckbxUvmControl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		chckbxUvmControl.setBackground(checkBoxColor);
		chckbxUvmControl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxUvmControl.setBounds(37, 51, 150, 25);
		panel_3.add(chckbxUvmControl);
		
		JLabel lblNewLabel_2 = new JLabel("MAIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(163, 22, 56, 16);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("Not used  if Emulated CPU & DPI selected");
		panel_4.setBorder(border);
		panel_4.setBounds(484, 13, 390, 130);
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
		textField.setName("textField");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(ORANGE);
		textField_1.setColumns(10);
		textField_1.setName("textField_1");
		
		/*aici am un layout mai tampit - poate ar tb schimbat cu unul obijnuit*/
		JLabel lblNewLabel = new JLabel("MEMORY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMemStart, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addComponent(lblMemSize, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(145))))
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
		lblNewJgoodiesTitle.setVisible(false);
		lblNewJgoodiesTitle.setBounds(605, 13, 269, 130);
		panel.add(lblNewJgoodiesTitle);
		lblNewJgoodiesTitle.setIcon(new ImageIcon("res\\not_used.gif"));
		lblNewJgoodiesTitle.setBackground(ORANGE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(border);
		panel_2.setBounds(48, 370, 886, 391);
		frmEasyicCoverified.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(1022, 125, 194, 52);
		//frmEasyicCoverified.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(12, 17, 56, 16);
		panel_7.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("......");
		btnNewButton_2.setBounds(80, 13, 97, 25);
		panel_7.add(btnNewButton_2);
		
		table_2 = new JTable();
		table_2.setFillsViewportHeight(true);
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table_2.setForeground(Color.BLACK);
		table_2.setBackground(ORANGE);
		table_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		
		  
		Object[][] rows = {
				{("UART"), (true), (false)},
				{("  SPI  "), (true), (true)},
				{("HDMI"), (true), (true)}
				};
		 String[] columnNames = {"EXTERNAL PORT", "Config ALL", "Config 1"};
		 DefaultTableModel model = new DefaultTableModel(rows, columnNames);
		 
		 table_2 = new JTable(model) {

	            private static final long serialVersionUID = 1L;

	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
	            @Override
	            public Class getColumnClass(int column) {
	                switch (column) {
	                    case 0:
	                        return MyComponent.class;
	                    case 1:
	                        return Boolean.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	            public boolean isCellEditable(int row, int column) {
	            	//if(column != 0)
	                return true;
	            	//return false;
	          	}
	        };
	        
	    table_2.getColumn("EXTERNAL PORT").setCellRenderer(new MyCellComponentRenderer());
	    table_2.getColumn("EXTERNAL PORT").setCellEditor(new MyCellComponentEditor(new JCheckBox()));
	    
	    /* header table settings*/
	    
        JTableHeader header = table_2.getTableHeader();
	    header.setBackground(Color.black);
	    header.setForeground(Color.white);
	    header.setPreferredSize(new Dimension(152, 50));
	    /*
	    header.getColumnModel().getColumn(0).setPreferredWidth(152);
	    header.getColumnModel().getColumn(0).setMinWidth(50);
	    header.getColumnModel().getColumn(1).setPreferredWidth(152);
	    header.getColumnModel().getColumn(1).setMinWidth(50);
	    */
	    
	    header.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    ///
        
        table_2.getColumnModel().getColumn(0).setPreferredWidth(152);
        table_2.getColumnModel().getColumn(0).setMinWidth(50);
        table_2.getColumnModel().getColumn(1).setPreferredWidth(152);
        table_2.getColumnModel().getColumn(1).setMinWidth(50);
        table_2.setRowHeight(32);
        table_2.setRowMargin(5);
        table_2.setBounds(47, 129, 293, 66);
        table_2.setShowGrid(true);
        table_2.setShowVerticalLines(true);
        table_2.setShowHorizontalLines(true);
        table_2.setVisible(true);
		
		JButton btnNewButton = new JButton("  GENERATE");
		
	     btnNewButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	             for (int i = 0; i < model.getRowCount(); i++) {
	                 Boolean value = (Boolean) model.getValueAt(i, 2);// check state
	                 if (value) {
	                     System.out.println(model.getValueAt(i, 1));// second column value
	                 }
	             }
				    JOptionPane.showMessageDialog(btnNewButton, ": Ouch!");
	         }
	     });

		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(47, 24, 256, 38);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel_2.add(btnNewButton);		
		
		JButton btnNewButton_1 = new JButton("ADD NEW PORT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableAddNewRow(); 				
			}
		});
		btnNewButton_1.setBounds(47, 334, 140, 38);
		panel_2.add(btnNewButton_1);
		
		JButton btnAddNewConfig = new JButton("ADD NEW CONFIG");
		btnAddNewConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableAddNewColumn();
			}
		});
		btnAddNewConfig.setBounds(705, 31, 140, 38);
		panel_2.add(btnAddNewConfig);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 84, 798, 237);
		panel_2.add(scrollPane);
		scrollPane.add(table_2);
		
		//table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		
		
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
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JCheckBox checkBox = new JCheckBox("USE MAILBOX DPI Emulation");
		checkBox.setBackground(checkBoxColor);
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkBox.setBounds(34, 82, 291, 25);
		panel_8.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("EMULATE CPU");
		checkBox_1.setBackground(checkBoxColor);
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkBox_1.setBounds(34, 52, 153, 25);
		panel_8.add(checkBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("EMULATION");
		lblNewLabel_1.setBounds(143, 13, 153, 25);
		panel_8.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnNewButton_3 = new JButton("CONFIG");
		btnNewButton_3.setBounds(308, 48, 97, 25);
		panel_8.add(btnNewButton_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(borderdash);
		panel_5.setBounds(534, 198, 400, 156);
		frmEasyicCoverified.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 13, 376, 130);
		panel_5.add(panel_6);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setLayout(null);
				
		JLabel lblBfm = new JLabel("BFM");
		lblBfm.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBfm.setBounds(162, 13, 71, 30);
		panel_6.add(lblBfm);
		
		JCheckBox chckbxBfm = new JCheckBox("BFM ENV");
		chckbxBfm.setBackground(checkBoxColor);
		chckbxBfm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxBfm.setBounds(34, 52, 153, 25);
		panel_6.add(chckbxBfm);
		
		JCheckBox chckbxTodo = new JCheckBox("TODO");
		chckbxTodo.setBackground(checkBoxColor);
		chckbxTodo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxTodo.setBounds(34, 82, 153, 25);
		panel_6.add(chckbxTodo);		
		
		panel_5.add(panel_6);
		
		JButton btnNewButton_4 = new JButton("CONFIG");
		btnNewButton_4.setBounds(267, 54, 97, 25);
		panel_6.add(btnNewButton_4);
					
		JMenuBar menuBar = new JMenuBar();
		frmEasyicCoverified.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Project");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Load");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JFileChooser fileChooser = new JFileChooser();
				//fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				Preferences prefs = Preferences.userRoot().node(getClass().getName());
				JFileChooser fileChooser = new JFileChooser(prefs.get("LAST_USED_FOLDER",
				    new File(".").getAbsolutePath()));
				int result = fileChooser.showOpenDialog(frmEasyicCoverified);
				if (result == JFileChooser.APPROVE_OPTION) {
					prefs.put("LAST_USED_FOLDER", fileChooser.getSelectedFile().getParent());
					
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				    InputStream inputStream;
					try {
						configProps = new Properties();
						
						inputStream = new FileInputStream(selectedFile.getAbsolutePath());
						configProps.load(inputStream);
						inputStream.close();
					} catch (FileNotFoundException e) {
						System.out.println("FileNotFoundException ");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("IOException ");
						e.printStackTrace();
					}
					
					List<Component>  lst = getAllComponents(frmEasyicCoverified);
				    for (Component comp : lst) {
				    	if(comp instanceof JCheckBox)  {
				    		//System.out.println(comp.getName());
				    		System.out.println(((JCheckBox) comp).getText());
				    		System.out.println(((JCheckBox) comp).isSelected());
				    		((JCheckBox) comp).setSelected(Boolean.valueOf(configProps.getProperty(((JCheckBox) comp).getText())));
				    	}
				    	if(comp instanceof JTextField) { 
					    	System.out.println(((JTextField) comp).getName());
					    	System.out.println(((JTextField) comp).getText());
					    	 ((JTextField) comp).setText(configProps.getProperty(((JTextField) comp).getName()));
				    	}
				    }
				    
				    /*table only*/
			    	int rows = Integer.valueOf(configProps.getProperty("rows"));
			    	int columns = Integer.valueOf(configProps.getProperty("columns"));
			    	
			    	for(int i = 0; i < rows - table_2.getRowCount(); i++) TableAddNewRow();
			    	for(int i = 0; i < columns - table_2.getColumnCount(); i++) TableAddNewColumn();
			    	
				    for (int i = 0; i < table_2.getRowCount(); i++) {
				        for (int j = 0; j < table_2.getColumnCount(); j++) {
				        	System.out.println(table_2.getValueAt(i, j));
				        	if( j != 0)
				        		table_2.setValueAt(Boolean.valueOf(configProps.getProperty(i + "_" + j)), i, j);
				        	else 
				        		table_2.setValueAt(configProps.getProperty(i + "_" + j), i, j);				        	
				        }
				    }
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {							
				//JFileChooser fileChooser = new JFileChooser();
				//fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				Preferences prefs = Preferences.userRoot().node(getClass().getName());
				JFileChooser fileChooser = new JFileChooser(prefs.get("LAST_USED_FOLDER",
				    new File(".").getAbsolutePath()));
				int result = fileChooser.showOpenDialog(frmEasyicCoverified);
				if (result == JFileChooser.APPROVE_OPTION) {
					prefs.put("LAST_USED_FOLDER", fileChooser.getSelectedFile().getParent());
					File selectedFile = fileChooser.getSelectedFile();				    
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());

				    configProps = new Properties();
				    List<Component>  lst = getAllComponents(frmEasyicCoverified);
				    for (Component comp : lst) {
				    	if(comp instanceof JCheckBox)  {
				    		//System.out.println(comp.getName());
				    		System.out.println(((JCheckBox) comp).getText());
				    		System.out.println(((JCheckBox) comp).isSelected());
				    		configProps.setProperty(((JCheckBox) comp).getText(), Boolean.toString(((JCheckBox) comp).isSelected()));
				    	}
				    	if(comp instanceof JTextField) { 
					    	System.out.println(((JTextField) comp).getName());
					    	System.out.println(((JTextField) comp).getText());
					    	configProps.setProperty(((JTextField) comp).getName(), ((JTextField) comp).getText());
				    	}
				    }
				    
				    /*table only*/
			    	configProps.setProperty("rows", Integer.toString(table_2.getRowCount()));
			    	configProps.setProperty("columns", Integer.toString(table_2.getColumnCount()));
				    for (int i = 0; i < table_2.getRowCount(); i++) {
				        for (int j = 0; j < table_2.getColumnCount(); j++) {
				        	System.out.println(table_2.getValueAt(i, j));
				        	configProps.setProperty(i + "_" + j, table_2.getValueAt(i, j).toString());
				        }
				    }
				    
				    
					try {
						OutputStream outputStream = new FileOutputStream(selectedFile.getAbsolutePath());
						configProps.store(outputStream, "ui setttings");
						outputStream.close();
					} catch (FileNotFoundException e1) {
						System.out.println("FileNotFoundException ");
						e1.printStackTrace();
					} catch (IOException e1) {
						System.out.println("IOException ");
						e1.printStackTrace();
					}										
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Settings...");
		mnNewMenu_1.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				frmConfigPrj = new ConfigPrj(frmEasyicCoverified);
				frmConfigPrj.setVisible(true);
				frmConfigPrj.show(true);
				frmConfigPrj.setAlwaysOnTop(true);
				System.out.print("DDDDD");
			}
		});
		
		menuBar.add(mnNewMenu_1);
	}
	
	
}
