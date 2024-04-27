import java.util.Random;

public class Booking
{
    //Trip trip;
    BusTemplate bus;
    int numSeats;
    int tripId;
    int bookingId;
    
    public Booking(int numSeats, int tripId, BusTemplate bus)
    {
        //this.trip = trip;
        this.numSeats = numSeats;
        this.tripId = tripId;
        this.bus = bus;
        this.bookingId = genId();
    }
    
    public int genId() {
        //Method to generate a random id between 1 and 999
        Random rand = new Random();
        int randomNum = rand.nextInt(999) + 1;
        
        return randomNum;
    }
    
    public boolean makeBook() {
        //Calls checkAval from BusTemplate with numSeats and tripId as parameters.
        return bus.checkAval(numSeats, tripId);
    }
    
    public int getBookId() {
        return bookingId;
    }
}
