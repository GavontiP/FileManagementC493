package filemanagementcs493.application;

import java.util.ArrayList;
import java.sql.*; // Needed for DB server operations
import java.util.*; // Needed for the ArrayList ADT

public class directory implements crud {

    private Statement statement = null;
    private Connection connection = null;
    private ResultSet result = null;

    directory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filemanagement", "cs493",
                    "p@sswordCS493");
            statement = connection.createStatement();
            System.out.println("connected to :mysql://localhost:3306/filemanagement");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public boolean create(Object item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Object item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Object item) {
        // TODO Auto-generated method stub
        return false;
    }

}
