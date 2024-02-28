// import Statements
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;

// Define the EventCalendar class that implements the CalendarInterface
public class EventCalendar extends UnicastRemoteObject implements CalendarInterface {
    // Maintain a list to store events
    private List<Event> events;

    // Constructor initializes the list when an instance is created
    public EventCalendar() throws RemoteException {
        super();
        this.events = new ArrayList<Event>();
    }

    // Implementation of adding an event to the calendar
    /*
    This method adds a new event to the calendar.
    The Event object passed as a parameter is added to
    the events list, and a message is printed to
    indicate that the event has been successfully added.
    */
    @Override
    public void addEvent(Event event) throws RemoteException {
        events.add(event);
    }

    // Implementation of removing an event by name
    /*
    This method removes an event from the calendar based
    on its name. It searches for an event with the
    specified name in the events list. If found,
    the event is removed; otherwise, a message is
    printed indicating that the event was not found.
    */
    @Override
    public void removeEvent(String eventName) throws RemoteException {
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();
            if (event.getName().equals(eventName)) {
                iterator.remove();
            }
        }
    }

    // Implementation of retrieving events by name
    /*
    This method retrieves a list of events with a specified
    name from the calendar. It iterates through the events list,
    and for each event that matches the provided name,
    it adds that event to the result list. The result
    is a list of events with the specified name.
    */
    @Override
    public List<Event> getEventsByName(String eventName) throws RemoteException {
        List<Event> result = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getName().equals(eventName)) {
                result.add(event);
            }
        }
        return result;
    }

    // Implementation of retrieving events by type
    /*
    This method retrieves a list of events with a specified
    type from the calendar. Similar to retrieveEventsByName,
    it iterates through the events list, adding events
    with the specified type to the result list.
    */
    @Override
    public List<Event> getEventsByType(String eventType) throws RemoteException {
        List<Event> result = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getType().equals(eventType)) {
                result.add(event);
            }
        }
        return result;
    }

    // Implementation of retrieving events by date (modify as needed)
    /*
    This method retrieves a list of events for a specified
    date from the calendar. It iterates through
    the events list, adding events that match the provided
    date to the result list.
    */
    @Override
    public List<Event> getEventsByDate(String date) throws RemoteException {
        List<Event> result = new ArrayList<Event>();
        for (Event event : events) {
            // Your existing date-related logic
            // Modify this part based on your requirements
        }
        return result;
    }

    // Implementation of retrieving events by location
    /*
    This method retrieves a list of events for a specified
    Location from the calendar. It iterates through
    the events list, adding events that match the provided
    Location to the result list.
    */
    @Override
    public List<Event> getEventsByLocation(String location) throws RemoteException {
        List<Event> result = new ArrayList<Event>();
        for (Event event : events) {
            if (event.getLocation().equals(location)) {
                result.add(event);
            }
        }
        return result;
    }

    // Implementation of retrieving events for a given month and year (modify as needed)
    /*
    This method is a placeholder that needs to be implemented.
    The idea is to retrieve a list of events for a given
    month and year from the calendar. The implementation will
    require additional logic to filter events based on the month and year.
    */
    @Override
    public List<Event> getEventsForMonthAndYear(int month, int year) throws RemoteException {
        List<Event> result = new ArrayList<Event>();
        return result;
    }
}
