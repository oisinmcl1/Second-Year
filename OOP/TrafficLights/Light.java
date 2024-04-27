
/**
 * A class that represents a single light. All lights have a colour and indicator of whether
they are currently on or off (a Boolean variable).
 *
 * @author (Oisin Mc Laughlin)
 * @version (v1.0)
 */
public class Light
{
    //Indicates if light is on (true) or off (false).
    private boolean Lstate;
    //Colour of light.
    private String colour;
    
    public Light(String colour)
    {
        //Initialises light with a colour.
        this.colour = colour;
        //Sets light to off (false).
        Lstate = false;
    }
    
    
    //Accessors
    public boolean getState()
    {
        //Returns state of light.
        return Lstate;
    }
    
    public String getColour()
    {
        //Returns colour of light.
        return colour;
    }
    
    
    // Mutators
    public void setState(boolean state)
    {
        //Changes state of light to on or off (true or false).
        Lstate = state;
    }
    
    public void setColour(String colour)
    {
        //Changes colour of light to green, amber or red.
        this.colour = colour;
    }
    
    
    //Methods
    public void on()
    {
        //Turns light on 
        Lstate = true;
    }
    
    public void off()
    {
        //Turns light off.
        Lstate = false;
    }
    
    public void printstate()
    {
        //Prints current state of the light (colour and if its on or off).
        
        //If light is on, print out colour.
        if (Lstate == true) {
            System.out.println(colour);
        }
        //Else print "Off".
        else {
            System.out.println("[    =Off=    ]");
        }
    }
}
