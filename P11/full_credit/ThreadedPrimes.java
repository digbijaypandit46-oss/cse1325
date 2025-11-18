package full_credit;

import java.util.ArrayList;
import java.util.List;


public class ThreadedPrimes extends Primes {
  private final Object mutex = new Object();
  
  @Override
  public void search(long begin, long end, int numThreads) {
    List<Thread> threads = new ArrayList<>();
    long range = end - begin;
    long delta = range / numThreads;
    
    for (int i = 0; i < numThreads; i++) {
      final int threadID = i;
      final long sliceBegin = begin;
      final long sliceEnd = (i == numThreads - 1) ? end : begin + delta;
      
      Thread thread = new Thread(() -> findPrimes(sliceBegin, sliceEnd, threadID));
      threads.add(thread);
      thread.start();
      
      begin += delta + 1;
    }
    
    // Wait for all threads to complete
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        System.err.println("Thread interrupted: " + e.getMessage());
      }
    }
  }
  
  @Override
  protected void addPrime(long prime, int threadID) {
    synchronized (mutex) {
      primes.put(prime, threadID);
      if (prime > maxPrime) {
          maxPrime = prime;
      }
    }
  }
}