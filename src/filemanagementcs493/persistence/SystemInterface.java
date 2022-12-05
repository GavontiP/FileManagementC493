/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493.persistence;

import filemanagementcs493.utils.LinkedList;

/**
 *
 * @author gavon
 * @param <T>
 */
public interface SystemInterface<T> {

    public LinkedList getAll(T item);

    public boolean add(T item);

    public boolean update(T item);

    public boolean delete(T item);
}
