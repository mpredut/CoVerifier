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
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.border.MatteBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.swing.text.html.ImageView;
import javax.swing.text.Element;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
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



/**
 * The methods in this class allow the JTable component to get
 * and display data about the files in a specified directory.
 * It represents a table with six columns: filename, size, modification date, 
 * plus three columns for flags: directory, readable, writable.
 **/

class TableModel extends DefaultTableModel {	   //DefaultTableModel implements 
	private static final long serialVersionUID = 1L;
	
	private Object[][] rows = {
								{new MyComponent(), (true)},
								{new MyComponent(), (true)},
								{new MyComponent(), (true)}
								};
	private String[] columnNames = {"Col1", "Col2"};
	
	TableModel() {
	
	
	/*
	((JButton)rows[0][0]).addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    JOptionPane.showMessageDialog((JButton)rows[0][0], ": Ouch!");
		}
	});*/

	}
   	public String getColumnName(int column) {
      return columnNames[column];
   	}
   	public int getRowCount() {
      //return rows.length;
   		return 3;
   	}
	public int getColumnCount() {
     // return columnNames.length;
		return 2;
	}
	public Object getValueAt(int row, int column) {
      return rows[row][column];
	}
	public boolean isCellEditable(int row, int column) {
      return true;
	}
	
	@SuppressWarnings("unchecked")
	public Class getColumnClass(int column) {
     // return getValueAt(0, column).getClass();
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return Boolean.class;
                default:
                    return Boolean.class;
            }
        }
   }   

class JTableButtonRenderer implements TableCellRenderer {
	   private TableCellRenderer defaultRenderer;
	   public JTableButtonRenderer(TableCellRenderer renderer) {
	      defaultRenderer = renderer;
	   }
	   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	      if(value instanceof Component)
	         return (Component)value;
	         return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	   }
	}

class ButtonRenderer extends JButton implements TableCellRenderer {

	private static final long serialVersionUID = 1L;

	public ButtonRenderer() {
	    setOpaque(true);
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int col) {
		  
		  //JButton button = new JButton();
		  //JOptionPane.showMessageDialog((JButton)(value), row + " " + col +": Ouch!");
		   
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      if(row == 1)
	      setBackground(UIManager.getColor("Button.background"));
	      else 
	    	  setBackground(UIManager.getColor("Checkbox.background"));
	    }
	    setText((value == null) ? "" : value.toString());
	   // JButton button = new JButton();
	    //JOptionPane.showMessageDialog(button, row + " " + column +": Ouch!");
	    System.out.println(row + " " + col + ": Ouch!");
	    return this;
	  }
}

	class ButtonEditor extends DefaultCellEditor {
		private static final long serialVersionUID = 1L;

		protected JCheckBox button;

		private String label;

		private boolean isPushed;

	  public ButtonEditor(JCheckBox checkBox) {
	    super(checkBox);
	    //button = new JButton();
	    button = checkBox;
	    button.setOpaque(true);
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	      }
	    });
	  }

	  public Component getTableCellEditorComponent(JTable table, Object value,
	      boolean isSelected, int row, int column) {
		  
		  //JButton button = new JButton();
		   //JOptionPane.showMessageDialog(button, row + " " + column +": Ouch!");
	    if (isSelected) {
	      //button.setForeground(table.getSelectionForeground());
	      //button.setBackground(table.getSelectionBackground());
	    } else {
	      //button.setForeground(table.getForeground());
	      //button.setBackground(table.getBackground());
	    }
	    label = (value == null) ? "" : value.toString();
	    //button.setText(label);
	    isPushed = true;
	    return button;
	  }

	  public Object getCellEditorValue() {
	    if (isPushed) {
	      // 
	      // 
	      JOptionPane.showMessageDialog(button, label + ": Ouch!");
	       System.out.println(label + ": Ouch!");
	    }
	    isPushed = false;
	    return new String(label);
	  }

	  public boolean stopCellEditing() {
	    isPushed = false;
	    return super.stopCellEditing();
	  }

	  protected void fireEditingStopped() {
	    super.fireEditingStopped();
	  }
	}



public class CoVerifier {

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
					CoVerifier window = new CoVerifier();
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
		frmEasyicCoverified.getContentPane().setForeground(ORANGE);
		frmEasyicCoverified.setForeground(ORANGE);
		frmEasyicCoverified.setBackground(ORANGE);
		frmEasyicCoverified.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmEasyicCoverified.setTitle("EasyIC CoVerifier");
		frmEasyicCoverified.setBounds(100, 100, 1012, 810);
		frmEasyicCoverified.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEasyicCoverified.getContentPane().setLayout(null);
		
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
		
		LineBorder border = new LineBorder(new Color(0, 0, 0), 3, true);
		
		/*** aici creez un bordar dash ***/
		Paint pnt = new GradientPaint(0, 0, Color.red, 100, 100, Color.pink, true); 
		float thickness = 2; float  length = 5; float  spacing= 5; boolean rounded = true;
		Border borderdash = BorderFactory.createDashedBorder(pnt, thickness, length, spacing, rounded);
		/*end border dash*/
		
		//panel.setBorder(borderdash);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(48, 29, 886, 156);
		frmEasyicCoverified.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), null));
		panel_3.setBounds(12, 13, 424, 130);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox chckbxFvControl = new JCheckBox("FW   Control");
		chckbxFvControl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		chckbxFvControl.setBackground(new Color(242, 246, 223));
		chckbxFvControl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxFvControl.setBounds(37, 78, 150, 25);
		panel_3.add(chckbxFvControl);
		
		JCheckBox chckbxUvmControl = new JCheckBox("UVM Control");
		chckbxUvmControl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		chckbxUvmControl.setBackground(new Color(242, 246, 223));
		chckbxUvmControl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxUvmControl.setBounds(37, 51, 150, 25);
		panel_3.add(chckbxUvmControl);
		
		JLabel lblNewLabel_2 = new JLabel("MAIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(163, 22, 56, 16);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("Not used  if Emulated CPU & DPI selected");
		panel_4.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), null));
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
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(48, 370, 886, 404);
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

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setForeground(Color.BLACK);
		table.setBackground(ORANGE);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
				{panel_7, null},
				{"  SPI", null},
				{"  HDMI", null},
			},
			new String[] {
				"EXT_PORT", "CONFIG1"
			}
		));*/
		//TableCellRenderer tableRenderer = table.getDefaultRenderer(JButton.class);
	    //table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
	      //scrollPane = new JScrollPane(table);
	      //add(scrollPane, BorderLayout.CENTER);
		
    	     
		//TableModel model = new TableModel();
		//table.setModel(model);
		 Object[][] rows = {
				{("UART"), (true)},
				{("  SPI  "), (true)},
				{("HDMI"), (true)}
				};
String[] columnNames = {"Col1", "Col2"};
		 DefaultTableModel model = new DefaultTableModel(rows, columnNames);
	        table = new JTable(model) {

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
	            	if(column != 0)
	                return true;
	            	return false;
	          	}
	        };
		
		//table.getColumn("Col1").setCellRenderer(new ButtonRenderer());
		//table.getColumn("Button2").setCellRenderer(new ButtonRenderer());
		//table.getColumn("Col2").setCellEditor(new ButtonEditor(new JCheckBox()));
		
		
		/////
		/*DefaultTableModel model = new DefaultTableModel();
	    model.setDataVector(new Object[][] {
	    	{("Button1"), ("chk1")},
			{("Button2"), ("chk2")},
			{("Button3"), ("chk3")}
			}, new Object[] { "Col1", "Col2" });
	    
	    table.setModel(model);
	    */
		
	    //JTable table = new JTable(dm);
	    //TableColumn tc = table.getColumn("Button1");
	    
	    //table.getColumn("Col1").setCellRenderer(new ButtonRenderer());
	    //table.getColumn("Col1").setCellEditor(new ButtonEditor(new JCheckBox()));
	    table.getColumn("Col1").setCellRenderer(new MyCellComponentRenderer());
	    table.getColumn("Col1").setCellEditor(new MyCellComponentEditor(new JCheckBox()));
	    
        for (int i = 0; i < model.getRowCount(); i++) {
        	Object obj= table.getValueAt(i, 0);
            //MyComponent value = (MyComponent)table.getValueAt(i, 0);// check state
            //value.setLable("cucu" + i);
            //    System.out.println(model.getValueAt(i, 1));// second column value
            
        }

	    
	    //JScrollPane scroll = new JScrollPane(table);
	    //getContentPane().add(scroll);
	    //setSize(400, 100);
	    //setVisible(true);
	    /////////
	    
		
		table.getColumnModel().getColumn(0).setPreferredWidth(152);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(152);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.setRowHeight(32);
		table.setRowMargin(5);
		table.setBounds(47, 129, 774, 211);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setVisible(true);
		panel_2.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(833, 85, 21, 255);
		panel_2.add(scrollBar);
		
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
		
		table_1 = new JTable();
		table_1.setBackground(Color.BLACK);
		table_1.setForeground(Color.WHITE);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"EXT. PORT", "CONFIG ALL"},
			},
			new String[] {
				"New column", "test"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(152);
		table_1.getColumnModel().getColumn(0).setMinWidth(50);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(152);
		table_1.getColumnModel().getColumn(1).setMinWidth(50);
		table_1.setRowHeight(52);
		table_1.setBounds(47, 81, 774, 48);
		panel_2.add(table_1);
		
		JButton btnNewButton_1 = new JButton("ADD NEW PORT");
		btnNewButton_1.setBounds(47, 353, 140, 38);
		panel_2.add(btnNewButton_1);
		
		JButton btnAddNewConfig = new JButton("ADD NEW CONFIG");
		btnAddNewConfig.setBounds(681, 31, 140, 38);
		panel_2.add(btnAddNewConfig);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(border);
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
		
		JLabel lblNewLabel_1 = new JLabel("EMULATION");
		lblNewLabel_1.setBounds(143, 13, 153, 25);
		panel_8.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(308, 48, 97, 25);
		btnNewButton_3.setIcon(new ImageIcon("res\\axi.gif"));
		panel_8.add(btnNewButton_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(border);
		panel_5.setBounds(534, 198, 400, 156);
		frmEasyicCoverified.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 13, 376, 130);
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
		lblBfm.setBounds(162, 13, 71, 30);
		panel_6.add(lblBfm);
		
		panel_5.add(panel_6);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(267, 54, 97, 25);
		btnNewButton_4.setIcon(new ImageIcon("res\\uart.gif"));		
		panel_6.add(btnNewButton_4);
					
		JMenuBar menuBar = new JMenuBar();
		frmEasyicCoverified.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Project");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Load");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Settings...");
		menuBar.add(mnNewMenu_1);
	}
}
