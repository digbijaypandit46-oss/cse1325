package session;

/**
* Creates an Exception for when the course is invalid
*
* @author Digbijay Pandit
* @version 1.0
* @since 1.0
* @license.agreement Gnu General Public License 3.0
*/

public class InvalidCourseException extends IllegalArgumentException {

  /**
  * Creates an Exception when there is an invalid Course
  *
  * @param dept the department (CSE)
  * @since 1.0
  */

  public InvalidCourseException (String dept){
    super("Invalid dept in new Course "+ dept);
  }

  /**
  * Creates an Exception when there is an invalid course number
  *
  * @param courseNumber the course number (1325)
  * @since 1.0
  */
  
  public InvalidCourseException(int courseNumber) {
    super("Invalid course number in new Course: " + courseNumber);
  }

}
