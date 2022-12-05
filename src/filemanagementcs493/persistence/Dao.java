package filemanagementcs493.persistence;


import filemanagementcs493.utils.*;

public interface Dao<T> {

    public LinkedList getAll();

    public boolean add(T item);

    public boolean update(T item);

    public boolean delete(T item);
}
