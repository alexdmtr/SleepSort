import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
      List<Integer> list = Arrays.asList(5, 4, 2, 6, 1, 1, 3, 4, 7);

      List<Integer> sorted = SleepSort.sort(list);

      sorted.forEach(x -> System.out.printf("%d ", x));
    }
}
