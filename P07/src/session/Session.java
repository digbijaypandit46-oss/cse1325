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
  }

  public void setSchedule(String date, String startTime,long duration ){
    
  }
}
