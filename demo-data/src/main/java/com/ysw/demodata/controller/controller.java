package com.ysw.demodata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class controller {

    @Autowired
    JdbcTemplate JdbcTemplate;

    @ResponseBody
    @GetMapping("/find")
    public Map getme() {
        List<Map<String, Object>> maps = JdbcTemplate.queryForList("select * from department");
        return maps.get(0);

    }
}
