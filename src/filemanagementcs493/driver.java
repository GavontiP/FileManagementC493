/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template Files, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493;

import filemanagementcs493.persistence.*;
import java.awt.GridLayout;
import filemanagementcs493.utils.*;
import filemanagementcs493.application.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author gavon
 */
public class driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList filelist = new LinkedList();
        final JFrame jf = new JFrame("Test");
        jf.setLayout(new GridLayout(0, 1));
        fileDao database = new fileDao();
        systemCalls systemint = new systemCalls();
        Files fileclass = new Files("help", "C:\\Users\\gavon", "27.3GB",  "contains", "created");
        LinkedList.insert(filelist, fileclass);
//        database.delete(fileclass);
//        Files fileclass2 = new Files("one","two","three","four","five");
//        file.add(fileclass2);
//        LinkedList gfg = database.getAll();
        systemint.getAll(fileclass);
        LinkedList.printList(database.getAll());
//        systemint.add(fileclass);
//        LinkedList.printList(database.getAll());
        System.out.println(systemint.delete(fileclass));
        LinkedList.printList(database.getAll());
         // Creating object of class File where
        // Dot represents the current directory
        // jf.add(new JButton(new AbstractAction("Click to add") {
        // @Override
        // public void actionPerformed(ActionEvent e) {
//        for (int i = 0; i < gfg.size(); i++) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jf.add(new JLabel(LinkedList.findAtPosition(filelist,4)));
                    jf.validate();
                    jf.repaint();
                }
                // });
                // }
            });

//        }
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 300);
        jf.setVisible(true);
    } // Function displaying all the directories
    // present in the directory
    public static void displayDirectory(File dir)
    {
 
        try {
            File[] files = dir.listFiles();
 
            // For-each loop for iteration
            for (File file : files) {
 
                // Checking of file inside directory
                if (file.isDirectory()) {
 
                    // Display directories inside directory
                    System.out.println(
                        "directory:"
                        + file.getCanonicalPath());
//                    displayDirectory(file);
                }
 
//              // Simply get the path
//                else {
//                    System.out.println(
//                        "     file:"
//                        + file.getCanonicalPath());
//                }
            }
        }
 
        // if any exceptions occurs printStackTrace
        catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    

}
