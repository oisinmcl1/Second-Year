
public class AnimalTest
{
    /**
     * Constructor for objects of class AnimalTest
     */
    public AnimalTest()
    {
    }
    
    public static void main(String[] args) {
        //Creating animal test objects and calling test methods.
        AnimalTest test = new AnimalTest();
        test.test1();
        test.test2();
    }
    
    public void test1() {
        System.out.println("\n\n\nTest 1\n\n");
        
        //Animal array creating objects at each position of array
        Animal[] animals = new Animal[4];
        animals[0] = new Canary("Oisin");
        animals[1] = new Ostrich("Ciaran");
        animals[2] = new Shark("Paul");
        animals[3] = new Trout("Daniel");
        
        //Looping through while i is less than animals array length and printing the toString of each object in array.
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
            System.out.println("\n");
        }
    }
    
    public void test2() {
        System.out.println("\n\n\nTest 2\n\n");
    
        Animal[] animals = new Animal[4];
        animals[0] = new Canary("Oisin");
        animals[1] = new Ostrich("Ciaran");
        animals[2] = new Trout("Daniel");
        animals[3] = new Shark("Paul");
    
        //Looping through animal array again but nested for loop to compare that animal to each of the animals in the array.
        for (int i = 0; i < animals.length; i++) {
            for (int j = 0; j < animals.length; j++) {
                System.out.println("Comparing " + animals[i].getName() + " to " + animals[j].getName());
                System.out.println(animals[i].equals(animals[j]));
            }
        }
    }
}
