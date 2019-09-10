/* This class is inherited from Student. Most of the student's 
 * functionality is there. Here we have added the items that 
 * are specific to undergraduate students, such as how the grade is 
 * determined.
 * 
 */

 class UndergraduateStudent extends Student 
{
	 final int UNDERGRADUATE_PASSING_GRADE_INTEGER = 70;
	//----------------------------------
	//	    Constructors
	//----------------------------------

	//Default constructor
	    public UndergraduateStudent( ) 
	    {
	        super();
	    }

	//Constructor that sends the student's name and type
	//to the Student class    
	    public UndergraduateStudent(String nameString)
	    {
	    	super(nameString, 'U');
	    }

	/**
	 * Computes the course grade (Pass/No Pass) from the tests
	 * based on the criteria for the undergraduate
	 * students. Pass if avg >= 70; otherwise, No Pass.
	 *
	 */
	    public void computeCourseGrade() 
	    {
	      double totalDouble = 0;
	      for (int i = 0; i < NUM_OF_TESTS_INTEGER; i++) 
	      {
	         totalDouble += testDouble[i];
	      }

	      averageDouble = totalDouble / NUM_OF_TESTS_INTEGER;

	      if (averageDouble >= 70) 
	      {
	         courseGradeString = "Pass";
	      } 
	      else 
	      {
	         courseGradeString = "No Pass";
	      }
	    }
	    
	}

