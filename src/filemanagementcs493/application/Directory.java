package filemanagementcs493.application;

import java.util.ArrayList;
import java.sql.*; // Needed for DB server operations


public class Directory extends crud {

    public Directory() {
        super(null, null, null, null,null);
        type = "directory";
    }

    public Directory(String location, String size, String contains, String created, String name) {
        super(location, size, contains, created, name);
        type = "directory";
    }

}
