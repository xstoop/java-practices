import java.util.Scanner;

/**
 * @author xstoop
 */
public class InputAndPrintOut {
    public static void main(String[] args) {
        InputAndPrintOut inputAndPrintOut = new InputAndPrintOut();
        inputAndPrintOut.out();
        inputAndPrintOut.in();
    }

    private void out() {
        System.out.print("输出不换行-");
        System.out.println("输出一行并且换行");

        // 格式化输出
        // 占位符 %d 输出整数 %x 输出十六进制整数 %f 输出浮点数 %e 输出科学计数法的浮点数 %s 输出字符串

        int i = 12355;
        System.out.printf("i=%d, hex=%x", i, i);
        System.out.println();

        double b = 3.1314526;
        System.out.printf("%f", b);
        System.out.println();
        System.out.printf("%.2f", b);
        System.out.println();

        float f = 1323.1234f;
        System.out.printf("%e", f);

        String s = "ja is lack outs";
        System.out.println();

        System.out.printf("%s", s);
        System.out.println("s = " + s);
    }

    private void in() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input name");
        String name = scanner.nextLine();

        System.out.println("input age");
        // 当输入非整型时会直接报异常
        int age = scanner.nextInt();

        System.out.printf("name %s, age %d", name, age);
    }
}
