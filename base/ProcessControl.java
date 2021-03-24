package april4;

/**
 * @author xstoop
 */
public class ProcessControl {
    public static void main(String[] args) {
        ProcessControl processControl = new ProcessControl();
        processControl.ifControl();
        processControl.switchControl();
        processControl.whileControl();
    }

    protected void ifControl() {
        if (true) System.out.println("开始成绩判定");

        int n = (int) (Math.random() * 101);
        System.out.printf("你的分数为%d,", n);

        if (n == 100) {
            System.out.println("满分");
        } else if (n >= 90) {
            System.out.println("很优秀");
        } else if (n >= 80) {
            System.out.println("很不错");
        } else if (n >= 70) {
            System.out.println("还可以");
        } else if (n >= 60) {
            System.out.println("加油，及格了");
        } else {
            System.out.println("没有及格哦");
        }

        // 浮点数不能直接使用==判断大小，因为浮点数无法精确表示，正确做法应该利用差值小于某个临界值
        double a = 1 - 9.0 / 10;
        if (a == 0.1) {
            System.out.println("a 等于 0.1");
        } else {
            System.out.println("a 不等于 0.1");
        }

        if (Math.abs(a - 0.1) < 0.000001) {
            System.out.println("a 等于 0.1");
        }

        // 判断引用类型相等
        String s1 = "hello";
        String s2 = "HellO".toLowerCase();

        // 使用等号判断表示比较两个变量的指针是否相等，是否指向同一个对象
        if (s1 == s2) {
            System.out.println("s1 等于 s2");
        } else {
            System.out.println("s1 不等于 s2");
        }

        // 使用equals比较内容是否相等;使用equals函数需要判断对象是否为null,如果为null会抛出异常;或者直接字符串而不是变量名
        if (s1 != null && s1.equals(s2)) {
            System.out.println("s1 等于 s2");
        } else {
            System.out.println("s1 不等于 s2");
        }

        if ("hello".equals(s2)) {
            System.out.println("s1 等于 s2");
        } else {
            System.out.println("s1 不等于 s2");
        }
    }

    protected void switchControl() {
        String fruit = "apple";
        // switch用于多个 == 的判断，可以转换为if语句，但if语句不能都转为switch
        // 每个case与最后的default都必须要写break;因为fall-through格则，匹配到的case后面的所以代码包括其它都要执行，除非遇到break;
        switch (fruit) {
            case "apple":
                System.out.println("苹果");
                break;
            case "banana":
                System.out.println("香蕉");
                break;
            default:
                System.out.println("不知道什么水果");
                break;
        }

        // java12增加了switch表达式语法，更简洁也避免了fall-through
        switch (fruit) {
            case "apple" -> System.out.println("苹果");
            case "banana" -> System.out.println("香蕉");
            default -> System.out.println("不知道什么水果");
        }

        // switch作为赋值表达式
        String fruitName = switch (fruit) {
            case "apple" -> "苹果";
            case "banana" -> "香蕉";
            default -> {
                // 复杂语句使用{}包裹，并使用yield返回结果
                String nothing = fruit + "不知是啥";
                yield nothing;
            }
        };
    }

    protected void whileControl() {
        int sum1 = 0;
        int m1 = 20;
        int n1 = 100;
        while (m1 <= n1) {
            sum1 += m1;
            m1++;
        }
        System.out.println(sum1);

        int sum2 = 0;
        int m2 = 20;
        int n2 = 100;
        do {
            sum2 += m2;
            m2++;
        } while (m2 <= n2);
        System.out.println(sum2);
    }
}
