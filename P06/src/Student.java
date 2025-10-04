import java.util.ArrayList;

public class Student extends Person{
  private static int nextStudentID = 0;
  private int studentID;
  private ArrayList<Course> courses;
  public Student(String name, String email){
    super(name, email);
    this.studentID = nextStudentID;
    nextStudentID++;
    this.courses = new ArrayList<>();
  }
  public void addCourse(Course course){
    courses.add(course);
  }
  public Course[] getCourses() {
    return courses.toArray(new Course[courses.size()]);
  }
  @Override
  public String toString(){
    String superString = super.toString();
    return superString.replace(")", ", #" + studentID + ")");
  }
}
