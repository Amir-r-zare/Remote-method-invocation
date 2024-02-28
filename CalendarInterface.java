// import Statements
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Define the Calendar interface that extends Remote Class.
public interface CalendarInterface extends Remote {

    // Method to add an event
    void addEvent(Event event) throws RemoteException;

    // Method to remove an event by name
    void removeEvent(String eventName) throws RemoteException;

    // Method to retrieve events by name
    List<Event> getEventsByName(String eventName) throws RemoteException;

    // Method to retrieve events by type
    List<Event> getEventsByType(String eventType) throws RemoteException;

    // Method to retrieve events by Date
    List<Event> getEventsByDate(String date) throws RemoteException;

    // Method to retrieve events by Location
    List<Event> getEventsByLocation(String location) throws RemoteException;

    // Method to retrieve events for a given month and year
    List<Event> getEventsForMonthAndYear(int month, int year) throws RemoteException;
}
