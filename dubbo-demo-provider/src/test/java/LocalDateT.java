import com.codeforce.provider.ProviderApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
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
}
