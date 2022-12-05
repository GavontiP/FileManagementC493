package filemanagementcs493.application;

import java.util.ArrayList;
import java.sql.*; // Needed for DB server operations


public class Files extends crud {

    public Files() {
        super(null, null, null, null,null);
        type = "file";
    }

    public Files(String location, String size, String contains, String created,String name) {
        super(location, size, contains, created,name);
        type = "file";
    }

}
