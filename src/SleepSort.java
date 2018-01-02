import java.util.ArrayList;
import java.util.List;

public class SleepSort {
  public static List<Integer> sort(List<Integer> array) {
    int COUNT_THREADS = array.size();

    List<Thread> threads = new ArrayList<>();
    List<Integer> solution = new ArrayList<>();
    for (int i = 1; i <= COUNT_THREADS; i++) {
      class IntegerElementDelayThread extends Thread {
        private final int threadNumber;

        private IntegerElementDelayThread(int threadNumber) {
          super();
          this.threadNumber = threadNumber;
        }
        @Override
        public void run() {
          try {
            sleep(threadNumber * 10);
          } catch (InterruptedException exception) {
            System.err.println(exception.toString());
          }
          solution.add(threadNumber);
        }

      }

      threads.add(new IntegerElementDelayThread(array.get(i-1)));
    }

    threads.forEach(Thread::start);

    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException exception) {
        System.err.println(exception.toString());
      }
    });

    return solution;
  }
}
