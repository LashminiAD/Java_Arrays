import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisors {

    public int[] divisors(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
                if (i != n / i) {
                    result.add(n / i);
                }
            }
        }

        Collections.sort(result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
