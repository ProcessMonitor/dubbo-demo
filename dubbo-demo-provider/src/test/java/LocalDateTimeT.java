import com.alibaba.fastjson2.util.DateUtils;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeT {

    @Test
    void LocalTimeTest(){
        LocalDateTime of = LocalDateTime.of(2024, Month.AUGUST,
                15, 12, 20, 10);
        LocalDateTime parse = LocalDateTime
                .parse("2025-05-25 12:20:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(of);
        System.out.println(parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}