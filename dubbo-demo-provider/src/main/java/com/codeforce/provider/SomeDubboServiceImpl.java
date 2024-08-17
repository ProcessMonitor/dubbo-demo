package com.codeforce.provider;

import com.codeforce.SomeDubboService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class SomeDubboServiceImpl implements SomeDubboService {
    @Override
    public String hello(String name) {
        return " 来自 Dubbo Service hello 方法返回" + name;
    }
}
