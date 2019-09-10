//This is the presentation class (driver) for 
//displaying information for both graduate
//and undergraduate students.
//Student, GraduateStudent, and UndergraduateStudent are 
//needed classes.

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.text.*;


public class ComputeGrades extends JFrame
	implements ActionListener
{

	//----------------------------------
    //	    Data Members
	//----------------------------------

	    private static final int DEFAULT_SIZE = 25;  //number of students in array
	    private  int numberOfStudentsInteger;    //total students
	    private Student[] roster = new Student[DEFAULT_SIZE];  //array of students
	    private int studentCount;  //current student being processed

	    //Components needed
	    JPanel mainPanel = new JPanel();
	    JLabel classLabel = new JLabel("          CISP 21 Class          ");
	    JLabel nameLabel = new JLabel("Name");
	    JTextField nameTextField = new JTextField(15);
	    JLabel studentTypeLabel = new JLabel("Type of Student (G or U)");
	    JTextField studentTypeTextField = new JTextField(10);
	    JLabel testLabel = new JLabel("Tests");
	    JTextField test1TextField = new JTextField(5);
	    JTextField test2TextField = new JTextField(5);
	    JTextField test3TextField = new JTextField(5);
	    JButton addStudentButton = new JButton("Add Student");
	    JButton displayGradesButton = new JButton("Display Grades");
	    JTextArea outputTextArea = new JTextArea(8,25);
	    JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
	    Font classFont = new Font("Arial", Font.BOLD, 24);
	    
	    //-----------------------------------
	    //This constructor calls the super (JFrame) class
	    //setting the title bar text, adds the components
	    //to panel, adds the panel to the frame, sets
	    //the properties of the frame, and registers the 
	    //action listener to the buttons
	    //-----------------------------------
	    public ComputeGrades()
		{
			super("CISP21 Class");
			
			classLabel.setFont(classFont);
			mainPanel.add(classLabel);
			mainPanel.add(nameLabel);
			mainPanel.add(nameTextField);
			mainPanel.add(studentTypeLabel);
			mainPanel.add(studentTypeTextField);
			mainPanel.add(testLabel);
			mainPanel.add(test1TextField);
			mainPanel.add(test2TextField);
			mainPanel.add(test3TextField);
			mainPanel.add(addStudentButton);
			mainPanel.add(displayGradesButton);
			mainPanel.add(outputScrollPane);
			
			this.add(mainPanel);
			
			this.setLocation(150, 150);
			this.setSize(300, 400);
			this.setVisible(true);
			
			addStudentButton.addActionListener(this);
			displayGradesButton.addActionListener(this);
		}



	    //-----------------------------------
	    // Main
	    //-----------------------------------
	    public static void main(String[] args) 
	    {
	    	// instantiate our class and set default close operation
	    	ComputeGrades cisGrades = new ComputeGrades();
	    	cisGrades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }


	    //-----------------------------------
	    // actionPerformed
	    // This method determines which button
	    // triggered this method and branches
	    // to the appropriate method
	    //-----------------------------------
	    public void actionPerformed(ActionEvent evt)
	    {
	    	if(evt.getSource() == addStudentButton)
	    	{
	    		if(validation())
	    		{
	    			setStudent();
	    		}
	    	}
	    		
	    	else if(evt.getSource() == displayGradesButton)
	    		displayGrades();
	    }
	    	
	    
	    //-----------------------------------
	    // setStudent method
	    // This method retrieves the information
	    // from the components, converts the grades
	    // instantiates the appropriate type of student
	    // and adds one to the total students processed
	    //-----------------------------------
	    
	    public boolean validation()
	    {
	    	
	    	boolean validateBoolean = false;
	    	char studentTypeChar;
	    		if(!(nameTextField.getText().equals("")))
	    		{
	    			if(!(studentTypeTextField.getText().equals("")))
	    			{
	    				studentTypeChar = (studentTypeTextField.getText()).toUpperCase().charAt(0);
	    				if((studentTypeChar == 'U' || studentTypeChar == 'G'))
		    			{
		    				if(!(test1TextField.getText()).equals(""))
		    				{
		    					if(!(test2TextField.getText()).equals(""))
			    				{
		    						if(!(test3TextField.getText()).equals(""))
				    				{
				    					try
				    					{
				    						double test1Double = Double.parseDouble(test1TextField.getText());
				    						try
					    					{
					    						double test2Double = Double.parseDouble(test2TextField.getText());
					    						try
						    					{
						    						double test3Double = Double.parseDouble(test3TextField.getText());
						    						  validateBoolean = true;
						    					}
						    					catch(NumberFormatException err)
						    					{
						    						JOptionPane.showMessageDialog(null, "Please enter test score");
						    						test3TextField.selectAll();
									    			test3TextField.requestFocus();	
						    					}
					    					}
					    					catch(NumberFormatException err)
					    					{
					    						JOptionPane.showMessageDialog(null, "Please enter test score");
					    						test2TextField.selectAll();
								    			test2TextField.requestFocus();	
					    					}
				    						
				    					}
				    					catch(NumberFormatException err)
				    					{
				    						JOptionPane.showMessageDialog(null, "Please enter test score");
				    						test1TextField.selectAll();
							    			test1TextField.requestFocus();	
				    					}
				    				}
				    				else
						    		{
						    			JOptionPane.showMessageDialog(null, "Please enter test score");
						    			test3TextField.requestFocus();
						    		}
			    				}
			    				else
					    		{
					    			JOptionPane.showMessageDialog(null, "Please enter test score");
					    			test2TextField.requestFocus();
					    		}
		    				}
		    				else
				    		{
				    			JOptionPane.showMessageDialog(null, "Please enter test score");
				    			test1TextField.requestFocus();
				    		}
		    			}
		    			else
			    		{
			    			JOptionPane.showMessageDialog(null, "Please enter U or G Student type");
			    			studentTypeTextField.selectAll();
			    			studentTypeTextField.requestFocus();
			    		}
	    			}
	    			else
		    		{
		    			JOptionPane.showMessageDialog(null, "Please enter Student type");
		    			studentTypeTextField.requestFocus();
		    		}
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Please enter name");
	    			nameTextField.requestFocus();
	    		}
	    	return validateBoolean;
	    }
	    public void setStudent()
	    {
	    	//Retrieve input
	    	String nameString = nameTextField.getText();
	    	String studentType = studentTypeTextField.getText();
	    	String test1String = test1TextField.getText();
	    	String test2String = test2TextField.getText();
	    	String test3String = test3TextField.getText();
	    	
	    	//Create an array of tests and convert test
	    	//scores to doubles
	    	double tests [] = new double [3];
	    	tests[0] = Double.parseDouble(test1String);
	    	tests[1] = Double.parseDouble(test2String);
	    	tests[2] = Double.parseDouble(test3String);

	    	//Determine if student is undergraduate or graduate
	    	//and instantiate the correct type of student
	    	if (studentType.equalsIgnoreCase("U"))
	    		roster[numberOfStudentsInteger] = new UndergraduateStudent(nameString);
	    	else if (studentType.equalsIgnoreCase("G"))
	    		roster[numberOfStudentsInteger] = new GraduateStudent(nameString);
	    	
	    	//set the individual tests for the student
	    	for (int i = 0; i < tests.length; i++)
	    	{
	    		roster[numberOfStudentsInteger].setTestScore(i, tests[i]);
	    	}
	    	
	    	//adds 1 to the total students processed
	    	numberOfStudentsInteger ++;
	    	
	    	clearFields();
	    }
	    
	    //-----------------------------------
	    // displayGrades method
	    // This method collects information on
	    // all students in the class and displays
	    // the information in the textarea
	    //-----------------------------------
	    public void displayGrades()
	    {
	    	String studentString = "";
	    	DecimalFormat numberDF = new DecimalFormat("#0.0");
	    	for (int i = 0; i < numberOfStudentsInteger; i++)
	    	{
	    		//Compute the students grades
	    		roster[i].computeCourseGrade();
	    		
	    		//Accumulate students information for display
	    		studentString += roster[i].getName() + " type: " + 
	    			roster[i].getType() + " average: " + 
	    			numberDF.format(roster[i].getAverage()) + 
	    			" grade: " + roster[i].getCourseGrade() + "\n";
	    			
	    	}
	    	//display all students information
	    	outputTextArea.setText(studentString);
	    }
	    
	    //-----------------------------------
	    // clearFields method
	    // This method clears the text fields
	    // for the next input and resets the focus
	    //-----------------------------------
	    public void clearFields()
	    {
	    	nameTextField.setText("");
	    	studentTypeTextField.setText("");
	    	test1TextField.setText("");
	    	test2TextField.setText("");
	    	test3TextField.setText("");
	    	nameTextField.requestFocus();
	    	
	    }
}
	    
