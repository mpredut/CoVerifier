package easyic;

import javax.swing.JTable;

/*
public class ConfigTable extends JTable{

    	public table() {
    	    String[] headers = { "Parent", "Summary"};
    	    DefaultTableModel  model = new DefaultTableModel();
    	    for(String header:headers){
    	        model.addColumn(header);
    	  
    	    Object[][] rows = {
    				{("UART"), (true)},
    				{("  SPI  "), (true)},
    				{("HDMI"), (true)}
    				};
    String[] columnNames = {"Col1", "Col2"};
    		 //DefaultTableModel model = new DefaultTableModel(rows, columnNames);
    		 
    	    
    	    model.addRow(rows);

    	    setModel(model);

    	    Enumeration<TableColumn> columns = getColumnModel().getColumns();
    	    while (columns.hasMoreElements()) {
    	        TableColumn column = (TableColumn) columns.nextElement();
    	        System.out.println(column.getHeaderValue());
    	        column.setResizable(false);
    	        switch ((String) column.getHeaderValue()) {
    	        //case "Parent":
    	        //case "Key":
    	        case "Processed":
    	            column.setMaxWidth(80);
    	            column.setMinWidth(80);
    	            column.setHeaderRenderer(new CenterRenderer());
    	            break;
    	        }
    	    }
    	}
    	}  

*/