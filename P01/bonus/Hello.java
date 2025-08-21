import java.util.Scanner;
public class Hello {
  public static void main(String[] args) {
    Scanner rScanner = new Scanner(System.in);
    System.out.println("Please print your name");
    String name = rScanner.nextLine();
    System.out.println("Hello "+name);
    rScanner.close();
  }
}