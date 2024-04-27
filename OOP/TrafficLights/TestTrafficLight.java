
/**
 * This is a testing class which will have a main method, and which will test
the functionality of the TrafficLights class. The Light class will be implicitly tested since it is
used by the TrafficLight class.
 *
 * @author (Oisin Mc Laughlin)
 * @version (v1.0)
 */
public class TestTrafficLight
{
    public static void main(String[] args)
    {
        //Creates an instance of the TrafficLights class.
        TrafficLights myObj = new TrafficLights();
        
        //Loops through 5 times.
        for (int i = 0; i < 5; i++) {
            //Prints which run it is on.
            System.out.println("\n-----Run " + (i+1) + "-----");
            
            //Simulates each state of traffic light and then prints the state.
            myObj.go();
            myObj.printState();
            
            myObj.prepareToStop();
            myObj.printState();
            
            myObj.stop();
            myObj.printState();
        }
    }
}