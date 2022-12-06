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
            result = statement.executeQuery("select * from directory2");
            // Iterate through all rows and add the values from each into the animals
            // ArrayList
            while (result.next()) {
//                if (tempSterilized == 1) {
//                    if (breed.contains("dog")) {
                        Filess file = new Filess(result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                        LinkedList.insert(filelist,file);
//                    } else if (breed.contains("cat")) {
//                        Cat cat = new Cat(result.getString(2), result.getString(3), true, result.getString(5));
//                        animals.add(cat);
//                    }
//                } else if (tempSterilized == 0) {
//                    if (breed.contains("dog")) {
//                        Dog dog = new Dog(result.getString(2), result.getString(3), false, result.getString(5));
//                        animals.add(dog);
//                    } else if (breed.contains("cat")) {
//                        Cat cat = new Cat(result.getString(2), result.getString(3), false, result.getString(5));
//                        animals.add(cat);
//                    }
//                }
            }
        } catch (SQLException sqlException) {
            System.out.println("error: " + sqlException.getMessage());
        }
        return filelist;
    }

    @Override
    public boolean add(Object item) {
        boolean succesful = true;
        String itemDeconstructed[];
        // deconstruct the object into an array
        itemDeconstructed = item.toString().split(" ");
        // formatting the mysql query string
        String query = " insert into directory2 (type, name, location, size, created)"
                + " values (?, ?, ?, ?, ?)";
        try {
            // Prepare Statement
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1, itemDeconstructed[1]);
            myStmt.setString(2, itemDeconstructed[5]);
            myStmt.setString(3, itemDeconstructed[2]);
            myStmt.setString(4, itemDeconstructed[3]);
            myStmt.setString(5, itemDeconstructed[4]);
            // Execute SQL query
            myStmt.execute();
            System.out.println(itemDeconstructed[1]);
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
        String query = " update directory2 set type = '" + itemDeconstructed[1] + "', location = '" + itemDeconstructed[2] + "', size = '" + itemDeconstructed[3]+ "', created = '" + itemDeconstructed[5] + "' where name = '" + itemDeconstructed[6] + "';";
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
            System.out.println(e);
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
        String query = " delete from directory2 where name = '" + name + "'";
        try {
            // Execute SQL query
            if (statement.executeUpdate(query) == 0) {
                System.out.println("record not found to delete");
                succesful = false;
            } else {
                System.out.println(name + " record found and deleted");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return succesful;
    }



}
