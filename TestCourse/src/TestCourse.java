class TestCourse {
  public static void main(String[] args) {
    Course course1 = new Course("Data Structures");
    Course course2 = new Course("Database Systems");

    course1.addStudent("Peter Jones");
    course1.addStudent("Brian Smith");
    course1.addStudent("Anne Kennedy");
    
    course2.addStudent("Peter Jones");
    course2.addStudent("Steve Smith");

    System.out.println("Number of students in course1: "
      + course1.getNumberOfStudents());
    String[] students;
    students = course1.getStudents();
    System.out.print("And They are : ");
    for (int i = 0; i < course1.getNumberOfStudents(); i++)
      System.out.println(students[i] + ", ");
    course1.dropStudent("Anne Kennedy");
    
    System.out.println("After drop Number of students in course1: "
      + course1.getNumberOfStudents());
    String[] students1 = course1.getStudents();
    System.out.print("And They are : ");
    for (int i = 0; i < course1.getNumberOfStudents(); i++)
      System.out.println(students1[i] + ", ");
    
    
    System.out.println();
    System.out.println("Number of students in course2: "
      + course2.getNumberOfStudents());
    students = course2.getStudents();
    System.out.print("And They are : ");
    for (int i = 0; i < course1.getNumberOfStudents(); i++)
      System.out.println(students[i] + ", ");
    course2.clear();
    
    System.out.println("After the Clear method is used the Number of students in course2: "
      + course2.getNumberOfStudents());
    System.out.print("And They are : ");
    for (int i = 0; i < course1.getNumberOfStudents(); i++)
      System.out.println(students[i] + ", ");
    
  }
}