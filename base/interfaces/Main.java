package interfaces;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("xiaomingming");
        System.out.println(student.getName());

        Main main = new Main();
        main.drive(student);

        // 抽象类与接口的区别
        // 从业务逻辑上来说，抽象类里存放一些公共逻辑，不同的逻辑通过子类去实现。而接口里不实现任何业务逻辑，只定义逻辑的抽象说明。
        // 从代码上来说，抽象类里可以定义属性字段，可以实现非抽象方法。而接口不能定义属性，不能实现非抽象方法(default方法除外)。
    }

    // 方法参数通过接口引用，不用依赖具体的子类
    public void drive(Driver driver) {
        driver.drive();
    }
}
