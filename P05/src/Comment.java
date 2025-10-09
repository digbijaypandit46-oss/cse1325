import java.util.ArrayList;
public class Comment {
  private String text;
  private Person author;
  private Comment inReplyTo;
  private ArrayList<Comment> replies;

  Comment(String text, Person author, Comment inReplyTo){
    this.text = text;
    this.author = author;
    this.inReplyTo = inReplyTo;
    this.replies = new ArrayList<Comment>();
    if(text ==null || author==null||text.isEmpty()){
      throw new IllegalArgumentException("Ethier text or author is empty");
    }
  }
  public void addReply(String text, Person author){
    if(text ==null || author==null||text.isEmpty()){
      throw new IllegalArgumentException("Ethier text or author is empty");
    }
    Comment reply = new Comment(text, author, this);
    replies.add(reply);
  }
  public int numReplies(){
    return replies.size();
  }
  public Comment getReply(int index){
    return replies.get(index);
  }
  public Comment getInReplyTo(){
    return this.inReplyTo;
  }
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Nested comments\n ===========\n\n");
    sb.append("Comment by "+ author.toString());
    if(inReplyTo!=null){
      sb.append(" in reply to "+ inReplyTo.author.toString());
    }
    if(!(replies.isEmpty())){
      for (int index = 0; index < numReplies(); index++) {
        sb.append("\n+Replies:  ("+index+") "+getReply(index).author.getName());
      }
    }
    return sb.toString();
  }
}
