public class Card{
  private String term;
  private String definition;
  public Card(String term, String definition){
    this.term = term;
    this.definition = definition;
    if(term == null || definition == null || term.isEmpty() || definition.isEmpty()){
      throw new IllegalArgumentException("Either term or definition is empty");
    }
  }
  @Override
  public String toString(){
    return definition;
  }

  public boolean attempt(String response){
    return response.toUpperCase().equals(this.term.toUpperCase());
  }

  public String getTerm(){
    return term;
  }

}