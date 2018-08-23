package com.ddtech.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot05SecurityApplication {

	/**
	 * spring sercurity使用
	 * 1.引入spring sercurity 模块
	 * 2.编写配置继承WebSecurityConfigurerAdapter标注EnableWebSecurity
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(Springboot05SecurityApplication.class, args);
	}
}
