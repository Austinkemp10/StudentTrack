//This abstract class contains the common elements of all students
//This class can be inherited to provide needed functionality of 
//specific types of students

public abstract class Student
{
//----------------------------------
//  Data Members
//----------------------------------

  /**
   * The number of tests this student took
   * * The name of this student
   * An array of the test scores this student received
   * The course grade of this student based on the test scores
   * The type of student (G-graduate or U-undergraduate)
   * The student's average of exams for this course
   */
  protected   final static int NUM_OF_TESTS_INTEGER = 3;
  protected   String           nameString;
  protected   double []            testDouble;
  protected   String           courseGradeString;
  protected   char 			   studentTypeChar;
  protected   double 		   averageDouble;


//----------------------------------
//  Constructors
//----------------------------------

  /**
   * Default constructor
   */
  public Student( ) 
  {
	  nameString = "No Name";
      courseGradeString = "****";
  }

  /**
   * Constructs a new Student with the passed
   * name and type of student.
   */
  public Student(String studentNameString, char typeChar) 
  {
      setName(studentNameString);
      setType(typeChar);
      testDouble = new double[NUM_OF_TESTS_INTEGER];
      courseGradeString = "****";
  }


//-------------------------------------------------
//    Public Methods:
//
//       abstract    void        computeCourseGrade  (           )
//
//                   String      getCourseGrade      (           )
//                   String      getName             (           )
//                   int         getTestScore        ( int       )
//                   double      getAverage          (           )
//
//                    void        setTestScore        ( int, int  )
//    Private Methods:
//		              void        setName             ( String    )
//                    void        setType             ( char      )	
//------------------------------------------------

  /**
   * Abstract method to compute the course grade.
   * Each subclass must implement this method.
   *
   */
  public abstract void computeCourseGrade();

  /**
   * Assign public to protected variable - name.
   * Sets the name of this student
   */
  private void setName(String studentNameString) 
  {
    nameString = studentNameString;
  }

  /**
   * Assign public to protected variable - type
   */
  private void setType(char typeChar ) 
  {
    studentTypeChar = typeChar;
  }

  /**
   * Returns the course grade of this student.
   */
  public String getCourseGrade( ) 
  {
    return courseGradeString;
  }

  /**
   * Returns the name of this student.
   */
  public String getName( ) 
  {
    return nameString;
  }
  
  /**
   * Returns the type of student, such as U or G.
   */
  public char getType()
  {
	  return studentTypeChar;
  
  }
  /**
   * Returns the score of the designated test
   */
  public double getTestScore(int testNumber) 
  {
    return testDouble[testNumber];
  }

  /**
   * Returns the average of all tests
   */
  public double getAverage()
  {
  	return averageDouble;
  }
  
  /**
   * 
   */
 

  /**
   * Sets the score of one test
   */
  public void setTestScore(int testNumber, double testScoreDouble) 
  {
    testDouble[testNumber] = testScoreDouble;
  }
  

}
