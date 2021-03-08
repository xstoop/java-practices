import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author xstoop
 * @date 2020/11/24 下午2:33
 */
public class Main {
    public static void main(String[] args) {
        // 时间戳转换为时间
        String time = Instant.ofEpochSecond(1577931628).atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 获取当前时间戳:毫秒
        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now().getEpochSecond());

        // 时间处理:java.util.* 旧版的时间api
        // java.util.date,java.util.SimpleDateFormat,java.util.Calendar

        // 从Java 8开始，java.time包提供了新的日期和时间API:
        new Main().newVersionDateTimeExample();
    }

    public void newVersionDateTimeExample() {
        /*
         * java.time.LocalDateTime 日期与时间
         * java.time.LocalDate 日期
         * java.time.LocalTime 时间
         */

        // 当前日期
        LocalDate date = LocalDate.now();
        // 当前时间
        LocalTime time = LocalTime.now();
        // 当前日期与时间
        LocalDateTime dateTime = LocalDateTime.now();
        // 严格按照ISO 8601格式打印
        System.out.println(date);

        // 指定日期和时间
        LocalDate date1 = LocalDate.of(2020, 12, 2);
        LocalTime time1 = LocalTime.of(17, 43, 12);
        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);
        LocalDateTime dateTime2 = LocalDateTime.of(2019, 11, 1, 11, 2, 3);

        // 使用ISO 8601标准格式指定日期与时间: yyyy-MM-ddTHH:mm:ss， ISO 8601规定的日期和时间分隔符是T
        LocalDate date2 = LocalDate.parse("2020-12-20");
        LocalTime time2 = LocalTime.parse("17:46:20");
        LocalDateTime dateTime3 = LocalDateTime.parse("2020-12-20T17:46:20");

        // 自定义时间格式 DateTimeFormatter
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(dateTime3));
        // 指定格式解析时间
        LocalDateTime dateTime4 = LocalDateTime.parse("2020-12-20 17:46:20", dateTimeFormatter);

        // 使用LocalDateTime对日期和时间进行加减
        // 加3天，减1天
        LocalDate date3 = date.plusDays(3).minusDays(1);
        LocalDateTime dateTime5 = dateTime4.plusDays(1).plusHours(3).plusMonths(1).minusMinutes(3);

        // 对日期进行修改
        // 小时修改为3
        LocalDateTime dateTime6 = dateTime5.withHour(3);
        // 天修改为第三天
        LocalDateTime dateTime7 = dateTime5.withDayOfMonth(3);
        // 使用with可以做更复杂的修改：如获取本月的第一个周一
        LocalDate date4 = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        // 判断两个时间的大小
        dateTime1.isAfter(dateTime2);
        date1.isBefore(date2);
        System.out.println(time1.isBefore(time2));

        // 获取两个时间的间隔:PT1235H10M30S 表示相差1235个小时10分钟30秒
        Duration duration = Duration.between(dateTime2, dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime1);
        System.out.println(duration);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());

        // 带时区的日期
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        // 2020-12-02T18:43:25.249+08:00[Asia/Shanghai]
        System.out.println(zonedDateTime);
        // 获取指定时区的时间
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        // 时区转换
        ZonedDateTime zonedDateTime2 = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime2);
        // 转换成LocalDateTime
        System.out.println(zonedDateTime2.toLocalDateTime());

        // 要将时间戳转换成时间得需要指定时区
        // 使用java.time.Instant获取时间戳
        System.out.println(Instant.now().getEpochSecond());
        // 指定时间戳创建 Instant
        Instant instant = Instant.ofEpochSecond(1568568760);
        // 转换为带时区的时间ZonedDateTime
        ZonedDateTime zonedDateTime3 = instant.atZone(ZoneId.systemDefault());
        // 转换为LocalDateTime
        LocalDateTime localDateTime = zonedDateTime3.toLocalDateTime();
        System.out.println(localDateTime);
    }
}
