public class Tables {
  public static void main(String[] args) {
    System.out.println("                                    " + "Times 12 Tables");
    System.out.print("       ");
    for(int i=0; i<=12; ++i){
      System.out.printf("%4d ",i);
    }
    System.out.print("\n     ");
    for(int i=0; i<=12; ++i){
      System.out.print("----   ");
    }
    System.out.println();
    for(int i=0; i<=12; ++i){
      System.out.printf("%2d | ",i);
      for(int j=0; j<=12; ++j){
        System.out.printf("%4d ",i*j);
      }
    }

  }
}
