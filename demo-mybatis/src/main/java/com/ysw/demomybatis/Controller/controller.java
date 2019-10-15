package com.ysw.demomybatis.Controller;

import com.ysw.demomybatis.Bean.Employee;
import com.ysw.demomybatis.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class controller {
    @Autowired
    JdbcTemplate JdbcTemplate;
//    @Autowired
//    EmployeeMapper employeeMapper;


    @GetMapping("/find")
    @ResponseBody
    public Map findme() {
        List<Map<String, Object>> maps = JdbcTemplate.queryForList("select * from employee");
        return maps.get(0);
    }
//    @GetMapping("/find/{id}")
//    @ResponseBody
//    public Employee find(@PathVariable String id){
//       return employeeMapper.getEmpById(id);
//    }

}
