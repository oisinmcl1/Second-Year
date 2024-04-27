//Array and Random packages
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;
/**
 * The role of the Order class is to take a ShoppingCart object and transfer its items one by one
into itself. It should also take the information about the Customer. Once this is done, the
ShoppingCart should be empty. i.e. its Arraylist should be empty.
Order is an important class in this programme. Look over the lecture notes to see the list of
methods that we provisionally assigned to it. It will have relationships with several other
objects such as ShoppingCart, Payment, Address and Email
 *
 * @author (Oisin Mc Laughlin - 22441106)
 * @version (v1.0)
 */
public class Order
{   
    //Class fields
    private ArrayList<Item> orderItems;
    private Customer customer;
    private Address shippingAddress;
    private Email customerEmail;
    private Payment payment;
    private long orderNum;
    private String orderStatus;
    private String orderDetails;
    private float orderTotal;
    
    public Order(ShoppingCart shoppingcart, Customer customer, Address shippingaddress)
    {   
        //Initialises fields as well as creates customer object, 
        //calling makeOrderNum method, transferItems method with shoppingcart object as paramter,
        //setting orderstatus to "Incomplete", and setting orderDetails to the items as a string,
        //setting orderTotal as the result of the calcTotalPrice() method.
        this.orderItems = new ArrayList<Item>();
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.orderNum = makeOrderNum();
        this.orderStatus = "Incomplete";
        transferItems(shoppingcart);
        this.orderDetails = orderItems.toString();
        this.orderTotal = calcTotalPrice();
    }
    
    //Transfer items method
    public void transferItems(ShoppingCart shoppingcart) {
        //ArrayList<Item> orderItems = shoppingcart.cartItems;
        
        //Iterates through each of the items in shopping cart
        for (Item item : shoppingcart.getCartItems()) {
            //Adds each item to the orderItems array
            orderItems.add(item);
        }
        //Calls the shoppingcart clear method
        shoppingcart.clear();
    }
    
    //Random number generator to create customer id between 1 and 99.
    public long makeOrderNum() {
        int min = 1;
        int max = 99;

        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random number within the specified range
        long randomOrderNum = min + random.nextInt(max - min + 1);

        return randomOrderNum;
    }
    
    //Mutator to set orderStatus to the parameter
    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }
    
    //Method to calculate the total price in order
    public float calcTotalPrice() {
        float totalP = 0.0F;
        
        //Loops through each of the orderItems and gets the price by calling the item getPrice() method
        for (Item item : orderItems) {
            //Adds the item price to totalP and returns it
            totalP += item.getPrice();
        }
        return totalP;
    }
    
    //Accessors to get orderNum, orderDetails and orderTotal
    public double getOrderNum() {
        return orderNum;
    }
    public String getOrderDetails() {
        return orderDetails;
    }
    public float getOrderTotal() {
        return orderTotal;
    }
}
