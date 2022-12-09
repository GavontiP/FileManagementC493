/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493.presentation;

import filemanagementcs493.application.Directory;
import filemanagementcs493.application.Filess;
import filemanagementcs493.application.source;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import filemanagementcs493.persistence.fileDao;
import filemanagementcs493.persistence.systemCalls;
import filemanagementcs493.state;
import java.awt.GridLayout;
import static java.nio.file.Files.delete;
import filemanagementcs493.utils.*;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javax.swing.JFrame;

/**
 *
 * @author Gavonti Patton
 */
public class MainUI extends javax.swing.JFrame {
    private int selectedRow = 0;
    LinkedList<source> filelist = new LinkedList();
    fileDao database = new fileDao();
    systemCalls systemint = new systemCalls();
    private FileTableModel model = new FileTableModel();

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        filesTbl.setAutoCreateRowSorter(true);
        // filesTbl.getColumnModel().getColumn(0).setPreferredWidth(5);
        // filesTbl.getColumnModel().getColumn(2).setPreferredWidth(250);
        // filesTbl.getColumnModel().getColumn(3).setPreferredWidth(5);
        // filesTbl.getColumnModel().getColumn(4).setPreferredWidth(25);
        // filesTbl.getColumnModel().getColumn(1).setPreferredWidth(25);
        nameLbl.setDisplayedMnemonic('n');
        nameLbl.setLabelFor(nameTxtFld);
        pathLbl.setDisplayedMnemonic('b');
        pathLbl.setLabelFor(pathTxtField);
        exitMenuItem.setMnemonic('x');
        addBtn.setMnemonic('a');
        modifyBtn.setMnemonic('o');
        deleteBtn.setMnemonic('l');
        exitBtn.setMnemonic('e');
        fileMenuItem.setMnemonic('f');
        clearBtn.setMnemonic('c');
        pathTxtField.setText(state.currLocation);
        //
        // // create new month focus listener
        // monthTxtFld.addFocusListener(new FocusListener() {
        // @Override
        // public void focusGained(FocusEvent e) {
        // if (monthTxtFld.getText().equals("MM")) // Default text is "MM"
        // monthTxtFld.selectAll(); // Select all text
        // }
        //
        // @Override
        // public void focusLost(FocusEvent arg0) {
        // // Do nothing when focus is lost
        // }
        // });
        // // create new day focus listener
        // dayTxtFld.addFocusListener(new FocusListener() {
        // @Override
        // public void focusGained(FocusEvent e) {
        // if (dayTxtFld.getText().equals("DD")) // Default text is "MM"
        // dayTxtFld.selectAll(); // Select all text
        // }
        //
        // @Override
        // public void focusLost(FocusEvent arg0) {
        // // Do nothing when focus is lost
        // }
        // });

        // // create new year focus listener
        // yearTxtFld.addFocusListener(new FocusListener() {
        // @Override
        // public void focusGained(FocusEvent e) {
        // if (yearTxtFld.getText().equals("YYYY")) // Default text is "MM"
        // yearTxtFld.selectAll(); // Select all text
        // }
        //
        // @Override
        // public void focusLost(FocusEvent arg0) {
        // // Do nothing when focus is lost
        // }
        // });
        LinkedList<source> term = database.getAll();
        term.printList(term);
        int temp = term.getSize();
        for (int i = 0; i < temp; i++) {
            source item = term.findAtPosition(term, i);
            if (item.getType().equals("file")) {
                System.out.println(item.toString());
                Filess file = new Filess(item.getName(), item.getCreated(), item.getSize(), item.getLocation());
                filelist.insert(filelist, file);
                model.setFiles(filelist);
                filesTbl.setModel(model);
                model.fireTableDataChanged();
                filesTbl.setColumnSelectionAllowed(false);
                filesTbl.setRowSelectionAllowed(true);

            } else {
                System.out.println(item.toString());
                Directory file = new Directory(item.getName(), item.getCreated(), item.getSize(), item.getLocation());
                filelist.insert(filelist, file);
                model.setFiles(filelist);
                filesTbl.setModel(model);
                model.fireTableDataChanged();
                filesTbl.setColumnSelectionAllowed(false);
                filesTbl.setRowSelectionAllowed(true);
            }
        }

        filesTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // FileTableModel model = new FileTableModel();
                // LinkedList<Filess> filelisttemp = new LinkedList();
                // filelisttemp.printList(filelisttemp);
                int row = filesTbl.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selectedRow = row;
                    pathTxtField.setText(model.getValueAt(row, 2).toString());
                    nameTxtFld.setText(model.getValueAt(row, 1).toString());
                }
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuItem1 = new javax.swing.JMenuItem();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        filesTbl = new javax.swing.JTable();
        pathTxtField = new javax.swing.JTextField();
        nameTxtFld = new javax.swing.JTextField();
        pathLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        typeComboBox = new javax.swing.JComboBox<>();
        typeLbl = new javax.swing.JLabel();
        fileMenu = new javax.swing.JMenuBar();
        fileMenuItem = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jTextField2.setText("jTextField2");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane2.setViewportView(jList1);

        jMenuItem1.setText("jMenuItem1");

        jComboBox1.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Management cs493");

        filesTbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "Type", "Location", "Name", "Size", "Arrived"
                }) {
            Class[] types = new Class[] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class,
                    java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        filesTbl.setToolTipText("");
        filesTbl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filesTblFocusGained(evt);
            }
        });
        filesTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filesTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(filesTbl);
        if (filesTbl.getColumnModel().getColumnCount() > 0) {
            filesTbl.getColumnModel().getColumn(0).setMinWidth(50);
            filesTbl.getColumnModel().getColumn(0).setMaxWidth(10);
            filesTbl.getColumnModel().getColumn(1).setMinWidth(250);
            filesTbl.getColumnModel().getColumn(2).setMinWidth(50);
            filesTbl.getColumnModel().getColumn(3).setMinWidth(50);
            filesTbl.getColumnModel().getColumn(3).setMaxWidth(10);
            filesTbl.getColumnModel().getColumn(4).setMinWidth(50);
        }

        pathLbl.setText("Path/Location");

        nameLbl.setText("Name");

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Directory", "File" }));

        typeLbl.setText("Name");

        fileMenuItem.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenuItem.add(exitMenuItem);

        fileMenu.add(fileMenuItem);
        fileMenu.add(jMenu2);

        setJMenuBar(fileMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(addBtn,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(modifyBtn,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(deleteBtn,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(exitBtn,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(nameLbl)
                                                                        .addComponent(typeLbl))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        39, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(typeComboBox,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(nameTxtFld,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        312,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(pathLbl)
                                                                                .addGap(34, 34, 34)
                                                                                .addComponent(pathTxtField,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        313,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(19, 19, 19)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(typeLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pathTxtField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearBtn)
                                        .addComponent(pathLbl)
                                        .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addBtn)
                                        .addComponent(modifyBtn)
                                        .addComponent(deleteBtn)
                                        .addComponent(exitBtn))
                                .addContainerGap()));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_clearBtnActionPerformed
        nameTxtFld.setText("");
        pathTxtField.setText("");
    }// GEN-LAST:event_clearBtnActionPerformed

    private void filesTblFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_filesTblFocusGained
    }// GEN-LAST:event_filesTblFocusGained

    private void filesTblMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_filesTblMouseClicked
        int row = filesTbl.rowAtPoint(evt.getPoint());
        System.out.println("Mouse event, clickCount = " + evt.getClickCount());

        if (evt.getClickCount() == 1) {
            System.out.println("Single Click");
        }

        if (evt.getClickCount() == 2) {
            System.out.println("Double Click");
            state.currLocation = model.getValueAt(row, 2).toString();
            System.out.println(state.currLocation);
            database.deleteAll();
            if (model.getValueAt(row, 0).equals("directory")) {
                Directory fileclass = new Directory("help", state.currLocation, "27.3GB", "created");
                File filetest = new File(state.currLocation);
                filelist = systemint.getAll(filetest);
                LinkedList<source> term = database.getAll();
                term.printList(term);
                int temp = term.getSize();
                for (int i = 0; i < temp; i++) {
                    source item = term.findAtPosition(term, i);
                    if (item.getType().equals("file")) {
                        System.out.println(item.toString());
                        Filess file = new Filess(item.getName(), item.getCreated(), item.getSize(), item.getLocation());
                        filelist.insert(filelist, file);

                    } else {
                        System.out.println(item.toString());
                        Directory file = new Directory(item.getName(), item.getCreated(), item.getSize(),
                                item.getLocation());
                        filelist.insert(filelist, file);
                    }
                }
            } else {
                System.out.println("this is a file");
                try {
                    // constructor of file class having file as argument
                    File file = new File(model.getValueAt(row, 2).toString());
                    if (!Desktop.isDesktopSupported())// check if Desktop is supported by Platform or not
                    {
                        System.out.println("not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if (file.exists()) // checks file exists or not
                        desktop.open(file); // opens the specified file
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            selectedRow = -1;
            model.setFiles(filelist);
            model.fireTableDataChanged();
            typeComboBox.setSelectedIndex(0);
            nameTxtFld.setText("");
            pathTxtField.setText(state.currLocation);

        }

    }// GEN-LAST:event_filesTblMouseClicked

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_modifyBtnActionPerformed
        // if (selectedRow < 0)
        // return;
        // String name = nameTxtFld.getText();
        // String path = pathTxtField.getText();
        // // Filess a = new Filess(
        // System.out.println(filelist.findAtPosition(filelist, selectedRow));
        // String[] temp = filelist.findAtPosition(filelist, selectedRow).split(" ");
        // Filess file = new Filess(nameTxtFld.getText(),temp[4], temp[3], temp[2]);
        // filelist.insert(filelist, file);
        // selectedRow = -1;
        // model.setFiles(filelist);
        // model.fireTableDataChanged();
        // nameTxtFld.setText("");
        // pathTxtField.setText("");
    }// GEN-LAST:event_modifyBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteBtnActionPerformed
        if (selectedRow < 0)
            return;

        System.out.println(filelist.findAtPosition(filelist, selectedRow));
        int des;
        des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this file?", "Deletion Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (des == 0) {
            // this mean that the user click the yes option
            // Put your code here that you want to execute when the user click the yes
            // option
            try {
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Input Validation Error message");
                return;
            }
            database.delete(filelist.findAtPosition(filelist, selectedRow));
            systemint.delete(filelist.findAtPosition(filelist, selectedRow));
            filelist.printList(filelist.deleteAtPosition(filelist, selectedRow));
            selectedRow = -1;
            model.setFiles(filelist);
            model.fireTableDataChanged();
            nameTxtFld.setText("");
        } else {

            // in this else condition this is the no option
            // in this block you can leave it empty if you don’t want to display some
            // message to user
        }
        // GEN-LAST:event_deleteBtnActionPerformed
    }

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }// GEN-LAST:event_exitBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addBtnActionPerformed
        String name = nameTxtFld.getText();
        String type = typeComboBox.getSelectedItem().toString();
        String path = pathTxtField.getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        if (type.contains("directory")) {
            Directory dog = new Directory(name, path + "\\" + name, "0", dtf.format(now));
            System.out.println(dog.toString());
            if (!systemint.add(dog)) {
                JOptionPane.showMessageDialog(null, "System Error message");
            }
            if (database.add(dog) == false) {
                JOptionPane.showMessageDialog(null, "Database Error message");
                return;
            }
            filelist.insert(filelist, dog);
        } else if (type.contains("file")) {
            Filess dog = new Filess(name, path + "\\" + name, "0", dtf.format(now));
            System.out.println(dog.toString());
            if (!systemint.add(dog)) {
                JOptionPane.showMessageDialog(null, "System Error message");
            }
            if (database.add(dog) == false) {
                JOptionPane.showMessageDialog(null, "Database Error message");
                return;
            }
            filelist.insert(filelist, dog);
        }
        selectedRow = -1;
        model.setFiles(filelist);
        model.fireTableDataChanged();
        typeComboBox.setSelectedIndex(0);
        nameTxtFld.setText("");

    }// GEN-LAST:event_addBtnActionPerformed

    private void typeComboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_typeComboActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_typeComboActionPerformed

    private void dayTxtFldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dayTxtFldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_dayTxtFldActionPerformed

    private void monthTxtFldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_monthTxtFldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_monthTxtFldActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }// GEN-LAST:event_exitMenuItemActionPerformed

    private void yearTxtFldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_yearTxtFldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_yearTxtFldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuBar fileMenu;
    private javax.swing.JMenu fileMenuItem;
    private javax.swing.JTable filesTbl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxtFld;
    private javax.swing.JLabel pathLbl;
    private javax.swing.JTextField pathTxtField;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration//GEN-END:variables
}
