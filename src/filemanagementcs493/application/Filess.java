package filemanagementcs493.application;

public class Filess extends source {

    public Filess() {
        super(null, null, null, null);
        type = "file";
    }

    public Filess(String location, String size, String created, String name) {
        super(location, size, created, name);
        type = "file";
    }

}
