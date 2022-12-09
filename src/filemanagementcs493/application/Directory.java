package filemanagementcs493.application;

public class Directory extends source {

    public Directory() {
        super(null, null, null, null);
        type = "directory";
    }

    public Directory(String location, String size, String created, String name) {
        super(location, size, created, name);
        type = "directory";
    }

}
