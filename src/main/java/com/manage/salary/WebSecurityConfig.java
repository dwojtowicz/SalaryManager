package com.manage.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username =?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username =?");
    }



    /*
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            User.UserBuilder users = User.withDefaultPasswordEncoder();

            auth.inMemoryAuthentication()
                    .withUser(users.username("user").password("user").roles("USER"))
                    .withUser(users.username("admin").password("admin").roles("USER", "ADMIN"));

        }
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/employee/", "/employee/user").hasRole("EMPLOYEE")
                .antMatchers("/employee/**").hasRole("ADMIN")
                .antMatchers("/salary/{employeeId}").hasRole("EMPLOYEE")
                .antMatchers("/salary/**").hasRole("ADMIN")
                .antMatchers("/detail/{employeeId}").hasRole("EMPLOYEE")
                .antMatchers("/detail/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/loginPage")
                .defaultSuccessUrl("/employee/")
                .failureUrl("/loginError")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/loginPage")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

    }
}
