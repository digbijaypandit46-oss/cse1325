public class Course {
  private String dept;
  private int number;

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
  @Override
  public String toString(){
    return dept+" "+number;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    
    Course other = (Course) obj;
    return number == other.number && dept.equals(other.dept);
  }
  @Override
  public int hashCode() {
    int result = dept.hashCode();
    result = 31 * result + number;
    return result;
  }
}
