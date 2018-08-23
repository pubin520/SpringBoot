package com.ddtech.springcache.service;

import com.ddtech.springcache.bean.Employee;

import org.springframework.stereotype.Service;


public interface EmployeeService {
    public Employee getEmployee(Integer id);
    public  Employee updateEmployee(Employee employee);
    public int deleteEmployee(Integer id);
    public  Employee getEmpByLastName(String lastName);
}
