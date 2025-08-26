import java.util.Scanner;

public class ToDo {
  static class Item{
    String task;
    int priority;

    Item(String task, int priority){
      this.task = task;
      this.priority = priority;
    }
  }
  public static void main(String[] args) {
    int numItems = 5;
    if(args.length > 0) {
      numItems = Integer.parseInt(args[0]);
    }else{
      System.err.println("You have entered a negative number which we are no able to use");
      System.exit(-1);
    }

    Scanner rScanner = new Scanner(System.in);
    Item[] list = new Item[numItems];

    for (int i = 0; i < list.length; i++) {
      System.out.print("Task #"+i+ " ");
      String task = rScanner.nextLine();
      System.out.print("Priority from 1 (highest) to 5 (lowest) ");
      int priority = rScanner.nextInt();
      rScanner.nextLine();
      list[i] = new Item(task, priority);
    }
    for (int i = 1; i < 6; i++) {
      for (int j = 0; j < list.length; j++) {
        if(i == list[j].priority) System.out.println(i+" "+list[j].task);
      }
    }
  }
}
