package com.vukimphuc.employeemanagement.config;

import com.vukimphuc.employeemanagement.service.Impl.UserServiceAuthenImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserServiceAuthenImpl userServiceAuthen;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceAuthen).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // cấu hình đường dẫn vào trang web
        http.authorizeRequests()
                .antMatchers("/login/**", "/register/**").permitAll();

//        http.authorizeRequests()
//                .antMatchers("/listUser", "/addEmployee/**", "/editEmployee/**", "/deleteEmployee/**", "/listWork/**", "/addWork/**")
//                .access("hasRole('ROLE_ADMIN')");
//
        http.authorizeRequests()
                .antMatchers("/", "/home", "/myWork", "/submitWork/**")
                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?message=Username or password is invalid");

        http.logout()
                .logoutUrl("/logout");

        http.csrf().disable();
    }
}
