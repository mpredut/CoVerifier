package easyic;

import javax.swing.table.DefaultTableModel;

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
	private String[] columnNames = {"EXTERNAL PORT", "Config ALL"};
	
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
                    return MyComponent.class;
                case 1:
                    return Boolean.class;
                default:
                    return Boolean.class;
            }
        }

	
	/* main */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
	}
}


/*
*
* FOR DEBUG!		
table_1 = new JTable();
table_1.setBackground(Color.BLACK);
table_1.setForeground(Color.WHITE);
table_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
table_1.setModel(new DefaultTableModel(
	new Object[][] {
		{"EXTERNAL PORT", "CONFIG ALL"},
	},
	new String[] {
		"EXTERNAL PORT", "Config ALL"
	}
));
table_1.setAlignmentX(50);
table_1.getColumnModel().getColumn(0).setPreferredWidth(152);
table_1.getColumnModel().getColumn(0).setMinWidth(50);
table_1.getColumnModel().getColumn(1).setPreferredWidth(152);
table_1.getColumnModel().getColumn(1).setMinWidth(50);
table_1.setRowHeight(52);
table_1.setBounds(47, 81, 774, 48);
table_1.setVisible(false);
panel_2.add(table_1);

*/

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


//for (int i = 0; i < model.getRowCount(); i++) {
	//Object obj = table_2.getValueAt(i, 0);
    //MyComponent value = (MyComponent)table.getValueAt(i, 0);// check state
    //value.setLable("cucu" + i);
    //    System.out.println(model.getValueAt(i, 1));// second column value
    
//}

//JScrollPane scroll = new JScrollPane(table);
//getContentPane().add(scroll);
//setSize(400, 100);
//setVisible(true);
/////////
