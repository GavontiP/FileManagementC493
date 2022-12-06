/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493;

/**
 *
 * @author gavon
 */
public class state {
    public static String currLocation = "C:\\Users\\gavon";

    public static String getCurrLocation() {
        return currLocation;
    }

    public static void setCurrLocation(String currLocation) {
        state.currLocation = currLocation;
    }
    
}
