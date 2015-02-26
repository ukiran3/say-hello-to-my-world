public class Course {
  private String courseName;
  private String[] students = new String[1];
  private int numberOfStudents=0;
  private String[] incearseLength;
    
  public Course(String courseName) {
    this.courseName = courseName;
  }
  
  public String[] doubleCapacity(String[] list){  
     String[] arr1=new String[(students.length)+1];  
     for (int i = 0; i < students.length; i++) {
            arr1[i] = students[i];
        }
     return arr1;  
          }
  
  public void addStudent(String student) {
   if(numberOfStudents < students.length){
    students[numberOfStudents] = student;
    numberOfStudents++;
      }
      else
      {
          students=doubleCapacity(students);
          students[numberOfStudents] = student;
         numberOfStudents++;
    
      }
      }
  public String[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }  

  public String getCourseName() {
    return courseName;
  }  
  
  public boolean dropStudent(String student)
  {
   for(int i=0; i<students.length; i++) {
if(students[i].equals(student)) {
students[i] = null;
--numberOfStudents;
return true;
}
}
   return false;
  }
  
  public void clear()
  {
      for(int i=0; i<students.length; i++) {
      students[i]=null;
      --numberOfStudents;
      }
      
      
  }
}



