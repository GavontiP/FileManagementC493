package filemanagementcs493.persistence;

import filemanagementcs493.application.Filess;
import filemanagementcs493.application.source;
import filemanagementcs493.utils.*;

public interface Dao<T> {

    public LinkedList getAll();

    public boolean add(source item);

    public boolean update(source item);

    public boolean delete(source item);
}
