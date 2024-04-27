
/**
 * The Payment class holds the following pieces of information:
• customer;
• credit card type;
• credit card number;
• date;
• address;
• credit card bank name
 *
 * @author (Oisin Mc Laughlin - 22441106)
 * @version (v1.0)
 */
public class Payment
{   
    //Class fields
    private Customer customer;
    private String cardType;
    private long cardNum;
    private String date;
    private Address address;
    private String bankName;    
    
    //Payment constructor, initialising fields
    public Payment(Customer customer, String cardType, long cardNum, String date, Address address, String bankName)
    {
        this.customer = customer;
        this.cardType = cardType;
        this.cardNum = cardNum;
        this.date = date;
        this.address = address;
        this.bankName = bankName;
    }
    
    //cardType accessor
    public String getCardType() {
        return cardType;
    }
    
    //isValid method with cardType string as a parameter
    public boolean isValid(String cardType) {
        //converts parameter to lowercase
        String check = cardType.toLowerCase();
        
        //returns true if parameter is equal to "visa" or "mastercard"
        return check.equals("visa") || check.equals("mastercard");
    }
    
    //Converts all of the details to a string and returns it
    @Override
    public String toString() {
        String out = "Name: " + customer.getFirstName() + " " + customer.getSurName() + "\nType: " + cardType + "\nNumber: " +cardNum + "\nDate: " + date + "\nAddress: " + address + "\nBank: " + bankName;
        return out;
    }
}
