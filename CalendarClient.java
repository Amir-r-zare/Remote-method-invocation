// import Statements
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

// Create the Client Application
public class CalendarClient {
    public static void main(String[] args) {
        try {

            // Locate the RMI registry
            Registry registry = LocateRegistry.getRegistry("172.23.153.16", 1099); // Adjust host and port as needed

            /*
            Look up the remote object (EventCalendar).
            This line looks up the remote Calendar object from the RMI registry.
            It uses the registry.lookup method to obtain a reference to the remote
            object identified by the RMI name "EventCalendar"
            */
            CalendarInterface calendar = (CalendarInterface) registry.lookup("EventCalendar");

            // Use the calendar methods (examples from previous messages)
            Event event1 = new Event("Meeting",
                    new Date(),
                    60,
                    "Team Meeting",
                    "Discuss project updates",
                    "Conference Room A"
            );
            calendar.addEvent(event1);
            System.out.println("Event added: " + event1.getName());

            String eventNameToRemove = "Meeting";
            calendar.removeEvent(eventNameToRemove);
            System.out.println("Event '" + eventNameToRemove + "' removed successfully.");

            String eventNameToRetrieve = "Meeting";
            List<Event> eventsByName = calendar.getEventsByName(eventNameToRetrieve);
            System.out.println("Events with name '" + eventNameToRetrieve + "':");
            for (Event event : eventsByName) {
                System.out.println(event.getName() + " - " + event.getDateTime());
            }

            // Similar usage for other methods...

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
}
