/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagementcs493.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 *
 * @author gavon
 */
public class utils {
    public static String getFileSizeBytes(File file) {
		return file.length() + "bytes";
	}
     public static FileTime getFileCreationTime(File file) {
	try {
    BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
    FileTime fileTime = attr.creationTime();
    return attr.creationTime();
} catch (IOException ex) {
   return null;
}
     }
     
    
}
