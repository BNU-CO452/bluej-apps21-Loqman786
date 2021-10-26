import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Mohammed Loqman
 * @version 0.1 26/october/2021
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
     
    public Course()
    {
        this("G400", "BSc Computing");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    { 
        Module co452 = new Module("co452", "programming concepts");
        Module co454 = new Module("co454", "software engineering");
        Module co456 = new Module("co456", "business managment");
        Module co458 = new Module("co458", "digi tech");
        addModule(co452);
        addModule(co454);
        addModule(co456);
        addModule(co458);

    }
    
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * This converts your total into grades
     */
    public Grades convertToGrade(int mark)
    {
        if(mark <= 0)
            return Grades.NS;
        else if(mark <= 39)
            return Grades.F;
        else if(mark <= 49)
            return Grades.D;
        else if(mark <= 59)
            return Grades.C;
        else if(mark <= 69)
            return Grades.B;
        else if(mark <= 100)
            return Grades.A;
        else   
           return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int total = 0;
        int finalMark = 0;
        for(ModuleMark mark : marks)
        {
            total = total + mark.getValue();
        }
        finalMark = total / 4;
        finalGrade = convertToGrade(finalMark);
        return finalGrade;
    }
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {  
        for (Module module : modules)
        { 
                module.print();
                module.printCredit();
        }   
    }
}