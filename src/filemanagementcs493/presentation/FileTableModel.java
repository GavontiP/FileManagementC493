package filemanagementcs493.presentation;

import javax.swing.table.AbstractTableModel;
import filemanagementcs493.utils.*; // Needed for the domain classes
import java.util.Arrays;

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
        String temp[] = filelist.findAtPosition(filelist, row).toString().split(",");
        String[] arr = new String[temp.length];
        for (int i = 0; i < 5; i++) {
            arr[i] = temp[i].split("\\=")[1];
        }
        return arr[column];
    }

    // done
    @Override
    public String getColumnName(int index) {

        return columnNames[index];
    }

    // set
    public void setFiles(LinkedList filelist) {
        this.filelist = filelist;
    }

}
