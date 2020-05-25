package easyic;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;


public class MyCellComponentRenderer extends MyComponent implements TableCellRenderer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyCellComponentRenderer() {
		super();
      setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                     boolean isSelected, boolean hasFocus, int row, int column) {
      if (isSelected) {
        this.setForeground(table.getSelectionForeground());
        setBackground(table.getSelectionBackground());
      } else{
        setForeground(table.getForeground());
        setBackground(Color.white);
      }

      setLable((value == null) ? "" : value.toString());
           
      return this;
    }
}

//this is for test:
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


//test :
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
