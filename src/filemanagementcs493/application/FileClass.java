package filemanagementcs493.application;

public class FileClass extends ObjectInterface {

    public FileClass() {
        super(null, null, null, null);
        type = "file";
    }

    public FileClass(String location, String size, String created, String name) {
        super(location, size, created, name);
        type = "file";
    }

}
