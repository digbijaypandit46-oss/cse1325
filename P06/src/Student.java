import java.util.ArrayList;

public class Student extends Person{
  private static int nextStudentID = 0;
  private int StudentID;
  private ArrayList<Course> courses;
  Student(){
    super(name, email);
  }
}
