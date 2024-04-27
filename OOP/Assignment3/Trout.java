
public class Trout extends Fish
{
    //String name;
    boolean hasSpikes;
    boolean isEdible;
    String eggs;
    
    /**
     * Constructor for objects of class Trout
     */
    public Trout(String name)
    {
        super();
        this.name = name;
        colour = "brown";
        
        hasSpikes = true;
        isEdible = true;
        eggs = "Swim upriver to lay eggs";
    }
    
    public boolean hasSpikes() {
        return hasSpikes;
    }
    public boolean isEdible() {
        return isEdible;
    }
    public String laysEggs() {
        return eggs;
    }
    
    @Override
    public String toString() {
        //Printing out each of the attributes of the class including the unique ones
        String strng ="";
        strng+= "\n\n\n";
        strng+= "Trout\n";
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
        
        strng+= "\n-Fins?\n";
        strng+= hasFins();
        strng+= "\n-Swims?\n";
        strng+= canSwim();
        strng+= "\n-Gills?\n";
        strng+= hasGills();
        strng+= "\n";
        strng+= move(10);
        
        strng+= "\n-Spikes?\n";
        strng+= hasSpikes();
        strng+= "\n-Spikes?\n";
        strng+= hasSpikes();
        strng+= "\n-Where eggs?\n";
        strng+= laysEggs();
        
        return strng;
    }
    
    @Override
    public boolean equals(Object obj) {
        //Im running out of time and have to go work, I explained the equals class in Canary object, thanks.
        if (obj == null) {
            System.out.println("NULL Object\n");
            return false;
        }
        
        if (obj instanceof Trout) {
            Trout trout = (Trout) obj;
            
            if (this.getName().equals(trout.getName()) && this.getColour().equals(trout.getColour()) && this.hasSpikes() == trout.hasSpikes() && this.isEdible() == trout.isEdible() && this.laysEggs().equals(trout.laysEggs())); {
                return true;
            }
        }
        
        return false;
    }
}
