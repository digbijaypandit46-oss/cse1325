package session;
import java.util.ArrayList;
import people.Student;
import people.Tutor;

/**
* Makes a tutoring session
*
* @author Digbijay Pandit
* @version 1.0
* @since 1.0
* @license.agreement Gnu General Public License 3.0
*/

public class Session {
  private Course course;
  private DateRange dates;
  private Tutor tutor;
  private ArrayList<Student> students;

  /**
  * Creates a Session object and ArrayList for students
  *
  * @param course a course object taken from class course
  * @param tutor a tutor object taken from class tutor
  * @since 1.0
  */
  public Session(Course course, Tutor tutor){
    this.course =course;
    this.tutor = tutor;
    this.students = new ArrayList<Student>();
  }

  /**
  * Creates a new DateRange Object and sets it to dates
  *
  * @param date the date for a session
  * @param startTime the starting time for a session
  * @param duration the length of a session in minutes
  * @since 1.0
  */
  public void setSchedule(String date, String startTime,long duration ){
    dates = new DateRange(date, startTime, duration);
  }

  /**
  * Adds student to the Arraylist students
  *
  * @param student a student object from the Student class
  * @since 1.0
  */

  public void addStudent(Student student){
    students.add(student);
  }

  /**
  * Returns a string that has all the info about a session
  * @return the string with all the info of a session
  * @since 1.0
  */

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
