package com.codeforce.provider;

import com.codeforce.Demo;

public class DemoImpl implements Demo {
    @Override
    public String hello(String name) {
        return "hello dubbo";
    }
}
