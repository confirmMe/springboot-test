package com.ysw.demo.Controller;


import com.ysw.yswstarterautoconfig.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller {
    @Autowired
    TestService TestService;

    @GetMapping("/hello")
    public String hello() {
        return TestService.Say("阎述伟");
    }
}




