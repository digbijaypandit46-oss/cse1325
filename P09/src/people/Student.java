package people;

import session.Course;

import java.util.List;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;

public class Student extends Person {
    public Student(String name, String email) {
        super(name, email);
        this.studentID = nextStudentID++;
        this.courses = new ArrayList<>();
    }
    public Student(Scanner in){
      super(in); 
      this.studentID = nextStudentID++;
      this.courses = new ArrayList<>();

      if (in.hasNextInt()) {
        int numCourses = in.nextInt();
        in.nextLine(); 
        
        for (int i = 0; i < numCourses; i++) {
          Course course = new Course(in);
          courses.add(course);
        }
      }
    }
    public void save(PrintStream out){
      super.save(out); 
      out.println(courses.size()); 
      for (Course course : courses) {
        course.save(out); 
      }
    }
    public void addCourse(Course course) {
        courses.add(course);
    }
    public Course[] getCourses() {
        return courses.toArray(new Course[courses.size()]);
    }
    @Override
    public String toString() {
        String s = super.toString();
        return s.substring(0, s.indexOf(')')) + ", #" + studentID + ")";
    //  return name + " ("+ email  + ", #" + studentID + ")";
    }
    private static int nextStudentID = 0;
    private int studentID;
    private List<Course> courses;
}
