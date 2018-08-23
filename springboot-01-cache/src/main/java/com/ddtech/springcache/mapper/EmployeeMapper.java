package com.ddtech.springcache.mapper;


import com.ddtech.springcache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from  employee  where  id=#{id}")
    public Employee getEmployee(Integer id);

    @Delete("delete from employee where id=#{id}")
    public  int deleteEmployee(Integer id);

    @Update("update Employee set  lastName=#{lastName},email=#{email},gender=#{gender},d_Id=#{dId} where id=#{id}")
    public  int updateEmployee(Employee employee);

    @Insert("insert into  Employee(lastName,email,gender,dId) values(#{lastName},#{email},#{gender},#{dId])")
    public Employee addEmployee(Employee employee);
    @Select("select * from Employee where lastName=#{lastName}")
    Employee getEmpByLastName(String lastName);
}
