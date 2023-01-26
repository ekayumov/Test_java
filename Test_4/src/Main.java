import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(filePath));
        int sum = 0;
        int[] nums = new int[lines.size()];
        int[] sum_num = new int[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            nums[i] = Integer.parseInt(lines.get(i));
        }

        for (int i = 0; i < lines.size(); i++) {
            sum = 0;
            for (int j = 0; j< lines.size(); j++) {
                sum += Math.abs (nums[i] - nums[j]);
            }
            sum_num[i] = sum;
        }

        List<Integer> ints = Arrays.stream(sum_num)
                .boxed()
                .collect(Collectors.toList());

        System.out.println( Collections.min(ints));

    }
}
