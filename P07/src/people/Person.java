package people;
import java.util.Objects;
import java.util.ArrayList;

import rating.Rateable;
import rating.Rating;

public class Person implements Rateable{
  protected String name;
  protected String email;
  private ArrayList<Rating> ratings;
  Person(String name, String email){
    this.name = name;
    this.email = email;
    if((name.equals(null) || email.equals(null))|| name.isEmpty()|| email.isEmpty()){
      throw new IllegalArgumentException("Either email or name is blank");
    }
  }
  public String getName(){return name;}

  @Override
  public boolean equals(Object o){
    if(this==o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person p = (Person) o;
    return (p.name.equals(this.name)) && (p.email.equals( this.email));
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email);
  }

  @Override
  public String toString(){
    return name+"("+email+")";
  }

  @Override
  public void addRating(Rating rating){
    ratings.add(rating);
  }

  @Override
  public double getAverageRating() {
    double avg =0;
    for (int i = 0; i < ratings.size(); i++) {
      avg = avg + ratings.get(i).getStars();
    }
    avg=avg/ratings.size();
    return avg;
  }

  @Override
  public Rating[] getRatings() {
    return ratings.toArray(new Rating[0]);
  }
}
