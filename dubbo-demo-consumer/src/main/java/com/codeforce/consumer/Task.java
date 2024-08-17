package com.codeforce.consumer;


import com.codeforce.SomeDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task implements CommandLineRunner {

    @DubboReference
    private SomeDubboService someDubboService;

    @Override
    public void run(String... args) throws Exception {
        String result = someDubboService.hello("codeforce");
        System.out.println("receive result ======> : " + result);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + " consumer invoke dubbo service : "
                            + someDubboService.hello("fuck !"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

    }
}
