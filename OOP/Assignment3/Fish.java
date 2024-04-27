
public abstract class Fish extends Animal
{
    boolean hasFins;
    boolean canSwim;
    boolean hasGills;
    
    /**
     * Constructor for objects of class Fish
     */
    public Fish()
    {
        super();
        
        colour = "white";
        
        hasFins = true;
        canSwim = true;
        hasGills = true;
    }
    
    @Override
    public String move(int distance) {
        String moving = "I swim " + distance + " metres \n";
        return moving;
    }
    
    public boolean hasFins() {
        return hasFins;
    }
    public boolean canSwim() {
        return canSwim;
    }
    public boolean hasGills() {
        return hasGills;
    }
}
