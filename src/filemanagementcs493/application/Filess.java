package filemanagementcs493.application;

import java.util.ArrayList;
import java.sql.*; // Needed for DB server operations


public class Filess extends crud {

    public Filess() {
        super(null, null, null, null);
        type = "file";
    }

    public Filess(String location, String size, String created,String name) {
        super(location, size, created,name);
        type = "file";
    }

}
