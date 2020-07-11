package april4.oop;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 类class是对象的模板, 对应的instance是这个class的实例
        Person person1 = new Person();
        person1.setName("二狗");
        person1.setBirthYear(1990);

        person1.setCars("car1", "car2");
        person1.setCars(); // 空数组

        // 参数绑定
        // 基本类型值改变不会影响属性的值
        int year = 2020;
        person1.setBirthYear(year);
        year = 2021;
        // 还是2020
        System.out.println(person1.getBirthYear());

        String name = "小狗";
        person1.setName(name);
        name = "三狗";
        // 还是小狗
        System.out.println(person1.getName());

        String[] cars = {"car1", "car2"};
        // 可变参数可以直接传递一个数组
        person1.setCars(cars);
        System.out.println(Arrays.toString(person1.getCars()));

        cars[0] = "car0";
        // 修改cars的值会同时改变person1的属性；因为cars赋值时，是引用传递，person1的cars属性与cars变量都指向同一个引用
        System.out.println(Arrays.toString(person1.getCars()));

        // 调用无参构造方法
        Person person2 = new Person();
        System.out.println(person2.getName());
        // 调用带有一个参数的构造方法
        Person person3 = new Person("3狗狗");
        System.out.println(person3.getName());

        person3.say();
        person3.say("hello");
        person3.say(1234);
    }
}
