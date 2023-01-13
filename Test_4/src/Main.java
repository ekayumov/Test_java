import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
 Шаги решения:
  просуммируем все элемениы и найдем среднее значение, после округлим до целого значения
  далее вычесляем разницу между средним значением и всеми числами
 просуммировав все полученные значение получим минимальное число ходов
*/

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(filePath));
        int sum = 0;
        int[] nums = new int[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            nums[i] = Integer.parseInt(lines.get(i));
            sum += nums[i];
        }
        int sumSteps = 0;
        int centre = (int) Math.ceil((float)sum/lines.size());

        for (int i = 0; i < lines.size(); i++) {
            sumSteps += Math.abs (centre - nums[i]);
        }
        System.out.println(sumSteps);

    }
}

