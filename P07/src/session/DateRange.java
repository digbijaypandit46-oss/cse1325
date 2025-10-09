package session;

public class DateRange{
  private String date;
  private String endTime;
  private String startTime;

  DateRange(String date, String endTime, String startTime){
    this.date =date;
    this.endTime=endTime;
    this.startTime=startTime;
  }
    DateRange(String date, String startTime, long duration){
    this.date =date;
    this.startTime=startTime;
    
    int startHour = Integer.parseInt(startTime.substring(0, 2));
    int startmin = Integer.parseInt(startTime.substring(3));
    long totalMin = duration+startmin;
    int endHour = startHour+ (int)(totalMin/60);
    int endMin = (int)(totalMin%60);

    this.endTime = String.format("%02d:%02d", endHour,endMin);
  }

  public long duration(){
    long min = 0;

    int startHour = Integer.parseInt(startTime.substring(0, 2));
    int startmin = Integer.parseInt(startTime.substring(3));
    int endHour = Integer.parseInt(endTime.substring(0, 2));
    int endmin = Integer.parseInt(endTime.substring(3));

    min = ((endHour-startHour)*60) + (endmin-startmin);
  
    return min;
  }

  @Override
  public String toString(){
    return date+" "+startTime+" - "+endTime +" ("+duration()+")";
  }
}
