
/**
 * As illustrated in the lectures, this is a test class. It should have two methods - one for each
scenario. They are executed from the main method, which is contained by the TransactionTest
class
 *
 * @author (Oisin Mc Laughlin)
 * @version (v1.0)
 */
public class TransactionTest
{

    public TransactionTest()
    {
        //no instance variables
    }

    /**
     * main method - program execution starts here
     */
    public static void main(String[] args)
    {
        TransactionTest test = new TransactionTest();
        test.transaction1();
        test.transaction2();
    }
    
    public void transaction1() {
        System.out.println("\n\n\nScenario 1\n");
        //Create Customer Object
        Customer customer = new Customer("Oisin", "Mc Laughlin", "o.mclaughlin2@universityofgalway.ie");
        
        //Create a Shopping Cart for Customer.
        ShoppingCart cart = new ShoppingCart(customer);
        
        //Add 3 items with known cost to cart
        Item item1 = new Item("Milk", 2.09, 340);
        Item item2 = new Item("Bread", 1.90, 231);
        Item item3 = new Item("Pancakes", 4.10, 653);
        
        /*
        item1.setPrice(2.09F);
        item2.setPrice(1.90F);
        item3.setPrice(4.10F);
        */
        
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        
        //Finalise the cart and create an order
        cart.close();
        
        //Add a delivery address for the order
        Address billing = new Address("Ard Foyle", "Moville", "F93YRD0", "Ireland");
        Address delivery = new Address("Dock Street", "Galway", "H91KH32", "Ireland");
        
        //Add a payment type
        Payment payment = new Payment(customer, "Visa", 4219987690235476L, "12/10/23", billing, "Bank Of Ireland");
        
        //Creating Order object.
        Order order = new Order(cart, customer, delivery);
        
        //Validate the payment
        //If successful, email the customer with a success email and the cost of the purchased items
        //Order order, Address delivery, Address billing
        Email email = new Email(order, delivery, billing, payment, customer);
        email.sendEmail();
    }
    
    public void transaction2() {
        System.out.println("\n\nScenario 2\n");
        //Create Customer Object
        Customer customer = new Customer("Ciaran", "Gray", "c.gray3@universityofgalway.ie");
        
        //Create a Shopping Cart for Customer.
        ShoppingCart cart = new ShoppingCart(customer);
        
        //The user adds three items.
        Item item1 = new Item("Spuds", 4.40, 672);
        Item item2 = new Item("Butter", 3.20, 389);
        Item item3 = new Item("Jam", 5.80, 391);
        
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        
        //Requests a display of the shopping cart items and total.
        cart.printItems();
        System.out.println("Cart Total: €" + cart.getTotal() + "\n");
        
        //Removes one item.
        cart.removeItem(item1);
        
        //Confirms the cart and makes an order.
        cart.printItems();
        System.out.println("Cart Total: €" + cart.getTotal() + "\n");
        
        //Setting billing and delivery address.
        Address billing = new Address("BogSide", "Derry", "BT4800R", "Ireland");
        Address delivery = new Address("Dock Street", "Galway", "H91KH32", "Ireland");
        
        //The user submits a payment; however, the payment is not valid.
        Payment payment = new Payment(customer, "Disa", 4219987690235476L, "11/10/23", billing, "Bank Of Ireland");
        
        //Creating Order object.
        Order order = new Order(cart, customer, delivery);
        
        //The user is sent a regret email notifying them that the order was unsuccessful.
        Email email = new Email(order, delivery, billing, payment, customer);
        email.sendEmail();
    }
}
