package oosequence; 

import java.util.Date;

public class Flight {
	Date departure;
	Date arrival;
	
	public Flight(Date departure, Date arrival) {
		//if either argument or both is null, you can use the arguments to set the instance variables directly.
		if (departure == null && arrival == null) {
			this.departure = null;
			this.arrival = null;}
		
		else if (departure == null) {
			this.departure = null;
			this.arrival = new Date(arrival.getTime());}
		
		else if (arrival == null) {
			this.departure = new Date(departure.getTime());
			this.arrival = null;}
		
		//if neither argument is null, check that the argument for the departure is before the argument for the arrival. 
		else if (!(departure == null) && !(arrival == null)){
			if (departure.before(arrival)){
				this.departure= new Date(departure.getTime());
				this.arrival = new Date(arrival.getTime());
			}
		}
		else {
			this.departure = null;
			this.arrival = null;
		}
	}
		
	public Flight(Flight flight) {
		if (flight == null) {
			this.departure = null;
			this.arrival = null;
		}
		else {
			if(flight.departure == null) {
				this.departure = null;}
			else{
				this.departure = new Date(flight.departure.getTime());}
			
			if (flight.arrival == null) {
				this.arrival = null;
		}
			else{
				this.arrival = new Date(flight.arrival.getTime());
		}}
	}
	public long length() {
		if (departure == null || arrival == null) {
			return 0;
		}
		else {
			return (arrival.getTime() - departure.getTime()) / (1000 * 60);
		}
	}

}



