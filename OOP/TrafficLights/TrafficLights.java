
/**
 * A class composed of three Light objects that indicates which is currently lit.
 *
 * @author (Oisin Mc Laughlin)
 * @version (v1.0)
 */
public class TrafficLights
{
    //Represents the state of each light.
    private Light green;
    private Light amber;
    private Light red;
    
    public TrafficLights()
    {
        //Initializes the light states with their respective labels.
        green = new Light("[    Green    ]");
        amber = new Light("[    Amber    ]");
        red = new Light("[    Red      ]");
    }
    
    public void go()
    {
        //Turn on green, turn off amber and red.
        green.on();
        amber.off();
        red.off();
    }
    public void prepareToStop()
    {
        //Turn on amber, turn off green and red.
        green.off();
        amber.on();
        red.off();
    }
    public void stop()
    {
        //Turn on red, turn off green and amber.
        green.off();
        amber.off();
        red.on();
    }
    
    public void printState()
    {
        //Prints the state of all lights.
        green.printstate();
        amber.printstate();
        red.printstate();
    }
}
