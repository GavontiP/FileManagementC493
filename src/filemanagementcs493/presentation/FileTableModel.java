package filemanagementcs493.presentation;

import javax.swing.table.AbstractTableModel;
import filemanagementcs493.utils.*; // Needed for the domain classes

public class FileTableModel extends AbstractTableModel {
    private LinkedList filelist = new LinkedList();
    private final String columnNames[] = { "Type", "Name", "Location", "Size", "Created" };
    Object item;

    // done
    public FileTableModel() {
        this.filelist = null;
    }

    // done
    @Override
    public int getColumnCount() {

        return this.columnNames.length;
    }

    // done
    @Override
    public int getRowCount() {

        return this.filelist.getSize();
    }

    // done?
    @Override
    public Object getValueAt(int row, int column) {
        try{
        String temp[] = filelist.findAtPosition(filelist, row).split(" ");
        return temp[column];
        
        }catch(ArrayIndexOutOfBoundsException e){
            String temp[] = filelist.findAtPosition(filelist, 0).split(" ");
            return temp[column];
        }
    }

    // done
    @Override
    public String getColumnName(int index) {

        return columnNames[index];
    }

    // set
    public void setAnimals(LinkedList filelist) {
        this.filelist = filelist;
    }

}
