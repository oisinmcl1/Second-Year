
public class Trip
{
    String origin, dest, dDate, aDate, dTime, aTime;
    int id;
    
    public Trip(String origin, String dest, String dDate, String aDate, String dTime, String aTime, int id)
    {
        this.origin = origin;
        this.dest = dest;
        this.dDate = dDate;
        this.aDate = aDate;
        this.dTime = dTime;
        this.aTime = aTime;
        this.id = id;
    }
    
    @Override
    public String toString() {
        //toString returning all information of the trip as a string.
        String out = "";
        
        out+= "\nOrigin:\n-";
        out+= origin;
        out+= "\nDestination:\n-";
        out+= dest;
        out+= "\nDeparture Date:\n-";
        out+= dDate;
        out+= "\nDeparture Time:\n-";
        out+= dTime;
        out+= "\nArrival Date:\n-";
        out+= aDate;
        out+= "\nArrival Time:\n-";
        out+= aTime;
        out+= "\nID:\n-";
        out+= id;
        
        return out;
    }
}
