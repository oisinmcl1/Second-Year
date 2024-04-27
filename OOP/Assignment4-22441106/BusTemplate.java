import java.util.ArrayList;

public abstract class BusTemplate
{
    public ArrayList<Trip> trips = new ArrayList<>();
    Trip trip;
    String cName;
    int seats;
    double price;
    double totalP;
    
    public BusTemplate(String cName, int seats, double price)
    {
        this.cName = cName;
        this.seats = seats;
        this.price = price;
    }
    
    public void addTrip(Trip trip) {
        //Adds trip object to trip array.
        trips.add(trip);
    }
    
    public void setSeats(int numS) {
        seats = numS;
    }
    public int getSeats() {
        return seats;
    }
    
    public Trip findTrip(int id) {
        for (Trip trip : trips) {
            //Loops through trip array and checks if the id entered matches any id's in the trip array
            if (trip.id == id) {
                return trip;
            }
        }
        //otherwise return null
        return null;
    }
    
    public boolean checkAval(int numBook, int id) {
        Trip trip = findTrip(id);
        //Checks if trip exists.
        if (trip == null) {
            //If trip doesn't exist, print message and return false.
            System.out.println(id + " does not exist\n");
            return false;
        }
        
        //If seats on bus is greater than or equal to the number of seats being booked,
        if (this.seats >= numBook) {
            //Print message, reduce seats on bus by number of seats being booked
            System.out.println("Booking successful for " + numBook + " seats\n");
            this.seats -= numBook;
            //Print message and multiply number of seats booked by the price of bus, print total
            System.out.println("\nYour Journey:\n" + findTrip(id));
            totalP = numBook * price;
            System.out.println("\nTotal Price: €" + totalP);
            //Return true
            return true;
        } else {
            //Else print message and return false.
            System.out.println("Booking unsuccessful, not enough seats avalible");
            return false;
        }
    }
    
    @Override
    public String toString() {
        //Returns string with all information of bus and trips that bus company offers by looping through trip array.
        String out = "";
        
        out+= "\n\n=Bus Information=\n\n";
        out+= "\nCompany\n-";
        out+= cName;
        out+= "\nAvalible Seats:\n-";
        out+= seats;
        out+= "\nPrice:\n-";
        out+= price;
        
        out+= "\n\n=Trip Information=\n";
        for (Trip trip : trips) {
            out+= trip.toString();
            out+= "\n";
        }
        
        out+= "\n\n";
        return out;
    }
}
