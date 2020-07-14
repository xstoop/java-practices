package july7.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * list 有序列表,与数组相比数组的大小在初始化后是不可以改变的，list的大小没有限制
 * java.util.List为list接口，实现类有arrayList,LinkedList
 */
public class List {
    public static void main(String[] args) {
        List studyList = new List();
        studyList.createList();
        studyList.listFunction();
//        studyList.listForeach();
//        studyList.listArraySwitch();
    }

    /**
     * 创建 list
     */
    public void createList() {
        // 创建一个ArrayList
        java.util.List<Object> arrayList = new ArrayList<>();

        // 创建一个LinedList
        java.util.List<Object> linkedList = new LinkedList<>();

        // 使用List.of(List interface的静态方法)快速创建一个只读的list，无法修改list中的元素，of方法不接受null元素
        java.util.List<Integer> listOf = java.util.List.of(1, 2, 3);
    }

    /**
     * list 常用方法
     */
    public void listFunction() {
        java.util.List<String> arrayList = new ArrayList<>();
        // 增加元素
        arrayList.add("april");

        // 指定索引增加元素,可以添加null,元素可以重复
        arrayList.add(1, "april");
        arrayList.add(2, "may");
        arrayList.add(3, null);

        // 删除指定索引的元素
        arrayList.remove(1);

        // 删除元素不指定索引,有多个相同元素时只删除一个元素
        arrayList.remove("april");
        System.out.println(arrayList);

        // 获取指定索引的元素
        System.out.println(arrayList.get(0));

        // 获取list的元素个数
        System.out.println(arrayList.size());

        // 获取list的迭代器
        arrayList.iterator();

        // list中是否包含某个元素
        System.out.println(arrayList.contains("may"));

        // 获取某个元素在list中的索引位置
        System.out.println(arrayList.indexOf("may"));

        // contains与indexOf方法中是通过遍历元素，依次调用遍历元素的equals()方法与查找元素做比较。当被查找元素是基本类型时，
        // 其基本类型已有equals()方法的实现，如String类型的元素的equals()方法会比较两个字符串对象存放的实际内容。
        // 如果list中存放的是引用类型元素，在使用contains与indexOf方法时，要求被该引用对象需要实现equals()方法来判定这两个引用类型元素如何判定为相等。

        java.util.List<Month> monthList = new ArrayList<>();

        Month january = new Month("january", 31);
        Month february = new Month("february", 30);
        monthList.add(january);
        monthList.add(february);
        // 当month没有覆写equals方法时，使用contains()方法默认调用基类object的equals方法，contains返回为false
        // 当覆写equals方法（只要两个不同的month对象的属性name与days都相等时就认为是同一个元素）这时就返回true
        System.out.println(monthList.contains(new Month("january", 31)));
    }

    /**
     * 遍历 list
     */
    public void listForeach() {
        java.util.List<String> list = java.util.List.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        // 使用for循环遍历下标
        System.out.println("使用for循环");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d is %s \r\n", i, list.get(i));
        }

        // 使用迭代器
        System.out.println("使用迭代器");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        // 使用for each，for each本身就会直接使用iterator迭代器
        System.out.println("使用for each");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * list 与 array 转换
     */
    public void listArraySwitch() {
        java.util.List<String> list = java.util.List.of("spring", "summer", "autumn", "winter");
        // list 转换成 array
        // 使用 list.toArray() 返回一个 Object 数组，会丢失类型信息
        Object[] array = list.toArray();

        // 给 toArray(T[]) 传递一个类型相同的 array，list 会自动把元素复制到出传入的 array 中，这样来保持元素类型信息
        String[] array1 = list.toArray(new String[3]);
        String[] array2 = list.toArray(new String[list.size()]);

        // 传递 Object[]::new方法
        String[] array3 = list.toArray(String[]::new);

        // array 转换成 list
        Integer[] arrayInt = {1, 2};
        arrayInt[0] = 1;
        arrayInt[1] = 1;

        // 直接使用 java.util.List.of() 静态方案
        java.util.List<Integer> intList = java.util.List.of(arrayInt);

        // 使用Arrays.asList()方法
        java.util.List<Integer> intList1 = Arrays.asList(arrayInt);
    }
}
