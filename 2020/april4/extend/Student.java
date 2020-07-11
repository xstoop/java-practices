package april4.extend;

/**
 * 单继承：一个类只能继承一个父类
 */
public class Student extends Person {
    private int score;

    /**
     * 子类不会继承父类任何的构造方法,默认编译器会自动生成一个无参构造方法
     *
     * @param name  String
     * @param age   int
     * @param score int
     */
    public Student(String name, int age, int score) {
        super(name, age); // 必须要调用父类的构造方法，如果没有显示的调用，编译器会默认调用父类的无参构造方法
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void hello() {
        // 使用super访问父类的属性
        System.out.println("your age is " + super.age);
        // 使用属性名访问父类的属性
        System.out.println("your age is " + age);
        // 使用this访问父类的属性
        System.out.println("your age is " + this.age);
    }
}
