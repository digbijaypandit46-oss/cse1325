package session;

/**
* Sets the date and time of a session
*
* @author Digbijay Pandit
* @version 1.0
* @since 1.0
* @license.agreement Gnu General Public License 3.0
*/

public class DateRange{
  private String date;
  private String endTime;
  private String startTime;

  /**
  * Creates a new DateRange Object 
  *
  * @param date the date for a session
  * @param startTime the starting time for a session
  * @param endTime the end time for a session
  * @since 1.0
  */

  public DateRange(String date, String endTime, String startTime){
    this.date =date;
    this.endTime=endTime;
    this.startTime=startTime;
  }

  /**
  * Creates a new DateRange Object and calculates the end time with duration
  *
  * @param date the date for a session
  * @param startTime the startin gtime for a session
  * @param duration the length of a session in minutes
  * @since 1.0
  */
  
    public DateRange(String date, String startTime, long duration){
    this.date =date;
    this.startTime=startTime;
    
    int startHour = Integer.parseInt(startTime.substring(0, 2));
    int startmin = Integer.parseInt(startTime.substring(3));
    long totalMin = duration+startmin;
    int endHour = startHour+ (int)(totalMin/60);
    int endMin = (int)(totalMin%60);

    this.endTime = String.format("%02d:%02d", endHour,endMin);
  }
  /**
  * Tells you the duration of a session
  *
  * @return returns the duration of a session in minutes
  * @since 1.0
  */
  public long duration(){
    long min = 0;

    int startHour = Integer.parseInt(startTime.substring(0, 2));
    int startmin = Integer.parseInt(startTime.substring(3));
    int endHour = Integer.parseInt(endTime.substring(0, 2));
    int endmin = Integer.parseInt(endTime.substring(3));

    min = ((endHour-startHour)*60) + (endmin-startmin);
  
    return min;
  }
  /**
  * Turns all the important time info about the class into a string
  *
  * @return returns the date start and end time as well as the duration of a session in minutes
  * @since 1.0
  */
  @Override
  public String toString(){
    return date+" "+startTime+" - "+endTime +" ("+duration()+" minutes)";
  }
}
