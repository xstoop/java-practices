package july7.collection;

import java.time.DayOfWeek;
import java.util.Map;

/**
 * 当map的key为枚举类型时，可以使用EnumMap。EnumMap相比HashMap,占用空间更少。
 */
public class EnumMap {
    public static void main(String[] args) {
        Map<DayOfWeek, String> enumStringMap = new java.util.EnumMap<>(DayOfWeek.class);
        enumStringMap.put(DayOfWeek.MONDAY, "星期一");
        enumStringMap.put(DayOfWeek.TUESDAY, "星期二");
        enumStringMap.put(DayOfWeek.WEDNESDAY, "星期三");
        enumStringMap.put(DayOfWeek.THURSDAY, "星期四");
        enumStringMap.put(DayOfWeek.FRIDAY, "星期五");
        enumStringMap.put(DayOfWeek.SATURDAY, "星期六");
        enumStringMap.put(DayOfWeek.SUNDAY, "星期天");

        System.out.println(enumStringMap);
        System.out.println(enumStringMap.get(DayOfWeek.SUNDAY));

        for (Map.Entry<DayOfWeek, String> entry : enumStringMap.entrySet()) {
            System.out.printf("%s is %s \r\n", entry.getKey(), entry.getValue());
        }
    }
}
