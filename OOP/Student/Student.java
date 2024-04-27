/**
 * A simple class that stores a student's name, grade, and if they are registered.
 *
 * @author Oisin
 * @version v2.0
 */
public class Student
{
    //<Access> <Type> <VariableName> ;
    private String studentName; //= "";
    private float studentGrade;
    private boolean isRegistered;
    
    //Used to initialise class fields by passing in values
    public Student(String studentName, float studentGrade, boolean reg)
    {
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        isRegistered = reg;
    }
    
    //Accessor and Mutator Methods
    //<Visibility> <ReturnType> <MethodName> ( <Params?> )
    public boolean isStudentRegistered()
    {
        return isRegistered;
    }
    
    public void setRegistered(boolean reg)
    {
        isRegistered = reg;
    }
    
    public String getStudentName()
    {
        return studentName;
    }
    
    public float getStudentGrade()
    {
        return studentGrade;
    }
    
    public void setStudentName(String sName)
    {
        studentName = sName;
    }
    
    public void setStudentGrade(float sGrade)
    {
        studentGrade = sGrade;
    }

}