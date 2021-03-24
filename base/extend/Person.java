package extend;

/**
 * 所有类的都默认继承子Object类
 * public class Person extends Object{
 *
 */
public class Person {
    /**
     * private 子类无法访问
     */
    private String name;

    /**
     * protected 子类可以访问
     */
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
