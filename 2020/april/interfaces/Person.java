package april.interfaces;

/**
 * 如果全部为抽象方法，可以写成接口interface。接口是比抽象类更抽象的类型。
 * 接口里不能声明任何属性，只能全部申明为方法，并且不用写访问权限控制public、protected、private与abstract。
 * <p>
 * 在接口中可以定义default方法，但default方法无法访问属性，因为接口里不能定义字段(但可以定义静态字段)。
 * default方法的目的是为了给接口增加新功能是，不用修改每个实现接口的子类。
 */
interface Person {
    public static final int MALE = 1;
    // 静态字段可以省略修饰符public static final  编译器会自动加上public static final:
    int FEMALE = 2;

    void setName(String name);

    String getName();

    void work();

    default String whatYouName() {
        return "My name is " + this.getName();
    }
}
