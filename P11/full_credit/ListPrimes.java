package full_credit;

import bonus.PooledPrimes;
import full_credit.qlogger.Qlogger;

public class ListPrimes {
  public static void main(String[] args) {
    Qlogger.enabled = true;
    
    if (args.length != 3) {
      System.out.println("usage: java ListPrimes <begin> <end> <#threads>");
      System.exit(1);
    }
    
    try {
      long begin = Long.parseLong(args[0].replaceAll("_", ""));
      long end = Long.parseLong(args[1].replaceAll("_", ""));
      int numThreads = Integer.parseInt(args[2]);
        
        Primes primes;
        if (numThreads == 0) {
          primes = new Primes();
        } else if (numThreads > 0) {
          primes = new ThreadedPrimes();
        } else {
          primes = new PooledPrimes();
          numThreads = Math.abs(numThreads);
        }
        
      primes.search(begin, end, numThreads);
      
      Qlogger.log("\nFound " + primes.size() + " primes!\n");
      Qlogger.log(primes.toString());
      
    } catch (NumberFormatException e) {
      System.err.println("Error: Invalid number format in arguments");
      System.exit(1);
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }
}