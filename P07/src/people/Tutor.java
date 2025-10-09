package people;
import session.Course;

public class Tutor extends Person{
  private String bio;
  private int ssn;
  private Course course;

  public Tutor(String name, String email, String bio,int ssn,Course course){
    super(name, email);
    this.bio=bio;
    this.ssn=ssn;
    this.course=course;
    if((ssn<001_01_0001)||(ssn>999_99_9999)){
      throw new IllegalArgumentException("Invalid social security number");
    }
  }
  public String getBio(){
    return bio;
  }
  public int getSsn(){
    return ssn;
  }
  public Course getCourse(){
    return course;
  }
}
