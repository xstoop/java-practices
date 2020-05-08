package may.staticField;

public class Main {
    public static void main(String[] args) {

        // 新建对象通过构造方法使用静态变量进行计数。
        Person person = new Person();
        Person person1 = new Person();

        System.out.println(Person.getInstanceCount());
        Person person2 = new Person();
        System.out.println(Person.getInstanceCount());
    }
}
