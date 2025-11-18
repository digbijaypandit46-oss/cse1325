package bonus;
import java.util.ArrayList;
import java.util.List;

import full_credit.Primes;
import full_credit.qlogger.Qlogger;


public class PooledPrimes extends Primes {
  private long currentSlice;
  private long endSlice;
  private long sliceSize;
  private static final int SLICES = 50;
  private final Object sliceMutex = new Object();
  private final Object primeMutex = new Object();
  
  @Override
  public void search(long begin, long end, int numThreads) {
      this.sliceSize = 1 + (end - begin) / SLICES;
      this.currentSlice = begin;
      this.endSlice = end;
      
      List<Thread> threads = new ArrayList<>();
      
      for (int i = 0; i < numThreads; i++) {
        final int threadID = i;
        Thread thread = new Thread(() -> searchWorker(threadID));
        threads.add(thread);
        thread.start();
      }
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        System.err.println("Thread interrupted: " + e.getMessage());
      }
    }
  }
  
  protected void searchWorker(int threadID) {
    Qlogger.log("Started worker with threadID = " + threadID);
      
    while (true) {
      long slice = nextSlice();
      if (slice < 0) {
        return; // All work done
      }
      
      long sliceEnd = Math.min(slice + sliceSize - 1, endSlice);
      findPrimes(slice, sliceEnd, threadID);
    }
  }
  
  protected long nextSlice() {
    synchronized (sliceMutex) {
      if (currentSlice > endSlice) {
        return -1; // No more work
      }
      
      long slice = currentSlice;
      currentSlice += sliceSize;
      return slice;
    }
  }
  
  @Override
  protected void addPrime(long prime, int threadID) {
      synchronized (primeMutex) {
          primes.put(prime, threadID);
          if (prime > maxPrime) {
            maxPrime = prime;
          }
      }
  }
}