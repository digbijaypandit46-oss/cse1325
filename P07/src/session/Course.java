package session;

/**
* Creates a course to be tutored
*
* @author Digbijay Pandit
* @version 1.0
* @since 1.0
* @license.agreement Gnu General Public License 3.0
*/

public class Course {
  private String dept;
  private int number;

  /**
  * Creates a new Course Object
  *
  * @param dept the department of a course
  * @param number the course number
  * @exception InvalidCourseException if the course name or number is not feasible then this exception is thrown
  * @since 1.0
  */

  public Course(String dept, int number){
    this.dept =dept;
    this.number = number;
    if((dept.length() != 3)||(dept.length() != 4)){
      throw new InvalidCourseException(dept);
    }
    if((number<1000)||(number>9999)){
      throw new InvalidCourseException(number);
    }
  }

  /**
  * Turns all the important time info about the class into a string
  *
  * @return returns the dept + number as a string
  * @since 1.0 
  */

  @Override
  public String toString(){
    return dept+" "+number;
  }

  /**
  * An equals method
  *
  * @return returns a boolean that returns true if two course are equal
  * @since 1.0 
  */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    
    Course other = (Course) obj;
    return number == other.number && dept.equals(other.dept);
  }

  /**
  * A hashCode method
  *
  * @return returns the hashCode 
  * @since 1.0 
  */

  @Override
  public int hashCode() {
    int result = dept.hashCode();
    result = 31 * result + number;
    return result;
  }
}
