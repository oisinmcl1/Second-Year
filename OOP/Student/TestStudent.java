/**
 * A simple class for testing the Student class.
 *
 * @author Frank
 * @version v2.0
 */
public class TestStudent
{
    public static void main(String[] args)
    {
        Student student1 = new Student("Jimbo", 85.5F, true);
        Student student2 = new Student("Mary", 90.9F, false);
        
        //System.out.println("The first student name is: "+student1.getStudentName());
        //System.out.println("The second student name is: "+student2.getStudentName());
        
        
        for(int i=1; i<10; i++)
        {
            //On even iterations of the loop, we will set the registration to true
            if(i%2==0)
            {
                System.out.print("(i: "+i+") ");
                student2.setRegistered(true);
            }
            else //On odd iterations, the registration will be set to false
            {
                student2.setRegistered(false);
            }
            
            //This conditional block will print out the current status of registration for the student.
            //It should change for every consecutive iteration of the loop based on the code above
            if(student2.isStudentRegistered())
            {
                System.out.println("The student "+student2.getStudentName()+ " is registered.");
            }
            else
            {
                System.out.println("The student "+student2.getStudentName()+ " is NOT registered.");
            }
        }
        
    }
}