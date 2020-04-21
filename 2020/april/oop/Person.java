package april.oop;

import java.util.Arrays;

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
