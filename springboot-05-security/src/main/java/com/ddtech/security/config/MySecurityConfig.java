package com.ddtech.security.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter implements PasswordEncoder {
    /**
     * 认证和授权
     */
/*
    //已过时
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //设置访问路径需要哪些权限
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //默认方式：开启自动配置 登录功能，如果没有登录，自动跳到登录页面，这里使用spring security自动生成的登录页面/login
       // http.formLogin();
        //自定义方式usernameParameter,passwordParameter是页面中药传递的参数
        //使用自定义的登录页面userlogin，当发送的是get请求是是跳到登录页面，当发送的是post请求时是去请求后台登录
        http.formLogin().loginPage("/userlogin").usernameParameter("uname").passwordParameter("upwd");

        //默认方式：记住我
        //http.rememberMe();
        //自定义方式
        http.rememberMe().rememberMeParameter("uremeber");

        //开启自动配置退出功能，注销清除session
        http.logout().logoutSuccessUrl("/");//默认是登录页面/login?logout,现在设置为/
    }
    //定义认证规则

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // super.configure(auth);
        //模拟用户和对应的角色
        //基于内存方式
        auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2","VIP3")
                .and()
                .withUser("wangwu").password("123456").roles("VIP3","VIP1");
    }

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
