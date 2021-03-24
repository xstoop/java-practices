package collection;

import java.util.HashMap;

/**
 * map key-value键值对，Map与List一样为定义的接口，实现类有HashMap。
 * key不重复、无序，value可重复。使用key获取value，效率比list高
 */
public class Map {
    public static void main(String[] args) {
        // 创建map
        java.util.Map<String, String> map = new HashMap<String, String>();

        // 添加元素
        map.put("January", "一月份");
        map.put("February", "二月份");
        map.put("March", "三月份");
        map.put("April", "四月份");
        map.put("May", "五月份");
        map.put("June", "六月份");

        // 重复设置同一个key会覆盖上一个值并返回上一个值
        System.out.println(map.put("June", "6月份"));

        // map.get(key)查询一个key的值
        System.out.println(map.get("June"));

        // 遍历
        // 使用map.keySet()进行遍历
        System.out.println("使用map.keySet()遍历map");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }

        // 使用map.entrySet()进行遍历，可同时获取到key、value
        System.out.println("使用map.entry遍历map");
        for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s is %s \r\n", entry.getKey(), entry.getValue());
        }

        // 判断一个Key是否存在
        System.out.println(map.containsKey("July"));

        // 覆写equals方法改变containsKey判断key是否存在的结果
        java.util.Map<Month, String> monthAbbr = new HashMap<>();
        Month january = new Month("january", 31);
        Month february = new Month("february", 30);
        monthAbbr.put(january, "Jan");
        monthAbbr.put(february, "Feb");
        // 当month没有覆写equals方法时，containsKey()方法默认调用month基类object的equals方法，containsKey返回为false
        // 当覆写equals方法（只要两个不同的month对象的属性name与days都相等时就认为是同一个元素）这时就返回true

        System.out.println(january.equals(new Month("january", 31))); // true,虽然查找的key与存放的key不是一个对象，因为覆写了equals方法，所以返回true
        System.out.println(monthAbbr.get(new Month("january", 31))); // null,覆写了hashCode方法为true

        System.out.println(monthAbbr.containsKey(new Month("january", 31)));
    }
}
