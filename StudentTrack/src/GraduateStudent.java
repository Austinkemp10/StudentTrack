/* This class is inherited from Student. Most of the student's 
 * functionality is there. Here we have added the items that 
 * are specific to graduate students, such as how the grade is 
 * determined.
 * 
 */

public class GraduateStudent extends Student 
{
	final int GRADUATE_PASSING_GRADE_INTEGER = 80;
		//----------------------------------
		//		    Constructors
		//----------------------------------

		    //Default constructor
		    public GraduateStudent( ) 
		    {
		        super();
		    }
		    
		/**
		 * Constructor that sends the student's name 
		 * and type (G for graduate) to the superclass
		 */
		    public GraduateStudent(String nameString)
		    {
		    	super(nameString, 'G');
		    }

		 /**
		  * Computes the course grade (Pass/No Pass) from the tests
		  * based on the criteria for the graduate
		  * students. Pass if avg >= 80; otherwise, No Pass.
		  */
		    public void computeCourseGrade() 
		    {
		      double totalDouble = 0;
		      for (int indexInteger = 0; indexInteger < NUM_OF_TESTS_INTEGER; indexInteger++) 
		      {
		    	  totalDouble += testDouble[indexInteger];
		      }

		      averageDouble = totalDouble / NUM_OF_TESTS_INTEGER;
		      if (averageDouble >= GRADUATE_PASSING_GRADE_INTEGER) 
		      {
		         courseGradeString = "Pass";
		      } 
		      else 
		      {
		         courseGradeString = "No Pass";
		      }
		    }
		    
}
