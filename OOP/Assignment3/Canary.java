
public class Canary extends Bird
{
    
    //String name; // the name of this Canary

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
        
    }
    
    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public String sing(){
        String singing = "tweet tweet tweet";
        return singing;
    }
    
    /**
     * toString method rfeturns a String representation of the bird
     * What superclass has Canary inherited this method from? 
     */
    @Override
    public String toString(){
        //Printing out each of the attributes of the class including the unique ones
        String strng ="";
        strng+= "\n\n\n";
        strng+= "-Canary\n";
        strng+= "-Name:\n";
        strng+= name;
        strng+= "\n-Colour:\n";
        strng+= colour;
        strng+= "\n-Skin?\n";
        strng+= hasSkin();
        strng+= "\n-Breath?\n";
        strng+= breathes();
        strng+= "\n-Eats?\n";
        strng+= eats();
        
        strng+= "\n-Feathers?\n";
        strng+= hasFeathers();
        strng+= "\n-Wings?\n";
        strng+= hasWings();
        strng+= "\n-Flies?\n";
        strng+= flies();
        strng+= "\n-Singing:\n";
        strng+= sing();
        strng+= "\n";
        strng+= move(5);
        
        return strng;
    }

    
    /**
     * equals method defines how equality is defined between 
     * the instances of the Canary class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Canary object
     */
    
    @Override
    public boolean equals(Object obj) {
        //Checking for null object
        if (obj == null) {
            System.out.println("NULL Object\n");
            return false;
        }
        
        //If object is instance of canary
        if (obj instanceof Canary) {
            //Set input object to instance of canary
            Canary canary = (Canary) obj;
            
            //Comparing attributes of the class
            if (this.getName().equals(canary.getName()) && this.getColour().equals(canary.getColour())) {
                return true;
            }
        }
        
        return false;
    }
}
