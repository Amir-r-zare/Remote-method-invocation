// import Statements
import java.io.Serializable;
import java.util.Date;

// Event class

/*
The overall idea in the Event class is to encapsulate the attributes of
an event and provide methods to access and modify these attributes.
The constructor initializes an event with specific attributes,
and the getter and setter methods allow for the retrieval
and modification of individual attributes. This follows
the principles of encapsulation in object-oriented programming,
where the internal details of an object are hidden, and interactions
occur through well-defined interfaces (methods).
*/

public class Event implements Serializable {
    private String type;
    private Date dateTime;
    private int length;
    private String name;
    private String description;
    private String location;

    // Constructor
    /*
    This is the constructor of the Event class. It initializes
    an Event object with the provided parameters: type, dateTime,
    length, name, description, and location. The constructor
    is responsible for setting the initial values of these
    attributes when a new Event object is created.
    */

    public Event(String type, Date dateTime, int length, String name, String description, String location) {
        this.type = type;
        this.dateTime = dateTime;
        this.length = length;
        this.name = name;
        this.description = description;
        this.location = location;
    }


    // Getters and Setters

    /*
    This is a getter method for the 'type' attribute of
    the Event class. It returns the type of the event.
    */
    public String getType() {
        return type;
    }

    /*
    This is a setter method for the 'type' attribute of the Event class.
    It allows the type of the event to be set or updated.
    */
    public void setType(String type) {
        this.type = type;
    }

    /*
    This is a getter method for the 'dateTime' attribute of the Event class.
    It returns the date and time of the event.
    */
    public Date getDateTime() {
        return dateTime;
    }

    /*
    This is a setter method for the 'dateTime' attribute of the Event class.
    It allows the date and time of the event to be set or updated.
    */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /*
    This is a getter method for the 'length' attribute of the Event class.
    It returns the length (duration) of the event.
    */
    public int getLength() {
        return length;
    }

    /*
    This is a setter method for the 'length' attribute of the Event class.
    It allows the length of the event to be set or updated.
    */
    public void setLength(int length) {
        this.length = length;
    }

    /*
    This is a getter method for the 'name' attribute of
    the Event class. It returns the name of the event.
    */
    public String getName() {
        return name;
    }

    /*
    This is a setter method for the 'name' attribute of the Event class.
    It allows the name of the event to be set or updated.
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    This is a getter method for the 'description' attribute of the Event class.
    It returns the description of the event.
    */
    public String getDescription() {
        return description;
    }

    /*
    This is a setter method for the 'description' attribute of the Event class.
    It allows the description of the event to be set or updated.
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
    This is a getter method for the 'location' attribute of the Event class.
    It returns the location of the event.
    */
    public String getLocation() {
        return location;
    }

    /*
    This is a setter method for the 'location' attribute of the Event class.
    It allows the location of the event to be set or updated.
    */
    public void setLocation(String location) {
        this.location = location;
    }
}
