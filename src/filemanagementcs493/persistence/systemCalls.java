/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493.persistence;

import filemanagementcs493.application.Directory;
import filemanagementcs493.application.Filess;
import filemanagementcs493.application.source;
import filemanagementcs493.utils.LinkedList;
import static filemanagementcs493.utils.utils.*;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
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
    private final LinkedList filelist = new LinkedList();
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
                    Directory dir = new Directory(file.getCanonicalPath(), String.format("%,d", file.length()).replace(",", "") , getFileCreationTime(file).toString(),file.getName());
                    database.add(dir);
                    filedlist.insert(filedlist, dir);

                }
                // // Simply get the path
                else if (file.isFile()) {
                    Filess filess = new Filess(file.getCanonicalPath(), String.format("%,d", file.length()).replace(",", "") , getFileCreationTime(file).toString(),file.getName());
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
    public boolean add(source item) {
        boolean value = false;
        File theDir = new File(item.getLocation());
        // System.out.println(item.toString());
        if (!theDir.exists()) {

            if (item.getType().equals("file")) {
                try {
                    // System.out.println(theDir.toString());
                    theDir.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(systemCalls.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                value = theDir.mkdir();
            }
        }
        return value;
    }

    @Override
    public boolean update(source item) {
        // Create an object of the File class
        // Replace the file path with path of the directory
        File file = new File("/home/mayur/Folder/GFG.java");

        // Create an object of the File class
        // Replace the file path with path of the directory
        File rename = new File("/home/mayur/Folder/HelloWorld.java");

        // store the return value of renameTo() method in
        // flag
        boolean flag = file.renameTo(rename);

        // if renameTo() return true then if block is
        // executed
        if (flag == true) {
            System.out.println("File Successfully Rename");
            database.update(item);
        }
        // if renameTo() return false then else block is
        // executed
        else {
            System.out.println("Operation Failed");
        }
        return flag;
    }

    @Override
    public boolean delete(source item) {
        File theDir = new File(item.getLocation());
        // function to delete subdirectories and files
        // store all the paths of files and folders present
        // inside directory
        if (!("file".equals(item.getType()))) {
            try {
                FileUtils.deleteDirectory(theDir);
            } catch (NullPointerException e) {
                return theDir.delete();
            } catch (IOException ex) {
                Logger.getLogger(systemCalls.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (theDir.delete()) {
                    System.out.println("Deleted the file: " + theDir.getName());
                } else {
                    System.out.println("Failed to delete the file.");
                }
            } catch (NullPointerException e) {
                return theDir.delete();
            }
        }
        return theDir.delete();

    }

}
