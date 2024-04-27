
public class TestTravel
{

    public TestTravel()
    {
    }
    
    public static void main(String args[]) {
        //Bus objects created for each company with company name, seats and price.
        BusEireann be = new BusEireann("Bus Eireann", 55, 4.50);
        CityLink cl = new CityLink("City Link", 45, 8.40);
        GoBus gb = new GoBus("GoBus", 60, 11.90);
        
        //Trips created with origin, destination, departure and arrival date, departure time and arrival time, id.
        Trip trip1 = new Trip("Galway", "Derry", "08-11-23", "08-11-23", "18:30", "23:45", 64);
        Trip trip2 = new Trip("Letterkenny", "Dublin", "09-11-23", "09-11-23", "15:40", "20:50", 32);
        Trip trip3 = new Trip("Moville", "Letterkenny", "10-11-23", "10-11-23", "07:45", "08:50", 238);
        Trip trip4 = new Trip("Derry", "Moville", "11-11-23", "11-11-23", "17:10", "17:50", 957);
        Trip trip5 = new Trip("Eyre Square", "Seacrest", "12-11-23", "12-11-23", "16:50", "17:25", 402);
        Trip trip6 = new Trip("Rahoon", "Eyre Square", "13-11-23", "13-11-23", "06:35", "07:10", 405);
        
        //Adding trips to each company.
        be.addTrip(trip1);
        be.addTrip(trip2);
        cl.addTrip(trip3);
        cl.addTrip(trip4);
        gb.addTrip(trip5);
        gb.addTrip(trip6);
        
        //Printing the trips of each company
        System.out.println(be);
        System.out.println(cl);
        System.out.println(gb);
        
        //Creating a booking with the amount of seats, id and company.
        Booking booking1 = new Booking(8, 64, be);
        //Calling makeBook() method from booking.
        boolean success = booking1.makeBook();
        
        if (success) {
            //If success is true, print message with booking id.
            System.out.println("\nBooking ID " + booking1.getBookId() + " was successful\n");
        }
        else {
            //If false, print booking id and message.
            System.out.println("\nBooking ID: " + booking1.getBookId() + " was unsuccessful\n");
        }
        
        //Print to show that seats was reduced for the bus.
        System.out.println(be);
        
        //Same thing as first booking but trying to book more seats than seats that are avalible.
        Booking booking2 = new Booking(50, 957, cl);
        boolean unsuccess = booking2.makeBook();
        
        if (unsuccess) {
            System.out.println("\nBooking ID " + booking2.getBookId() + " was successful\n");
        }
        else {
            System.out.println("\nBooking ID: " + booking2.getBookId() + " was unsuccessful\n");
        }
    }
}
