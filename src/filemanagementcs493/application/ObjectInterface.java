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
        if (type == "" || location == "" || size == "" || created == "") {
            returnValue = false;
        }
        // if (!dateArrived.matches("\\d{4}-\\d{2}-\\d{2}")) {
        // returnValue = false;
        // } else {
        // year = Integer.parseInt(dateArrived.substring(0, 4));
        // }
        // // validate the date entered
        // switch (Integer.parseInt(dateArrived.substring(6, 7))) {
        // case (1):
        // if (dateArrived.substring(5, 5) == "1") {
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 30
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // } else {
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 31
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // }
        // }
        // break;
        // case (2):
        // if (dateArrived.substring(5, 5) == "1") {
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 31
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // } else {
        // // three conditions to find out the leap year
        // if ((0 == year % 4) && (0 != year % 100) || (0 == year % 400)) {
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 29
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // } else {
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 28
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // }
        //
        // }
        //
        // break;
        // case (3):
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 31
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // break;
        // case (4):
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 30
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // break;
        // case (5):
        // System.out.println("May: " + dateArrived.substring(8, 10));
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 31
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // break;
        // case (6):
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 30
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // break;
        // case (7):
        // if (Integer.parseInt(dateArrived.substring(8, 10)) > 31
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // break;
        // case (8):
        // if (Integer.parseInt(dateArrived.substring(8, 9)) > 31
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // break;
        //
        // case (9):
        // if (Integer.parseInt(dateArrived.substring(8, 9)) > 31
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // break;
        // case (0):
        // if (Integer.parseInt(dateArrived.substring(8, 9)) > 31
        // || Integer.parseInt(dateArrived.substring(8, 10)) < 1) {
        // returnValue = false;
        // }
        // break;
        // }
        // } catch (Exception e) {
        // returnValue = false;
        // }
        // System.out.println(toString());
        return returnValue;
    }
}
