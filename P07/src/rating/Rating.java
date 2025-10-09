package rating;
public class Rating {
  private int stars;
  private Comment review;

  Rating(int stars, Comment review){
    this.stars = stars;
    this.review = review;
    if(stars>5||stars<1){
      throw new IllegalArgumentException("must give a rating between 1-5 inclusive");
    }
  }
  public int getStars(){
    return stars;
  }
  public Comment getReview(){
    return review;
  }
  @Override
  public String toString(){
    int star = 2605;
    char s = (char) star;
    int noStar = 2606;
    char nS = (char) noStar;
    StringBuilder sb = new StringBuilder();
    sb.append("Ratings\n =======\n\n");
    for (int j = 0; j < 5; j++) {
      sb.append("\nFor "+j+"-star: ");
      for (int i = 0; i < 5; i++) {
        if(i<=j){
          sb.append(s);
        }else{
          sb.append(nS);
        }
      }
    }
    return sb.toString();
  }
}
