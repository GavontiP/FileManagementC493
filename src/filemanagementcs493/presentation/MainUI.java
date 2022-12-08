/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493.presentation;

import filemanagementcs493.application.Filess;
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
import java.util.Arrays;
import javax.swing.JFrame;

/**
 *
 * @author Gavonti Patton
 */
public class MainUI extends javax.swing.JFrame {
        private int selectedRow = 0;
        LinkedList<Filess> filelist = new LinkedList();
        fileDao database = new fileDao();
        systemCalls systemint = new systemCalls();
            private FileTableModel model = new FileTableModel();
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        filesTbl.setAutoCreateRowSorter(true);
//        filesTbl.getColumnModel().getColumn(0).setPreferredWidth(5);
//        filesTbl.getColumnModel().getColumn(2).setPreferredWidth(250);
//        filesTbl.getColumnModel().getColumn(3).setPreferredWidth(5);
//        filesTbl.getColumnModel().getColumn(4).setPreferredWidth(25);
//        filesTbl.getColumnModel().getColumn(1).setPreferredWidth(25);
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
//
//        // create new month focus listener
//        monthTxtFld.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (monthTxtFld.getText().equals("MM")) // Default text is "MM"
//                    monthTxtFld.selectAll(); // Select all text
//            }
//
//            @Override
//            public void focusLost(FocusEvent arg0) {
//                // Do nothing when focus is lost
//            }
//        });

//        // create new day focus listener
//        dayTxtFld.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (dayTxtFld.getText().equals("DD")) // Default text is "MM"
//                    dayTxtFld.selectAll(); // Select all text
//            }
//
//            @Override
//            public void focusLost(FocusEvent arg0) {
//                // Do nothing when focus is lost
//            }
//        });

//        // create new year focus listener
//        yearTxtFld.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (yearTxtFld.getText().equals("YYYY")) // Default text is "MM"
//                    yearTxtFld.selectAll(); // Select all text
//            }
//
//            @Override
//            public void focusLost(FocusEvent arg0) {
//                // Do nothing when focus is lost
//            }
//        });
        LinkedList term = database.getAll();
        int temp = term.getSize();
        for (int i = 0; i < temp; i++) {
            System.out.println(temp);
            String itemDeconstructed[];
            String item = term.findAtPosition(term, i);
            itemDeconstructed = item.split(" ");
           if (itemDeconstructed.length == 7) {
      Filess file = new Filess(itemDeconstructed[2] + "-" + itemDeconstructed[1],  itemDeconstructed[5], itemDeconstructed[4], itemDeconstructed[3]);
       filelist.insert(filelist,file);
            model.setAnimals(filelist);
            filesTbl.setModel(model);
            model.fireTableDataChanged();
            filesTbl.setColumnSelectionAllowed(false);
            filesTbl.setRowSelectionAllowed(true);

        } else if (itemDeconstructed.length == 5) {
           Filess file = new Filess(itemDeconstructed[1], itemDeconstructed[4], itemDeconstructed[3], itemDeconstructed[2]); 
           filelist.insert(filelist,file);
            model.setAnimals(filelist);
            filesTbl.setModel(model);
            model.fireTableDataChanged();
            filesTbl.setColumnSelectionAllowed(false);
            filesTbl.setRowSelectionAllowed(true);
        }
//          
        System.out.println(filelist.getSize());
        }
        filesTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LinkedList<Filess> filelisttemp = new LinkedList();
                filelisttemp.printList(filelisttemp);
                int row = filesTbl.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selectedRow = row;
                    pathTxtField.setText(model.getValueAt(row, 2).toString());
                    nameTxtFld.setText(model.getValueAt(row, 1).toString());
                }
                state.currLocation = model.getValueAt(row, 2).toString();
                System.out.println(state.currLocation);
                database.deleteAll();
                Filess fileclass = new Filess("help", state.currLocation, "27.3GB", "created");
                systemint.getAll(fileclass);
       LinkedList term = database.getAll();
        int temp = term.getSize();
        System.out.println(temp);
        for (int i = 0; i < temp; i++) {
            String itemDeconstructed[];
            String item = filelisttemp.findAtPosition(term,i );
            itemDeconstructed = item.split(" ");
            System.out.println(Arrays.toString(itemDeconstructed));
           if (itemDeconstructed.length == 7) {
      Filess file = new Filess(itemDeconstructed[2] + "-" + itemDeconstructed[1],  itemDeconstructed[5], itemDeconstructed[4], itemDeconstructed[3]);
       filelisttemp.insert(filelisttemp,file);
            model.setAnimals(filelisttemp);
            filesTbl.setModel(model);
            model.fireTableDataChanged();
            filesTbl.setColumnSelectionAllowed(false);
            filesTbl.setRowSelectionAllowed(true);

        } else if (itemDeconstructed.length == 5) {
             System.out.println(Arrays.toString(itemDeconstructed));
           Filess file = new Filess(itemDeconstructed[1], itemDeconstructed[4], itemDeconstructed[3], itemDeconstructed[2]); 
           filelisttemp.insert(filelisttemp,file);
            model.setAnimals(filelisttemp);
            filesTbl.setModel(model);
            model.fireTableDataChanged();
            filesTbl.setColumnSelectionAllowed(false);
            filesTbl.setRowSelectionAllowed(true);
        }
         
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuItem1 = new javax.swing.JMenuItem();
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Management cs493");

        filesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Type", "Location", "Name", "Size", "Arrived"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pathLbl)
                                .addGap(34, 34, 34)
                                .addComponent(pathTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn)
                    .addComponent(pathLbl)
                    .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(modifyBtn)
                    .addComponent(deleteBtn)
                    .addComponent(exitBtn))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        nameTxtFld.setText("");
        pathTxtField.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void filesTblFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filesTblFocusGained
        System.out.println("clicked");
    }//GEN-LAST:event_filesTblFocusGained

    private void filesTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filesTblMouseClicked
          System.out.println("clicked");
    }//GEN-LAST:event_filesTblMouseClicked
 
    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_modifyBtnActionPerformed
        if (selectedRow < 0)
            return;
        String name = nameTxtFld.getText();
        String path = pathTxtField.getText();
//        Filess a = new Filess(
        System.out.println(filelist.findAtPosition(filelist,selectedRow));
//        a.setBreed(pathTxtField.getText());
//        a.setName(nameTxtFld.getText());
//        a.setSterilized(sterilizedValue == "Yes" ? true : false);
//        a.setDateArrived(yearTxtFld.getText() + "-" + monthTxtFld.getText() + "-" + dayTxtFld.getText());
//        if (a.validate() == false) {
//            JOptionPane.showMessageDialog(null, "Input Validation Error");
//            return;
//        }
//        if (database.update(a) == false) {
//            JOptionPane.showMessageDialog(null, "Database Error message");
//            return;
//        }
//        selectedRow = -1;
//        model.setAnimals(animals);
//        model.fireTableDataChanged();
//        typeCombo.setSelectedIndex(0);
//        sterilizedCombo.setSelectedIndex(0);
//        nameTxtFld.setText("");
//        pathTxtField.setText("");
//        yearTxtFld.setText("");
//        dayTxtFld.setText("");
//        monthTxtFld.setText("");
    }// GEN-LAST:event_modifyBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteBtnActionPerformed
//        if (selectedRow < 0)
//            return;
//
        String name = nameTxtFld.getText();
        String path = pathTxtField.getText();
//        Filess a = new Filess(
        System.out.println(filelist.findAtPosition(filelist,selectedRow));
//
        int des;
        des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this file?", "Deletion Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (des == 0) {
            // this mean that the user click the yes option
            // Put your code here that you want to execute when the user click the yes
            // option
//            try {
////                animals.remove(selectedRow);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                JOptionPane.showMessageDialog(null, "Input Validation Error message");
//                return;
//            }
//            if (database.delete(a) == false) {
//                JOptionPane.showMessageDialog(null, "Database Error message");
//                return;
//            }
//            selectedRow = -1;
//            model.setAnimals(animals);
//            model.fireTableDataChanged();
//            typeCombo.setSelectedIndex(0);
//            sterilizedCombo.setSelectedIndex(0);
//            nameTxtFld.setText("");
//            breedTxtFld.setText("");
//            yearTxtFld.setText("");
//            dayTxtFld.setText("");
//            monthTxtFld.setText("");
//        } else {
//
//            // in this else condition this is the no option
//            // in this block you can leave it empty if you don’t want to display some
//            // message to user
//        }
    }// GEN-LAST:event_deleteBtnActionPerformed
    }

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }// GEN-LAST:event_exitBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addBtnActionPerformed
//        String date = (yearTxtFld.getText() + "-" + monthTxtFld.getText() + "-" + dayTxtFld.getText());
//        String sterilizedValue = sterilizedCombo.getSelectedItem().toString();
//        String type = typeCombo.getSelectedItem().toString();
//        String name = nameTxtFld.getText();
//        String breed = breedTxtFld.getText();
//
//        if (type.contains("Dog")) {
//            Dog dog = new Dog(breed, name, sterilizedValue == "Yes" ? true : false, date);
//            if (dog.validate() == false) {
//                JOptionPane.showMessageDialog(null, "Input Validation Error message");
//                return;
//            }
//            if (database.add(dog) == false) {
//                JOptionPane.showMessageDialog(null, "Database Error message");
//                return;
//            }
//            animals.add(dog);
//        } else if (type.contains("Cat")) {
//            Cat cat = new Cat(breed, name, sterilizedValue == "Yes" ? true : false, date);
//            if (cat.validate() == false) {
//                JOptionPane.showMessageDialog(null, "Input Validation Error message");
//                return;
//            }
//            if (database.add(cat) == false) {
//                JOptionPane.showMessageDialog(null, "Database Error message");
//                return;
//            }
//            animals.add(cat);
//        }
//        selectedRow = -1;
//        model.setAnimals(animals);
//        model.fireTableDataChanged();
//        typeCombo.setSelectedIndex(0);
//        sterilizedCombo.setSelectedIndex(0);
//        nameTxtFld.setText("");
//        breedTxtFld.setText("");
//        yearTxtFld.setText("");
//        dayTxtFld.setText("");
//        monthTxtFld.setText("");

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
    // End of variables declaration//GEN-END:variables
}
