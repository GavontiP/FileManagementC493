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
import java.awt.GridLayout;
import static java.nio.file.Files.delete;
import filemanagementcs493.utils.*;
import javax.swing.JFrame;

/**
 *
 * @author Gavonti Patton
 */
public class MainUI extends javax.swing.JFrame {
        private int selectedRow = 0;
        LinkedList filelist = new LinkedList();
        fileDao database = new fileDao();
        systemCalls systemint = new systemCalls();
            private FileTableModel model = new FileTableModel();
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        animalsTbl.setAutoCreateRowSorter(true);
        animalsTbl.getColumnModel().getColumn(0).setPreferredWidth(5);
        animalsTbl.getColumnModel().getColumn(2).setPreferredWidth(25);
        animalsTbl.getColumnModel().getColumn(3).setPreferredWidth(5);
        animalsTbl.getColumnModel().getColumn(4).setPreferredWidth(25);
        animalsTbl.getColumnModel().getColumn(1).setPreferredWidth(25);
        nameLbl.setDisplayedMnemonic('n');
        nameLbl.setLabelFor(nameTxtFld);
        breedLbl.setDisplayedMnemonic('b');
        breedLbl.setLabelFor(breedTxtFld);
        sterilizedLbl.setDisplayedMnemonic('s');
        sterilizedLbl.setLabelFor(sterilizedCombo);
        animalTypeLbl.setDisplayedMnemonic('t');
        animalTypeLbl.setLabelFor(typeCombo);
        dayLbl.setDisplayedMnemonic('d');
        dayLbl.setLabelFor(dayTxtFld);
        monthLbl.setDisplayedMnemonic('m');
        monthLbl.setLabelFor(monthTxtFld);
        yearLbl.setDisplayedMnemonic('y');
        yearLbl.setLabelFor(yearTxtFld);
        arrivalDateLbl.setDisplayedMnemonic('v');
        arrivalDateLbl.setLabelFor(dayTxtFld);
        exitMenuItem.setMnemonic('x');
        addBtn.setMnemonic('a');
        modifyBtn.setMnemonic('o');
        deleteBtn.setMnemonic('l');
        exitBtn.setMnemonic('e');
        fileMenuItem.setMnemonic('f');
        clearBtn.setMnemonic('c');

        // create new month focus listener
        monthTxtFld.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (monthTxtFld.getText().equals("MM")) // Default text is "MM"
                    monthTxtFld.selectAll(); // Select all text
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                // Do nothing when focus is lost
            }
        });

        // create new day focus listener
        dayTxtFld.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (dayTxtFld.getText().equals("DD")) // Default text is "MM"
                    dayTxtFld.selectAll(); // Select all text
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                // Do nothing when focus is lost
            }
        });

        // create new year focus listener
        yearTxtFld.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (yearTxtFld.getText().equals("YYYY")) // Default text is "MM"
                    yearTxtFld.selectAll(); // Select all text
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                // Do nothing when focus is lost
            }
        });
                
        int temp = database.getAll().getSize();
        for (int i = 0; i < temp; i++) {
            String itemDeconstructed[];
            String item = LinkedList.findAtPosition(database.getAll(), i);
            itemDeconstructed = item.split(" ");
            // setting local variables using the deconstructed object
            Filess file = new Filess(itemDeconstructed[1], itemDeconstructed[2], itemDeconstructed[3], itemDeconstructed[4]);
            LinkedList.insert(filelist,file);
            model.setAnimals(filelist);
            animalsTbl.setModel(model);
            model.fireTableDataChanged();
            animalsTbl.setColumnSelectionAllowed(false);
            animalsTbl.setRowSelectionAllowed(true);

        }
        animalsTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String date;
                String sterilized = "";
                String type = "";
                int row = animalsTbl.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selectedRow = row;
                    breedTxtFld.setText(model.getValueAt(row, 1).toString());
                    nameTxtFld.setText(model.getValueAt(row, 2).toString());
                    date = model.getValueAt(row, 4).toString();
                    yearTxtFld.setText(date.split("-")[0]);
                    monthTxtFld.setText(date.split("-")[1]);
                    dayTxtFld.setText(date.split("-")[2]);
                    sterilized = model.getValueAt(row, 3).toString();
                    if (sterilized.contains("true")) {
                        sterilizedCombo.setSelectedIndex(0);
                    } else {
                        sterilizedCombo.setSelectedIndex(1);

                    }
                    type = model.getValueAt(row, 0).toString();
                    if (type.contains("dog")) {
                        typeCombo.setSelectedIndex(0);
                    } else {
                        typeCombo.setSelectedIndex(1);

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
        animalsTbl = new javax.swing.JTable();
        breedTxtFld = new javax.swing.JTextField();
        nameTxtFld = new javax.swing.JTextField();
        breedLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        arrivalDateLbl = new javax.swing.JLabel();
        dayTxtFld = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        animalTypeLbl = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox<>();
        sterilizedCombo = new javax.swing.JComboBox<>();
        sterilizedLbl = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        titlelbl = new javax.swing.JLabel();
        monthTxtFld = new javax.swing.JTextField();
        yearTxtFld = new javax.swing.JTextField();
        dayLbl = new javax.swing.JLabel();
        monthLbl = new javax.swing.JLabel();
        yearLbl = new javax.swing.JLabel();
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
        setTitle("Regis ResQ");

        animalsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Type", "Breed", "Name", "Sterilized", "Arrived"
            }
        ));
        animalsTbl.setToolTipText("");
        jScrollPane1.setViewportView(animalsTbl);

        breedLbl.setText("Breed");

        nameLbl.setText("Name");

        arrivalDateLbl.setText("Arrival Date");

        dayTxtFld.setText("DD");
        dayTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTxtFldActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        animalTypeLbl.setText("Type of Animal");

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dog", "Cat" }));
        typeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboActionPerformed(evt);
            }
        });

        sterilizedCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        sterilizedLbl.setText("Sprayed/Neutred");

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

        titlelbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        titlelbl.setText("Regis ResQ");
        titlelbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        monthTxtFld.setText("MM");
        monthTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthTxtFldActionPerformed(evt);
            }
        });

        yearTxtFld.setText("YYYY");
        yearTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTxtFldActionPerformed(evt);
            }
        });

        dayLbl.setText("Day");

        monthLbl.setText("Month");

        yearLbl.setText("Year");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arrivalDateLbl)
                            .addComponent(animalTypeLbl)
                            .addComponent(sterilizedLbl)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dayTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(dayLbl)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(monthTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(monthLbl)
                                                .addGap(22, 22, 22)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(yearTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(clearBtn))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(yearLbl)))))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(typeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sterilizedCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLbl)
                            .addComponent(breedLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nameTxtFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(breedTxtFld))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(titlelbl)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlelbl)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(breedTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breedLbl))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayLbl)
                    .addComponent(monthLbl)
                    .addComponent(yearLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arrivalDateLbl)
                    .addComponent(clearBtn)
                    .addComponent(monthTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animalTypeLbl)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sterilizedLbl)
                    .addComponent(sterilizedCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_modifyBtnActionPerformed
//        if (selectedRow < 0)
//            return;
//
//        String date = (yearTxtFld.getText() + "-" + monthTxtFld.getText() + "-" + dayTxtFld.getText());
//        String sterilizedValue = sterilizedCombo.getSelectedItem().toString();
//        String type = typeCombo.getSelectedItem().toString();
//        String name = nameTxtFld.getText();
//        String breed = breedTxtFld.getText();
//        Animal a = animals.get(selectedRow);
//        a.setBreed(breedTxtFld.getText());
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
//        breedTxtFld.setText("");
//        yearTxtFld.setText("");
//        dayTxtFld.setText("");
//        monthTxtFld.setText("");
    }// GEN-LAST:event_modifyBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteBtnActionPerformed
//        if (selectedRow < 0)
//            return;
//
//        Animal a = animals.get(selectedRow);
//
//        int des;
//        des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this animal?", "Deletion Confirmation",
//                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//
//        if (des == 0) {
//            // this mean that the user click the yes option
//            // Put your code here that you want to execute when the user click the yes
//            // option
//            try {
//                animals.remove(selectedRow);
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

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_clearBtnActionPerformed
//        nameTxtFld.setText("");
//        breedTxtFld.setText("");
//        yearTxtFld.setText("YYYY");
//        dayTxtFld.setText("DD");
//        monthTxtFld.setText("MM");
    }// GEN-LAST:event_clearBtnActionPerformed

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
    private javax.swing.JLabel animalTypeLbl;
    private javax.swing.JTable animalsTbl;
    private javax.swing.JLabel arrivalDateLbl;
    private javax.swing.JLabel breedLbl;
    private javax.swing.JTextField breedTxtFld;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel dayLbl;
    private javax.swing.JTextField dayTxtFld;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuBar fileMenu;
    private javax.swing.JMenu fileMenuItem;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JLabel monthLbl;
    private javax.swing.JTextField monthTxtFld;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxtFld;
    private javax.swing.JComboBox<String> sterilizedCombo;
    private javax.swing.JLabel sterilizedLbl;
    private javax.swing.JLabel titlelbl;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JLabel yearLbl;
    private javax.swing.JTextField yearTxtFld;
    // End of variables declaration//GEN-END:variables
}
