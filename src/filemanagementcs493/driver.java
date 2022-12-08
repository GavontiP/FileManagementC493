/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template Files, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493;

import filemanagementcs493.persistence.*;
import filemanagementcs493.utils.*;
import filemanagementcs493.application.*;
import java.util.ArrayList;

/**
 *
 * @author gavon
 */
public class driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Object> t = new ArrayList<>();
        LinkedList filelist = new LinkedList();
        fileDao database = new fileDao();
        systemCalls systemint = new systemCalls();
        Filess fileclass = new Filess("help",state.currLocation, "27.3GB", "created");
        systemint.getAll(fileclass);
//        database.add(fileclass);
//        LinkedList.printList(database.getAll());
    }

}
