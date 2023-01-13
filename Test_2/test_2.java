import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Test_2 {
  public static void main(String[] args) throws IOException {
    float x0, y0, r0, x1, y1, square_sum;
    int n = 100;

    Path path1 = Paths.get(args[0]);
    Path path2 = Paths.get(args[1]);

    ArrayList<String> file1 = (ArrayList<String>) Files.readAllLines(path1);
    ArrayList<String> file2 = (ArrayList<String>) Files.readAllLines(path2);

    String[] x0y0 = file1.get(0).split(" ");

    x0 = Float.parseFloat(x0y0[0]);
    y0 = Float.parseFloat(x0y0[1]);
    r0 = Float.parseFloat(file1.get(1));
    for (int i = 0; i < ((n <= file2.size()) ? n : file2.size()); i++) {
      String[] x1y1 = file2.get(i).split(" ");

      x1 = Float.parseFloat(x1y1[0]);
      y1 = Float.parseFloat(x1y1[1]);

      square_sum = (x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1);

      if(square_sum < r0 * r0) {
        System.out.println(i + " - точка внутри");
      } else if(square_sum == r0 * r0) {
        System.out.println(i + " - точка лежит на окружности");
      } else {
        System.out.println(i + " - точка снаружи");
      }
    }
  }
}
