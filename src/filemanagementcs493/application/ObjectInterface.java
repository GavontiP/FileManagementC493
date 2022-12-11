package filemanagementcs493.application;

/**
 *
 * @author gavon
 */
public abstract class ObjectInterface {

    /**
     *
     */
    protected String type;

    /**
     *
     */
    protected String location;

    /**
     *
     */
    protected String size;

    /**
     *
     */
    protected String created;
    /**
    *
    */
    protected String name;

    public ObjectInterface(String location, String size, String created, String name) {
        this.location = location;
        this.size = size;
        this.created = created;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ObjectInterface() {

    }

    @Override
    public String toString() {
        return "source{" + "type=" + type + ", name=" + name + ", location=" + location + ", size=" + size
                + ", created=" + created + '}';
    }

    /**
     *
     * @return
     */
    public Boolean validate() {
        boolean returnValue = true;
        // try {
        if (type == null || location == null || size == null || created == null) {
            returnValue = false;
        }
        if ("".equals(type) || "".equals(location) || "".equals(size) || "".equals(created)) {
            returnValue = false;
        }
        return returnValue;
    }
}
