
/**
 * The role of the Email object is to send (you are required to just printout on the screen) an email
message to the customer. If the Payment has been successful, then it will be a positive message
giving the order number, the order details, the delivery, and billing addresses. If the Payment
has been unsuccessful, then the message explains that the order has not been made. In either
case, the customer must be addressed by their first name and the email address is their email
address (from the Customer object)
 *
 * @author (Oisin Mc Laughlin - 22441106)
 * @version (v1.0)
 */
public class Email
{
    //Class fields
    private Order order;
    private Customer customer;
    private Address delivery;
    private Address billing;
    private Payment payment;
    
    //Constructor initialising each field
    public Email(Order order, Address delivery, Address billing, Payment payment, Customer customer)
    {
        this.order = order;
        this.delivery = delivery;
        this.billing = billing;
        this.payment = payment;
        this.customer = customer;
    }
    
    //sendEmail method
    public void sendEmail() {
        //Calls isValid method from payment with the cardType as a parameter
        if (payment.isValid(payment.getCardType()) == true) {
            //If the card Type is valid (true)
            //Set orderStatus to processing
            order.setOrderStatus("Processing");
            //Print an email with customer details, order number, item details, total and addresss.
            System.out.println("\nEmail Address: " + customer.getEmail() + "\n\nOrder Number: " + order.getOrderNum() + "\nOrder Details: " + order.getOrderDetails() + "\nTotal: " + order.getOrderTotal() + "\n\nId: " + customer.getId() + "\nName: " + customer.getFirstName() + " " + customer.getSurName() + "\n\nDelivery Address: \n" + delivery + "\n\nPayment Details:\n" + payment + "\n\nBilling Address: \n" + billing + "\n\nThank you for shopping with Dunnes Stores\n");
        }
        else {
            //If payment was not valid, email customer saying it wasn't valid
            System.out.println("\nEmail Address: " + customer.getEmail() + "\n\nWe regret to inform you that your order was unsuccessful\nPayment has not been processed\n\nPlease contact Dunnes Stores Support for help.\n");
        }
    }
}
