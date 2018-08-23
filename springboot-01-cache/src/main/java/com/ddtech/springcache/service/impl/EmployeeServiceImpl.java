package com.ddtech.springcache.service.impl;

import com.ddtech.springcache.bean.Employee;
import com.ddtech.springcache.mapper.EmployeeMapper;
import com.ddtech.springcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
//@CacheConfig 指定该类的cacheNames
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private   EmployeeMapper employeeMapper;

    /**
     *
     *cacheNames:缓存名称
     * key：缓存数据的key，默认使用方法的参数
     *keyGenerator:key生产策略，可以制止自定义key生产策略
     *cacheManager:缓存管理器，cacheResolver缓存解析器
     *condition:指定当条件满足时候缓存，unless指定当条件满足是候不缓存
     *sync:是否是异步模式
     *
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = "emp")
    public Employee  getEmployee(Integer id) {
        return employeeMapper.getEmployee(id);
    }

    /**
     * CachePut,更新数据库并更新缓存中的数据，前提是key要相同
     * #employee.id或者#result.id
     * @param employee
     * @return
     */
    @CachePut(cacheNames = "emp",key = "#employee.id")
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        System.out.println(employee);
        return employee;
    }

    /**
     * CacheEvict 删除缓存的数据
     * allEntries 删除缓存管理器的所有数据
     * @param id
     * @return
     */
    @CacheEvict(value = "emp",key = "#id")
    public  int deleteEmployee(Integer id){
        System.out.println("删除"+id);
        //employeeMapper.deleteEmployee(id);
        return 1;
    }

    /**
     * 定义复杂的缓存规则，该方法还会指定，把cacheput中定义的规则做了缓存
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {@Cacheable(value = "emp",key = "#lastName")},
            put={@CachePut(value = "emp",key = "#result.id"),@CachePut(value = "emp",key = "#result.email")}
    )
    public Employee  getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
