package oosequence;

import java.util.Date;

public class TripComponent {
    private Date start;
    private Date end;

    public TripComponent() {
        this.start = new Date();
        //set end to one hour after start time (in milliseconds)
        this.end = new Date(this.start.getTime() + (60*60*1000));
    }

    public TripComponent(Date start, Date end) {
        if (start != null && end != null) {
            if (start.before(end)) {
                this.start = new Date(start.getTime());
                this.end = new Date(end.getTime());
            } 
            else {
                this.start = new Date(start.getTime());
                this.end = null;
            }
        } 
        else {
            this.start = start;
            this.end = end;
        }
    }

    public TripComponent(TripComponent other) {
        this.start = other.getStart();
        this.end = other.getEnd();
    }
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        if (end == null || start == null || end.after(start)) {
            this.end = end;
        }
    }
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        if (end == null || start == null || start.before(end)) {
            this.start = start;
        }
    }


    public long lengthInSeconds() {
        if (start != null && end != null) {
            return (end.getTime()/1000) - (start.getTime() / 1000);
        } else {
            return 0;
        }
    }
}



