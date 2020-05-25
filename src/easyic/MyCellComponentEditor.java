package easyic;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MyCellComponentEditor extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;

	private MyComponent myComponent;

    private boolean isPushed;

    public MyCellComponentEditor(JCheckBox checkBox) {
        super(checkBox);

        myComponent = new MyComponent();
      //  myComponent.getCheckBox().setOpaque(true);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column)
    {
        if (isSelected) {
            myComponent.setForeground(table.getSelectionForeground());
            myComponent.setBackground(table.getSelectionBackground());
        } else {
            myComponent.setForeground(table.getForeground());
            myComponent.setBackground(Color.orange);
        }

        myComponent.setLable(value.toString());
        System.out.println("cel editor row : " + row + " " + value.toString());
        return myComponent;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
        }
        isPushed = false;
        
        System.out.println("getCellEditorValue");
        return myComponent.getLable();
    }
    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}


//this is for test:
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
