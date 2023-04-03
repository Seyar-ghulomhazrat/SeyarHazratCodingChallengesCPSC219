package oosequence;

import java.util.Date;

public class Flight extends TripComponent {
    private String departureAirport;
    private String arrivalAirport;

    public Flight() {
        super(new Date(), new Date(new Date().getTime()));
        departureAirport = "";
        arrivalAirport = "";
    }
    
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        if (arrivalAirport != null){
        	if (arrivalAirport.length() == 3) {
        		this.arrivalAirport = arrivalAirport;
        }
        }
else
        {
            this.arrivalAirport = "";
        }
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        if (departureAirport != null) {
        	if (departureAirport.length() == 3) {
        		this.departureAirport = departureAirport;
        } else{
        	this.departureAirport = "";
        	}
        }
        else {
            this.departureAirport = "";
        }
    }


    public String getDuration() {
    	
        long lenInSec = super.lengthInSeconds();
        long lenInMin = lenInSec / 60;
        return lenInMin + " minutes";
    }}




