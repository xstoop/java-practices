package april4.interfaces;

/**
 * 一个类可以实现多个接口
 */
public class Student implements Person, Driver {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void work() {
        System.out.println("study");
    }

    @Override
    public void drive() {
        System.out.println("can't drive");
    }
}
