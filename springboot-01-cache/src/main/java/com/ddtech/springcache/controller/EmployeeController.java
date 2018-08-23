package com.ddtech.springcache.controller;

import com.ddtech.springcache.bean.Employee;
import com.ddtech.springcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @RequestMapping("/emp/get/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeService.getEmployee(id);
    }
    @RequestMapping("/emp/update")
    public  Employee updateEmployee(Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @GetMapping("/emp/delemp/{id}")
    public String  deleteEmployee(@PathVariable("id")Integer id){
         employeeService.deleteEmployee(id);
        return "success";
    }
    @GetMapping("emp/lastName/{lastName}")
    public Employee  getEmpByLastName(@PathVariable("lastName")String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
