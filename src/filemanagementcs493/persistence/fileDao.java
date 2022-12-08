package filemanagementcs493.persistence;

import filemanagementcs493.application.*; // Needed for the domain classes
import java.sql.*; // Needed for DB server operations
import filemanagementcs493.utils.LinkedList; // Needed for the ArrayList ADT
import java.util.Arrays;

/**
 *
 * @author gavon
 */
public class fileDao implements Dao {
    private LinkedList filelist = new LinkedList();
    private Statement statement = null;
    private Connection connection = null;
    private ResultSet result = null;
    private String tableName = "directory3";


    public fileDao() {
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
    public LinkedList getAll() {
        try {
            // Exceute a select SQL command on the adoptable pets table in the animals
            // database
            result = statement.executeQuery("select * from " + tableName + "");
            // Iterate through all rows and add the values from each into the animals
            // ArrayList
            while (result.next()) {
                        Filess file = new Filess(result.getString(1), result.getString(5),result.getString(4), result.getString(3));
                        filelist.insert(filelist,file);
            }
        } catch (SQLException sqlException) {
            System.out.println("error: " + sqlException.getMessage());
        }
        return filelist;
    }
    
    public void deleteAll() {
        try {
            // Exceute a select SQL command on the adoptable pets table in the animals
            // database
             statement.execute("DELETE FROM " + tableName + "");

        } catch (SQLException sqlException) {
            System.out.println("error: " + sqlException.getMessage());
        }
    }


    @Override
    public boolean add(Object item) {
        boolean succesful = true;
        String itemDeconstructed[];
        // deconstruct the object into an array
        itemDeconstructed = item.toString().split(" ");
        // formatting the mysql query string
        String query = " insert into " + tableName + " (type, name, location, size, created)"
                + " values (?, ?, ?, ?, ?)";
        try {
            // Prepare Statement
            PreparedStatement myStmt = connection.prepareStatement(query);
            // setting local variables using the deconstructed object
            switch (itemDeconstructed.length) {
                case 7:
                    myStmt.setString(1, itemDeconstructed[0]);
                    myStmt.setString(2, itemDeconstructed[2] + " "  + itemDeconstructed[1]);
                    myStmt.setString(3, itemDeconstructed[3] + " " + itemDeconstructed[2]);
                    myStmt.setString(5, itemDeconstructed[6]);
                    myStmt.setString(4, itemDeconstructed[5]);
                    break;
                case 5:
                    System.out.println(Arrays.toString(itemDeconstructed));
                    myStmt.setString(1, itemDeconstructed[0]);
                    myStmt.setString(2, itemDeconstructed[1]);
                    myStmt.setString(3, itemDeconstructed[2]);
                    myStmt.setString(4, itemDeconstructed[3]);
                    myStmt.setString(5, itemDeconstructed[4]);
                    break;
                default:
                    System.out.println("THIS LENGTH IS DIFFERENT!!!");
                    break;
            }
        
            // Execute SQL query
            if(myStmt.execute()){
                System.out.println("worked!!");
            }
        } catch (SQLException e) {
            succesful = false;
        System.out.println("SQL Exception: " + e);
        }
        return succesful;
    }

    @Override
    public boolean update(Object item) {
        boolean succesful = true;
        String itemDeconstructed[];
        // deconstruct the object into an array
        itemDeconstructed = item.toString().split(" ");

        // formatting the mysql query string
        String query = " update " + tableName + " set type = '" + itemDeconstructed[1] + "', location = '" + itemDeconstructed[2] + "', size = '" + itemDeconstructed[3]+ "', created = '" + itemDeconstructed[5] + "' where name = '" + itemDeconstructed[6] + "';";
        System.out.println(query);
        try {
            // Execute SQL query
            if (statement.executeUpdate(query) == 0) {
                System.out.println("record not found to update");
                succesful = false;
            } else {
                System.out.println( itemDeconstructed[6] + " record found and updated");
            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e);
        }

        return succesful;
    }

    @Override
    public boolean delete(Object item) {
         boolean succesful = true;
        String itemDeconstructed[];
        String name = "";
        // deconstruct the object into an array
        itemDeconstructed = item.toString().split(" ");
        // setting local variables using the deconstructed object
            name = itemDeconstructed[6];
        
        // formatting the mysql query string
        String query = " delete from " + tableName + " where name = '" + name + "'";
        try {
            // Execute SQL query
            if (statement.executeUpdate(query) == 0) {
                System.out.println("record not found to delete");
                succesful = false;
            } else {
                System.out.println(name + " record found and deleted");
            }
        } catch (Exception e) {
             System.out.println("SQL Exception: " + e);
        }

        return succesful;
    }



}
