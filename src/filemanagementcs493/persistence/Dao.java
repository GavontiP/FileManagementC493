package filemanagementcs493.persistence;

import filemanagementcs493.application.LinkedList;
import filemanagementcs493.application.ObjectInterface;

public interface Dao<T> {

    public LinkedList getAll();

    public boolean add(ObjectInterface item);

    public boolean update(ObjectInterface item, int ID);

    public boolean delete(ObjectInterface item);
}
