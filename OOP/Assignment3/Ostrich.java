
public class Ostrich extends Bird
{
    //String name;
    boolean isTall;
    String legs;

    /**
     * Constructor for objects of class Ostrich
     */
    public Ostrich(String name)
    {
        super();
        this.name = name;
        flies = false;
        //colour = "brown";
        //distance = 0;
        
        isTall = true;
        legs = "thin long legs";
    }
    
    public boolean isTall() {
        return isTall;
    }
    public String legs() {
        return legs;
    }
    
    @Override
    public String toString() {
        //Printing out each of the attributes of the class including the unique ones
        String strng ="";
        strng+= "\n\n\n";
        strng+= "Ostrich\n";
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
        strng+= move(10);
        
        strng+= "\n-Tall?\n";
        strng+= isTall();
        strng+="\n-Legs?\n";
        strng+= legs();
        
        return strng;
    }
    
    @Override
    public boolean equals(Object obj) {
        //Im running out of time and have to go work, I explained the equals class in Canary object, thanks.
        if (obj == null) {
            System.out.println("NULL Object\n");
            return false;
        }
        
        if (obj instanceof Ostrich) {
            Ostrich ostrich = (Ostrich) obj;
            
            if (this.getName().equals(ostrich.getName()) && this.getColour().equals(ostrich.getColour()) && this.isTall() == ostrich.isTall()) {
                return true;
            }
        }
        
        return false;
    }
}
