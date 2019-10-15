package com.ysw.yswstarterautoconfig;

public class TestService {

    TestProperties TestProperties;

    public com.ysw.yswstarterautoconfig.TestProperties getTestProperties() {
        return TestProperties;
    }

    public void setTestProperties(com.ysw.yswstarterautoconfig.TestProperties testProperties) {
        TestProperties = testProperties;
    }

    public String Say(String name) {
        return TestProperties.getPrefix() + name + TestProperties.getSuffix();
    }
}
