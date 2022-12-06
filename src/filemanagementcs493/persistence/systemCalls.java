/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493.persistence;

import filemanagementcs493.application.Filess;
import filemanagementcs493.utils.LinkedList;
import static filemanagementcs493.utils.LinkedList.insert;
import static filemanagementcs493.utils.utils.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;


/**
 *
 * @author gavon
 */
public class systemCalls implements SystemInterface{
    private final LinkedList filelist = new LinkedList();
    private fileDao database = new fileDao();



    public systemCalls() {
        
    }           

    @Override
    public LinkedList getAll(Object item)
    {
         String itemDeconstructed[];
        // deconstruct the object into an array
        itemDeconstructed = item.toString().split(" ");
 
        try {
            File currentDir = new File(itemDeconstructed[2]);
            File[] files = currentDir.listFiles();
 
            // For-each loop for iteration
            for (File file : files) {
 
                // Checking of file inside directory
                if (file.isDirectory()) {
 
//                    // Display directories inside directory
//                    System.out.println(
//                        "directory:"
//                        + file.getCanonicalPath());
//                    displayDirectory(file);
        Filess filess = new Filess(file.getName(), file.getCanonicalPath(),String.format("%,d", file.length()), getFileCreationTime(file).toString());
        database.add(filess);
//LinkedList.insert(filelist, filess);
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

        return filelist;
    }
    

    @Override
    public boolean add(Object item) {
    boolean value = false;
    File theDir = new File("C:\\Users\\gavon\\help");
    if (!theDir.exists()){
        value = theDir.mkdir();
        Filess filess = new Filess("help", "C:\\Users\\gavon\\help",  getFileSizeBytes(theDir),getFileCreationTime(theDir).toString());
        database.add(filess);
    }        System.out.println(String.valueOf(theDir.length()));
    
        return value;
    }

    @Override
    public boolean update(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object item) {
            File theDir = new File("C:\\Users\\gavon\\help");
            Filess filess = new Filess("help", "C:\\Users\\gavon\\help", "27.3GB", "created");
            // function to delete subdirectories and files
        // store all the paths of files and folders present
        // inside directory
        try{
            for (File subfile : theDir.listFiles()) {
  
            // if it is a subfolder,e.g Rohan and Ritik,
            // recursiley call function to empty subfolder
            if (subfile.isDirectory()) {
                delete(subfile);
            }
  
            // delete files and empty subfolders
            subfile.delete();
            }
            database.delete(filess);
        }catch(NullPointerException e){
                 return theDir.delete();
                }
    return theDir.delete();
    
    }
    
   
}
