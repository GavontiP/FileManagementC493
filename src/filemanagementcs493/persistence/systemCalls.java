/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493.persistence;

import filemanagementcs493.application.DirectoryClass;
import filemanagementcs493.application.FileClass;
import filemanagementcs493.application.ObjectInterface;
import filemanagementcs493.application.LinkedList;
import static filemanagementcs493.application.utils.*;
import java.awt.Desktop;
import java.io.File;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gavon
 */
public class systemCalls implements SystemInterface {
    private final fileDao database = new fileDao();

    public systemCalls() {

    }

    @Override
    public LinkedList getAll(File folder) {
        LinkedList filedlist = new LinkedList();
        try {
            File[] files = folder.listFiles();

            // For-each loop for iteration
            for (File file : files) {

                // Checking of file inside directory
                if (file.isDirectory()) {
                    DirectoryClass dir = new DirectoryClass(file.getCanonicalPath(),
                            String.format("%,d", file.length()).replace(",", ""), getFileCreationTime(file).toString(),
                            file.getName());
                    database.add(dir);
                    filedlist.insert(filedlist, dir);

                }
                // // Simply get the path
                else if (file.isFile()) {
                    FileClass filess = new FileClass(file.getCanonicalPath(),
                            String.format("%,d", file.length()).replace(",", ""), getFileCreationTime(file).toString(),
                            file.getName());
                    database.add(filess);
                    filedlist.insert(filedlist, filess);
                }
            }
        }

        // if any exceptions occurs printStackTrace
        catch (IOException | NullPointerException e) {
            System.out.println(e);
        }

        return filedlist;
    }

    @Override
    public boolean add(ObjectInterface item) {
        boolean value = true;
        File theDir = new File(item.getLocation());
        if (!theDir.exists()) {
            if (item.getType().equals("file")) {
                try {
                    theDir.createNewFile();
                } catch (IOException ex) {
                    value = false;
                    Logger.getLogger(systemCalls.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                value = theDir.mkdir();
            }
        }
        return value;
    }

    @Override
    public boolean update(ObjectInterface item, String newName) {
        // Create an object of the File class
        // Replace the file path with path of the directory
        File file = new File(item.getLocation());
        // Create an object of the File class
        // Replace the file path with path of the directory
        File rename = new File(newName);

        // store the return value of renameTo() method in
        // flag
        System.out.println(file);
        System.out.println(rename);
        boolean flag = file.renameTo(rename);

        // if renameTo() return true then if block is
        // executed
        if (flag == true) {
            System.out.println("File Successfully Rename");
        }
        // if renameTo() return false then else block is
        // executed
        else {
            System.out.println("Operation Failed");
        }
        return flag;
    }

    @Override
    public boolean delete(ObjectInterface item) {
        File theDir = new File(item.getLocation());
        boolean value = true;
        if (!("file".equals(item.getType()))) {
            try {
                FileUtils.deleteDirectory(theDir);
            } catch (NullPointerException e) {
                value = false;
            } catch (IOException ex) {
                value = false;
                Logger.getLogger(systemCalls.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                value = theDir.delete();
            } catch (NullPointerException e) {
                return theDir.delete();
            }
        }
        return value;

    }

    public void findFile(String name, File file) {
        try{
             File[] list = file.listFiles();
        if (list != null)
            for (File fil : list) {
                if (name.equalsIgnoreCase(fil.getName())) {
                 if (fil.isDirectory())
                 {
                 //TODO
                 }else if(fil.isFile()){
                                         try {
                        if (!Desktop.isDesktopSupported())// check if Desktop is supported by Platform or not
                        {
                            System.out.println("not supported");
                            return;
                        }
                        Desktop desktop = Desktop.getDesktop();
                        if (fil.exists()) // checks file exists or not
                            desktop.open(fil); // opens the specified file
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                 }
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

}
