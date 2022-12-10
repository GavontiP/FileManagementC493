package filemanagementcs493.application;

public class DirectoryClass extends ObjectInterface {

    public DirectoryClass() {
        super(null, null, null, null);
        type = "directory";
    }

    public DirectoryClass(String location, String size, String created, String name) {
        super(location, size, created, name);
        type = "directory";
    }

}
