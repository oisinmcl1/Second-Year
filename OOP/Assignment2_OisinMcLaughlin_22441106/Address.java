
/**
 * The role of the Address class is to hold the address fields of the Customer's address: e.g. street,
city, zip, country. A customer may have two Address objects associated with them - a billing
address and a delivery address. You will need methods to set and get the information in each
Address object.
 *
 * @author (Oisin Mc Laughlin - 22441106)
 * @version (v1.0)
 */
public class Address
{   
    //Address fields
    private String street;
    private String city;
    private String zip;
    private String country;
    
    //Constructor to initialise each of the fields
    public Address(String street, String city, String zip, String country)
    {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }
    
    //Accesor and mutator for each field
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
    //Returns it all as a string with each field displayed.
    @Override
    public String toString() {
        String out = "Street: " + street + "\nCity: " + city + "\nZip: " + zip + "\nCountry: " + country;
        return out;
    }
}