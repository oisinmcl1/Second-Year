
public class Shark extends Fish
{
    //String name;
    boolean canBite;
    boolean isDangerous;
    
    /**
     * Constructor for objects of class Shark
     */
    public Shark(String name)
    {
        super();
        this.name = name;
        
        canBite = true;
        isDangerous = true;
    }
    
    public boolean canBite() {
        return canBite;
    }
    public boolean isDangerous() {
        return isDangerous;
    }
    
    @Override
    public String toString() {
        //Printing out each of the attributes of the class including the unique ones
        String strng ="";
        strng+= "\n\n\n";
        strng+= "Shark\n";
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
        
        strng+= "\n-Bite?\n";
        strng+= canBite();
        strng+="\n-Dangerous?\n";
        strng+= isDangerous();
        
        return strng;
    }
    
    @Override
    public boolean equals(Object obj) {
        //Im running out of time and have to go work, I explained the equals class in Canary object, thanks.
        if (obj == null) {
            System.out.println("NULL Object\n");
            return false;
        }
        
        if (obj instanceof Shark) {
            Shark shark = (Shark) obj;
            
            if (this.getName().equals(shark.getName()) && this.getColour().equals(shark.getColour()) && this.canBite() == shark.canBite() && this.isDangerous() == shark.isDangerous()); {
                return true;
            }
        }
        
        return false;
    }
}
