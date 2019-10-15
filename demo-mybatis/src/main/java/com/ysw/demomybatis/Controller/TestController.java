package com.ysw.demomybatis.Controller;

import com.ysw.demomybatis.Bean.Department;
import com.ysw.demomybatis.Bean.Employee;
import com.ysw.demomybatis.Mapper.DepartmentMapper;
import com.ysw.demomybatis.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    EmployeeMapper EmployeeMapper;

    @GetMapping("/get/{id}")
    @ResponseBody
    public Employee find(@PathVariable String id) {
        return EmployeeMapper.getEmpById(id);
    }

    @GetMapping("/insert")
    public void insert(String lastName, String email, String gender) {
        Employee emp = new Employee();
        emp.setEmail(email);
        emp.setGender(gender);
        emp.setLastName(lastName);
        EmployeeMapper.addEmp(emp);
    }


}
