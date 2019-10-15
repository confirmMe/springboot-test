package com.ysw.demo1.controller;

import com.ysw.demo1.ecption.UserNotExistExpection;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by ysw on 2019/4/9.
 */
@ControllerAdvice
public class MyExpectionHandler {
    @ExceptionHandler(UserNotExistExpection.class)
    public String userHandler(Exception e, HttpServletRequest request) {
        Map map = new HashMap();
        request.setAttribute("javax.servlet.error.status_code", 409);
        map.put("code", "notExist");
        map.put("msg", "你好");
        request.setAttribute("ext1", map);
        return "forward:/error";
    }
}
