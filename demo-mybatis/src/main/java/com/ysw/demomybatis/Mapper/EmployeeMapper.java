package com.ysw.demomybatis.Mapper;

import com.ysw.demomybatis.Bean.Employee;


public interface EmployeeMapper {
    public Employee getEmpById(String id);

    public void addEmp(Employee employee);
}
