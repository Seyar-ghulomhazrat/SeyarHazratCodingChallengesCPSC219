package oosequence;

import java.util.Date;

public class Flight {
	Date arrive;
	Date depart;
	
	public Flight(Date depart, Date arrive){
		//If either argument (or both) is null, you can use the arguments to set the instance variables directly
		if (arrive == null && depart == null) {
			//then flight is null
			this.depart = null;
			this.arrive = null;
		}
		if (depart == null) {
			//can set arrival in condition
			this.depart = null;
			this.arrive = new Date(arrive.getTime());
		}
		if (arrive == null) {
			//can set depart in condition
			this.depart = new Date (depart.getTime());
			this.arrive = null;
		}
		// check if departure is prior to arrival
		if (depart.before(arrive)) {
			this.depart = new Date (depart.getTime());
			this.arrive = new Date (arrive.getTime());
		}
		//else invalid flight
		else {
			this.depart = null;
			this.arrive = null;
		}
		
	}
	
	public Flight(Flight flight) {
		
	}
	
	public long length() {
		return 0;
	}
}
