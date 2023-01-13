// в данной реализации нет так тавого обхода массива, выбор элемента происходит за счет вычисления (i % n)
// передаются строго два аргумента
// аргументы не должны быть меньше 1


public class Test_1 {
    public static void main(String... args) {
        if(args.length != 2) {
            System.out.println("Pass two arguments!!!");
            System.exit(0);
        }

        int i = 1;
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        String result = "1";

        if (n < 1 || m < 1) {
            System.out.println("One of the arguments is less than 1");
            System.exit(0);
        }

        while (true) {
            i = i + m - 1;

            if ((i % n) == 1) {
                break;
            } else if (i % n == 0) {
                result += n;
            } else {
                result += (i % n);
            }
        }

        System.out.print(result);
    }
}

// Пример 1:
//   Аргументы:
//   n = 3 m = 4
//   Результат:
//     result = "13"
//
// Пример 2:
//   Аргументы:
//   n = 5 m = 4
//   Результат:
//     result = "14253"
//
// Пример 3:
//   Аргументы:
//   n = 6 m = 2
//   Результат:
//     result = "123456"
//
// Пример 4:
//   Аргументы:
//     n = 7 m = 1
//   Результат:
//     result = "1"
//
// Пример 5:
//   Аргументы:
//     n = 6 m = 6
//   Результат:
//     result = "165432"
