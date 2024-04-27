import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        //Scanner object
        Scanner c = new Scanner(System.in);
        char input;
        boolean checkIn = false;
        boolean direction = false;
        long start;
        long end;
        int i;

        System.out.println("Type the alphabet in order (hit enter between letters)\nForwards or Backwards (f/b)?: ");

        //This while loop asks for which direction the user wants to type the alphabet
        while(!checkIn) {
            //Scanning in first character entered
            input = c.next().charAt(0);
            //Changing character to lowercase
            input = Character.toLowerCase(input);

            //If input is f
            if (input == 'f') {
                //Direction = false (false = forwards)
                direction = false;
                System.out.println("Forwards Selected");
                //To end while loop
                checkIn = true;
            }
            else if (input == 'b') {
                //Direction = true (true = backwards)
                direction = true;
                System.out.println("Backwards Selected");
                checkIn = true;
            }
            else {
                System.out.println("Invalid. You must enter either 'f' or 'b' to start.");
                checkIn = false;
                //Run
            }
        }

        //Forwards
        i = 0;
        if (direction == false) {
            //Start timer
            start = System.currentTimeMillis();
            //Loop through forwards
            while (i < letters.length) {
                System.out.println("\nType the letter " + letters[i] + ":");
                //Scan first letter
                input = c.next().charAt(0);
                //Lowercase
                input = Character.toLowerCase(input);

                //If user input is correct, increment i
                if (input == letters[i]) {
                    i++;
                }
                else {
                    System.out.print(input + " is incorrect");
                }
            }
            //End timer
            end = System.currentTimeMillis();
        }
        else {
            //Set i to the length of array - 1
            i = (letters.length - 1);

            start = System.currentTimeMillis();
            while (i >= 0) {
                System.out.println("\nType the letter " + letters[i] + ":");
                input = c.next().charAt(0);
                input = Character.toLowerCase(input);

                //If user input is correct, decrement i
                if (input == letters[i]) {
                    i--;
                }
                else {
                    System.out.print(input + " is incorrect");
                }
            }
            end = System.currentTimeMillis();
        }

        //Working out total time taken
        double total = ((end - start) / 1000);
        System.out.println("Total time taken: " + total + " seconds.");
    }
}