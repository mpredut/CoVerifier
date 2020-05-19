package easyic;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class MyCellComponentEditor extends DefaultCellEditor {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MyComponent myComponent;

    private boolean isPushed;

    public MyCellComponentEditor(JCheckBox checkBox) {
        super(checkBox);

        myComponent = new MyComponent();
        myComponent.getCheckBox().setOpaque(true);
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

        return myComponent;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
        }
        isPushed = false;
        return new String("");
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

