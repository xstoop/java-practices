package april.abstracts;

public class Main {
    public static void main(String[] args) {
        // 抽象类就是定义一些没有具体代码的抽象方法，设计用于被继承，子类必须实现抽象方法，子类没有实现抽象方法时任然为抽象类。
        // 使用abstract修饰的类就是抽象类，使用abstract修饰的方法就是抽象方法，抽象方法不需要写执行代码不需要写大括号。
        // 抽象类无法被实例化
        Student student1 = new Student();
        student1.work();

        Teacher teacher1 = new Teacher();
        teacher1.work();

        Main main = new Main();

        // 使用抽象类的类型去引用具体的子类类型
        Person person1 = new Student();
        Person person2 = new Teacher();
        main.doWork(person1);
        main.doWork(person2);
    }

    /**
     * 面向抽象编程:尽量引用高层类型，避免引用子类类型，调用者只关心抽象方法的定义，不关心子类的具体实现
     */
    public void doWork(Person person) {
        person.work();
    }
}
