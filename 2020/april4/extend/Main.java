package april4.extend;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("ren", 0);
        System.out.println(person.getName());
        Student student = new Student("xiaoming", 12, 30);
        student.hello();
        PrimaryStudent primaryStudent = new PrimaryStudent("xiaoxiaoming", 14);

        // 变量声明向上转型：声明的父类变量可以指向其子类的实例
        // Person 类型的变量可以指向Student类型的实例，因为Student是person的子类，拥有Person的全部功能。
        Person person1 = new Student("xiaoming2", 13, 31);

        Student student1 = new Student("xiaoming3", 14, 32);
        Person person2 = student1;
        Object object1 = person2;
        Object object2 = student1;

        // 向下转型：把父类类型强制转换为子类类型
        Person person3 = new Student("xiaoming4", 14, 32);
        Person person4 = new Person("ren2", 123);
        // 把父类Person类型的变量 person3 转换为子类Student，因为person3就是指向Student的实例，所以是可以的
        Student student2 = (Student) person3;
        // 而把父类Person类型的变量 person4转换为子类Student则不行，会报java.lang.ClassCastException异常。
        // 因为person4指向的是父类的实例，父类无法直接变成子类，子类的功能无法凭空出现
        // Student student3 = (Student) person4;

        // 通过使用 instanceof 判断变量类型来避免出现ClassCastException异常
        if (person4 instanceof Student) {
            Student student4 = (Student) person4;
        }

        Object obj = "obj";
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s.toUpperCase());
        }
        // java 14 的新写法
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        }
    }
}
