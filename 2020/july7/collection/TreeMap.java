package july7.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * hashMap的key是无序的，每次遍历的key的顺序都不能保证相同。可以使用treeMap来实现key的有序。
 * treeMap是SortedMap接口的实现类，SortedMap继承Map接口
 */
public class TreeMap {
    public static void main(String[] args) {
        Map<Month, String> hashMap = new HashMap<>();
        hashMap.put(new Month("Jan", 31), "january has 31 days");
        hashMap.put(new Month("Feb", 28), "february has 28 days");
        hashMap.put(new Month("Mar", 31), "march has 31 days");
        hashMap.put(new Month("Apr", 30), "april has 30 days");

        for (Month month : hashMap.keySet()) {
//            System.out.println(hashMap.get(month));
        }

        // 使用treeMap并指定排序方法实现按天数的大小排序
        Map<Month, String> sortedMap = new java.util.TreeMap<>(new Comparator<Month>() {
            @Override
            public int compare(Month o1, Month o2) {
                if (o1.days == o2.days) {
                    return 0; // 0表示相等
                }
                return (o1.days > o2.days) ? 1 : -1; // 1表示o1大于o2，-1表示o1小于o2
            }
        });

        sortedMap.put(new Month("Jan", 31), "january has 31 days");
        sortedMap.put(new Month("Feb", 28), "february has 28 days");
        sortedMap.put(new Month("Mar", 31), "march has 31 days");
        sortedMap.put(new Month("Apr", 30), "april has 30 days");

        for (Month month : sortedMap.keySet()) {
            System.out.println(sortedMap.get(month));
        }
    }
}
