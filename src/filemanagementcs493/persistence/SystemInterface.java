/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493.persistence;

import filemanagementcs493.application.source;
import filemanagementcs493.utils.LinkedList;
import java.io.File;

/**
 *
 * @author gavon
 * @param <T>
 */
public interface SystemInterface<T> {

    public LinkedList getAll(File item);

    public boolean add(source item);

    public boolean update(source item);

    public boolean delete(source item);
}
