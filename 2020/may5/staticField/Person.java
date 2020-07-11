package may5.staticField;

/**
 * 静态变量属于类共享字段。
 * 调用静态方法不需要实例，无法访问访问this，但可以访问静态字段和其他静态方法。
 * 应使用类名调用静态变量与静态方法，通过实例对象也可以访问，是因为编译器在编译时会自动转换成类名的方式。
 *
 * 静态方法常用语工具类与辅助类，比如Arrays类，main方法。
 */
public class Person {
    public Person() {
        Person.incrementInstanceCount();
    }

    public static int instanceCount;

    public static int getInstanceCount() {
        return instanceCount;
    }

    public static void incrementInstanceCount() {
        Person.instanceCount ++;
    }

    public void say() {
        System.out.println("i am a man");
    }
}
