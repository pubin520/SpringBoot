package com.ddtech.springcache;

import com.ddtech.springcache.bean.Employee;
import com.ddtech.springcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCacheApplicationTests {

	@Autowired
	StringRedisTemplate stringRedisTemplate;//k-v都是字符串

	@Autowired
	RedisTemplate redisTemplate; //k-v都是对象
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * opsForValue() 字符串
	 *opsForList  list
	 * opsForHash hash 散列
	 * opsForset 集合
	 * opsForzset 有序集合
	 */
	@Test
	public  void strRedis(){

		Employee employee=employeeMapper.getEmployee(1);
		redisTemplate.opsForValue().set("emp",employee);
		//stringRedisTemplate.opsForValue().append("mystr","hello");
	}


	@Test
	public void contextLoads() {
	}

}
