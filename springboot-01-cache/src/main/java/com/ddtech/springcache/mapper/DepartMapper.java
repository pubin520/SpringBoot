package com.ddtech.springcache.mapper;

import com.ddtech.springcache.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartMapper {
    @Select("select * from  employee department  id=#{id}")
    public Department getDepartment(Integer id);

    @Delete("delete from Department where id=#{id}")
    public  boolean deleteDepartment(Integer id);

    @Update("update  Department  set departmentName=#{departmentName}  where id=#{id}")
    public boolean  updateDepartment(Department department);

    @Insert("insert into Department(id,departmentName) values(#{id},#{departmentName})")
    public   Department addDepartment(Department department);

}
