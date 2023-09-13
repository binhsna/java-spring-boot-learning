package com.binhnc.student_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("binhnc")
//                .password("$2a$10$fwradv4OKJeY.O.SZ8QpI.AbI/HwCu6HVgTwXBsqT.9Iwwthe0vna")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("$2a$10$9QrLjIuNHgYKNzybqonfguKRq3tgRChYAwSjqe.BgF3Y6CwJiecCS")
//                .roles("ADMIN");
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("binhnc")
                .password("$2a$10$fwradv4OKJeY.O.SZ8QpI.AbI/HwCu6HVgTwXBsqT.9Iwwthe0vna")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/class/new").hasAnyRole("USER", "ADMIN")
                .antMatchers("/class/edit/*", "/class/delete/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and().logout().permitAll()
                .and().httpBasic()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
