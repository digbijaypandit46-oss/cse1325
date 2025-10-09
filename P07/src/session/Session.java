package session;
import java.util.ArrayList;
import people.Student;
import people.Tutor;

public class Session {
  private Course course;
  private DateRange dates;
  private Tutor tutor;
  private ArrayList<Student> students;

  Session(Course course, Tutor tutor){
    this.course =course;
    this.tutor = tutor;
    this.students = new ArrayList<Student>();
  }

  public void setSchedule(String date, String startTime,long duration ){
    this.dates = new DateRange(date, startTime, duration);
  }

  public void addStudent(Student student){
    students.add(student);
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder("Session on "+course.toString()+" at");
    sb.append(dates.toString());
    sb.append("\nTutor: "+tutor.toString()+"\n Students: ");
    for (Student student : students) {
      sb.append(" "+student.toString()+" ");
    }

    return sb.toString();
  }
}
