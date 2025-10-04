import java.util.Objects;

public class Person {
  protected String name;
  protected String email;
  Person(String name, String email){
    this.name = name;
    this.email = email;
    if((name == null || email==null)|| name.isEmpty()|| email.isEmpty()){
      throw new IllegalArgumentException("Either email or name is blank");
    }
  }
  public String getName(){return name;}

  @Override
  public boolean equals(Object o){
    if(this==o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person p = (Person) o;
    return (p.name == this.name) && (p.email == this.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email);
  }

  @Override
  public String toString(){
    return name+"("+email+")";
  }
}
