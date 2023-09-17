package com.binhnc.student_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        UserDetails user1 = User.withUsername("user")
                .password("$2a$10$eywrhes7PgbWamY2/dtmleg6NuB44vfZzbgkwhc0AIr3Sw9mlCA1S")
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("admin")
                .password("$2a$10$eywrhes7PgbWamY2/dtmleg6NuB44vfZzbgkwhc0AIr3Sw9mlCA1S")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/**/new", "/**", "/**/edit/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll();
    }
}
