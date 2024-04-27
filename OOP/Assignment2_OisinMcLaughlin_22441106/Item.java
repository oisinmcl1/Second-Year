
/**
 * Code provided in lecture slides.
Changed price to double, added price into constructor.
 * 
 * @author (Oisin Mc Laughlin - 22441106)
 * @version (v1.0)
 */
public class Item
{   
    //Class fields
    private String name;
    private double price;
    private long itemId;
    
    //Constructor initialising fields
    public Item(String itemName, double price, long id) {
        name = itemName;
        this.price = price;
        itemId = id;
    }
    
    //Mutator for price
    public void setPrice(float price) {
        this.price = price;
    }
    
    //Accessor for price
    public double getPrice() {
        return price;
    }
    
    //Returns a string with the item id, name and price
    @Override
    public String toString() {
        String out = "Item Id: " + itemId + "\t" + name + "\tPrice " + price + "\t";
        return out;
    }
}