import com.codeforce.provider.ProviderApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

//@SpringBootTest(classes = ProviderApplication.class)
public class LocalDateT {
    @Test
    void localDateNormalPrint() {
        /**
         * https://juejin.cn/post/6844903939402383368
         */
        //获取当前年月日
        LocalDate localDate = LocalDate.now();

        int year = localDate.getYear();
        int year1 = localDate.get(ChronoField.YEAR);
        Month month = localDate.getMonth();
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.getDayOfMonth();
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);

        System.out.println(year + "-" + month + "-" + day + "-" + dayOfWeek);
        System.out.println(year1 + "-" + month1 + "-" + day1 + "-" + dayOfWeek1);

        //自定义事件
        LocalTime localTime = LocalTime.of(22, 19, 50);
        LocalTime localTime1 = LocalTime.now();
        //获取小时
        int hour = localTime.getHour();
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
        //获取分
        int minute = localTime.getMinute();
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        //获取秒
        int second = localTime.getSecond();
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);
        System.out.println(hour + "-" + minute + "-" + second);
        System.out.println(hour1 + "-" + minute1 + "-" + second1);
        System.out.println("----" + localTime1);

        // LocalDate 转换 Date 类型
        Date date = new Date(localDate.getYear() - 1900, localDate.getMonthValue() - 1,
                localDate.getDayOfMonth() , localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("before ::::" + date);
        // 数据库标准 DateFormat = {"yyyy-MM-dd HH:mm:ss"}
        System.out.println("after ::::" + simpleDateFormat.format(date));

        // 从1970年到现在多少毫秒
        long dateTime = date.getTime();
        // 获取小时
        int dateHours = date.getHours();
        // 真实的月份 - 1
        int dateMonth = date.getMonth();
        // 真实年份 需要再+1900
        int dateYear = date.getYear();

        System.out.println(dateYear + "-" + dateMonth + "-" + dateHours);
    }

    @Test
    void localDateFormat() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = new Date();
        System.out.println("原始localDateTime : " + localDateTime);
        System.out.println("原始的date : " + date);
        // Format后
        String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String formatLocalDateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//        local 转 date
        // 创建一个LocalDateTime实例

        // 将LocalDateTime转换为Date
        Date newdate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        // 打印转换后的Date对象
        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("Converted Date: " + newdate);

        System.out.println("格式化后localDateTime : " + formatLocalDateTime);
        System.out.println("格式化后date : " + formatDate);
    }
}
