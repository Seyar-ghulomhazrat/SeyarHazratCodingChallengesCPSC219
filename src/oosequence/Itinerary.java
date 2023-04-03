package oosequence;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Itinerary {
	//encapsulating the instance variables
    private ArrayList<TripComponent> flights;
    private String name;

    public Itinerary(String name) {
    	//set the name and arraylist (instances)
        this.name = name;
        this.flights = new ArrayList<TripComponent>();
    }
    
    //getter method for each instance variable
    public String getName() {
        return name;
    }
    
    public ArrayList<TripComponent> getFlights() {
    	//return flights instance variable
        return flights;
    }

    public void addFlight(TripComponent flight) {
    	
    	//adds one to the end of list, then sorts flights
        flights.add(flight);
        flights.sort(Comparator.comparing(TripComponent::getStart));
        
        // remove any flights with overlapping time
        List<TripComponent> secondFlight = new ArrayList<>();
        TripComponent finalFlight = null;
        
        for (TripComponent f : flights) {
            if (finalFlight == null || f.getStart().after(finalFlight.getEnd())) {
                secondFlight.add(f);
                finalFlight = f;
            }
        }
        flights = (ArrayList<TripComponent>) secondFlight;
    }



    public long getTotalLayover() {
        long totalLayover = 0;
        for (int i = 0; i < flights.size() - 1;) {
            totalLayover += flights.get(i + 1).getStart().getTime() - flights.get(i).getEnd().getTime();
            i+=1;
        }
        return totalLayover / (1000 * 60);
    }
}


