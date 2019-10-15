package com.ysw.demo1.controller;

import com.ysw.demo1.dao.DepartmentDao;
import com.ysw.demo1.dao.EmployeeDao;
import com.ysw.demo1.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;


/**
 * Created by ysw on 2019/4/6.
 */
@Controller
public class EmpController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //获取员工列表
    @GetMapping("/emps")
    public String emps(Model model) {

        Collection coll = employeeDao.getAll();
        model.addAttribute("emps", coll);
        return "emps/list";
    }

    //员工添加页面的公司选择器
    @GetMapping("/emp")
    public String empAdd(Model model) {
        Collection coll = departmentDao.getDepartments();
        model.addAttribute("depts", coll);
        return "emps/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String empAdd1(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //修改员工（回显数据）
    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {
        Employee emp = employeeDao.get(id);
        model.addAttribute("emp", emp);
        //查部门
        Collection coll = departmentDao.getDepartments();
        model.addAttribute("depts", coll);
        return "emps/add";

    }

    //修改员工信息
    @PutMapping("/emp")
    public String update(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
