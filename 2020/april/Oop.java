package april;

import java.util.Arrays;

public class Oop {
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

class Person {
    private String name;
    private int birthYear;
    private String[] cars;

    // 构造方法：
    // 1. 没有返回类型，
    // 2. 可以定义多个不同参数的构造方法，在使用new一个实例时，会自动匹配调用参数个数满足的那个构造方法
    // 3. 没有定义构造方法是，编译时会默认生成一个无参数的构造方法
    // 4. 不同构造方法之间可以相互调用：this(args);
    public Person() {
        this("noName");
    }

    public Person(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        if (birthYear <= 0) {
            throw new IllegalArgumentException("age must bigger than 0");
        }
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge() {
        // 没有局部变量与属性重名时，可以省略this
        return 2020 - birthYear;
    }

    public String getName() {
        return name;
    }

    public String[] getCars() {
        return cars;
    }

    // 可变参数相当于数组类型,使用可变参数可以不用先构建一个数组作为参数。当可变参数一个都不传递时接收到则为一个空数组，这可以保证参数不为null
    public void setCars(String... cars) {
        this.cars = cars;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 方法重载：方法名相同，参数(个数与类型)不同的多个方法，应实现相同的功能，返回值类型应都相同
    public void say() {
        System.out.println("say something");
    }

    public void say(String hello) {
        System.out.println("say " + hello);
    }

    public void say(int money) {
        System.out.println("say money " + money);
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + this.getAge() +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }
}
