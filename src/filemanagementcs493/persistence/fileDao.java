package filemanagementcs493.persistence;

import filemanagementcs493.application.*; // Needed for the domain classes
import java.sql.*; // Needed for DB server operations
import filemanagementcs493.utils.LinkedList; // Needed for the ArrayList ADT

/**
 *
 * @author gavon
 */
public class fileDao implements Dao {
    private LinkedList filelist = new LinkedList();
    private Statement statement = null;
    private Connection connection = null;
    private ResultSet result = null;
    private String tableName = "directory7";

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
                if (result.getString(2).equals("file")) {
                    FileClass file = new FileClass(result.getString(3), result.getString(4),result.getString(5),result.getString(1));
                    filelist.insert(filelist, file);
                } else {
                    DirectoryClass file = new DirectoryClass(result.getString(3), result.getString(4),result.getString(5),result.getString(1));
                    filelist.insert(filelist, file);
                }

            }
        } catch (SQLException sqlException) {
            System.out.println("error: " + sqlException);
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
    public boolean add(ObjectInterface item) {
        boolean succesful = true;
        String query = " insert into " + tableName + " (type, name, location, size, created)"
                + " values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1, item.getType());
            myStmt.setString(2, item.getName());
            myStmt.setString(3, item.getLocation());
            myStmt.setString(4, item.getSize());
            myStmt.setString(5, item.getCreated());

            // Execute SQL query
            myStmt.execute();
        } catch (SQLException e) {
            succesful = false;
            System.out.println("SQL Exception: " + e);
        }
        return succesful;
    }

    @Override
    public boolean update(ObjectInterface item, int ID) {
        boolean succesful = true;
        String query = " update " + tableName + " set type = '" + item.getType() + "', name = '"
                + item.getName() + "', size = '" + item.getSize() + "', location = '" + item.getLocation() + "', created = '" + item.getCreated()
                + "' where ID = '" + ID + "';";
        try {
            // Execute SQL query
            if (statement.executeUpdate(query) == 0) {
                System.out.println("record not found to update");
                succesful = false;
            } else {
                System.out.println(item.getLocation() + " record found and updated");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
            succesful = false;
        }

        return succesful;
    }

    @Override
    public boolean delete(ObjectInterface item) {
        boolean succesful = true;
        String name = "";
        name = item.getName();

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
