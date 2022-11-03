package filemanagementcs493.application;

import java.util.*;

public interface crud<T> {

    public boolean create(T item);

    public ArrayList<T> read();

    public boolean update(T item);

    public boolean delete(T item);
}
