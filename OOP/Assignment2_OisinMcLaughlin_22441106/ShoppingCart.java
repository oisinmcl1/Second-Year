//Array packages
import java.util.List;
import java.util.ArrayList;
/**
 * It should be clear how to implement all the methods needed here. Some are 'getter' methods,
others are add/remove methods for adding/removing items from the ShoppingCart's ArrayList.
The one method that might not be clear is the one called 'close()'. When the close() method is
called, items cannot be added or removed from the ShoppingCart. If you try to call the
ShoppingCart's add(Item item) method after the close method is called, it will print out an error
: "Sorry the shopping cart is closed".
 *
 * @author (Oisin Mc Laughlin - 22441106)
 * @version (v1.0)
 */
public class ShoppingCart
{   
    //Class fields
    private int cartId;
    //private String time;
    private ArrayList<Item> cartItems;
    private float totalPrice;
    private boolean isLocked;
    private Customer customer;
    
    //Class constructor that initialises fields and creates a customer object
    public ShoppingCart(Customer customer)
    {
        this.cartId = cartId;
        //this.time = time;
        this.cartItems = new ArrayList<>();
        this.totalPrice = totalPrice;
        this.isLocked = false;
        this.customer = customer;
    }
    
    //Add item to cart method with item object as parameter
    public void addItem(Item item) {
        //Checks if cart is locked, if unlocked is false
        if (isLocked == false) {
            //Add the parameter item to cartItems array
            cartItems.add(item);
            //Use get price accessor from item and add value to totalPrice
            totalPrice += item.getPrice();
            //Print message
            System.out.println("Added item to cart:\n" + item + "\n");
        }
        //If cart is locked (set to true), print this
        else {
            System.out.println("Sorry the shopping cart is closed");
        }
    }
    
    //Remove item to cart method with item object as parameter
    public void removeItem(Item item) {
        //Checks if cart is locked, if unlocked is false
        if (isLocked == false) {
            //Remove the parameter item from the cartItems array
            cartItems.remove(item);
            //Use price accessor from item and minus item price from totalPrice
            totalPrice -= item.getPrice();
            //Print message
            System.out.println("Removed item from cart:\n" + item + "\n");
        }
        //If cart is locked (set to true), print this
        else {
            System.out.println("Sorry the shopping cart is closed");
        }
    }
    
    //Accessors to get totalPrice, cartID, customer from object and cartItems array
    public float getTotal() {
        return totalPrice;
    }
    
    public int getCartId() {
        return cartId;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public ArrayList<Item> getCartItems() {
        return cartItems;
    }
    
    //Method to print items in cart
    public void printItems() {
        System.out.println("Items in cart:");
        
        //Loop through the cart and print out each item at index i until i is less than size
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println(cartItems.get(i));
        }
    }
    
    //Method to close cart, sets isLocked to true
    public void close() {
        isLocked = true;
    }
    
    //Clear cart method
    public void clear() {
        //Loops through size of cartItems array, removes each element at index i
        for (int i = 0; i < cartItems.size(); i++) {
            cartItems.remove(i);
        }
        //Sets totalPrice to 0 again
        totalPrice = 0.0F;
        //System.out.println("Cart cleared");
    }
}
