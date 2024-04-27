
public abstract class Bird extends Animal
{
    //instance variables (fields)
    boolean hasFeathers;
    boolean hasWings;
    boolean flies;

    /**
     * Constructor for objects of class Bird
     */
    public Bird()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "black"; //overrides the value of colour inherited from Animal
        hasFeathers = true; //all the subclasses of Bird inherit this property and value
        hasWings = true; //all the subclasses of Bird inherit this property and value
        flies = true; //all the subclasses of Bird inherit this property and value
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public String move(int distance){
        String moving;
        if (flies == true) {
            moving = "I fly " + distance + " metres \n";
        }
        else {
            moving = "I walk " + distance + " metres \n";
        }
        return moving;
    }
    
    /**
     * sing method that all birds have
     */
    public String sing(){
        String singing = "tra la la";
        return singing;
    }
    
    /**
     * 'getter' method for the hasWings field
     */
    public boolean hasWings(){
        return hasWings;
    }
    
    /**
     * 'getter' method for the hasFeathers field
     */
    public boolean hasFeathers(){
        return hasFeathers;
    }
    
    public boolean flies() {
        return flies;
    }
}
