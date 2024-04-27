//Random package
import java.util.Random;
/**
 * Code provided in lecture slides.
 *
 * @author (Oisin Mc Laughlin - 22441106)
 * @version (v1.0)
 */
public class Customer
{
    //Class fields
    private String firstName;
    private String surName;
    private String emailAddress;
    private final long customerId;

    //Constructor initialising the fields
    public Customer(String firstName, String surName, String emailAddress)
    {
        this.firstName = firstName;
        this.surName = surName;
        this.emailAddress = emailAddress;
        customerId = makeCustomerId();
    }
    
    //Accessors
    public double getId() {
        return customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getSurName() {
        return surName;
    }
    public String getEmail() {
        return emailAddress;
    }
    
    //Random number generator to create customer id between 1 and 99.
    public long makeCustomerId() {
        int min = 1;
        int max = 99;

        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random number within the specified range
        long randomCustomerId = min + random.nextInt(max - min + 1);

        return randomCustomerId;
    }
}
