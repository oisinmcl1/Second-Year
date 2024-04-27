
public abstract class Animal
{
    boolean hasSkin;
    boolean breathes;
    //boolean canMove;
    String colour;
    String eats;
    String name;
    
    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        breathes = true; //all the subclasses of Animal inherit this property and value
        hasSkin = true; // all the subclasses of Animal inherit this property and value
        //canMove = true;
        colour = "grey"; //all the subclasses of Animal inherit this property and value
        eats = "food";
    }
    /**
     * move method
     * param int distance - the distance the Animal should move
     * All subclasses inherit this method
     */
    public String move(int distance){
        String moving = "I move " + distance + " metres \n";
        return moving;
    }
        
    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    public String getColour(){
        return colour;
    }
    
     /**
     * 'getter' method for haSkin field
     * All subclasses inherit this method
     */
    
    public boolean hasSkin(){
        return hasSkin;
    }
    public boolean breathes() {
        return breathes;
    }
    public String eats() {
        return eats;
    }
    public String getName() {
        return name;
    }
}
