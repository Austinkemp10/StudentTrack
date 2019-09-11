# StudentTrack
Application written in Java to track student scores, information, and pass/fail status.

---

Student.java

  This abstract class contains the common elements of all "Students" it can be inherited to provide needed functionality of specific types of students.
  
---
  
GraduateStudent.java
  
  This class is inherited from Student. Most of the student's functionality is there. Here we have added the items that are specific to graduate students, such as how the grade is determined.
  
---

Undergraduate.java
  
  This class is inherited from Student. Most of the Student's functionality is there. Here we have added the items that are specific to undergraduate students such as how the grade is determined.
 
---

ComputeGrades.java
  This is the presentation class (driver) for displaying information for both graduate and undergraduate students. 
