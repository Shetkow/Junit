import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] input = {1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4};
        List<Integer> list = new ArrayList<>();

        Arrays.sort(input);
        for (int x : input) {
            if (x > 0 && x % 2 == 0) {
                list.add(x);
            }
        }
        System.out.println(list);
    }
}