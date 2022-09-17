package com.capg.ProfileService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.models.HttpMethod;

@Configuration
@EnableWebSecurity
public class config extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.inMemoryAuthentication()
                //userDetailsService(myUserDetailService);
                .withUser("atchyuth")
                .password("12345")
                .roles("user")
                .and()
                .withUser("bla")
                .password("bla")
                .roles("admin");

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/save").hasAnyRole("USER" ,"ADMIN")
                .antMatchers("/show").hasAnyRole("USER" ,"ADMIN")
                .antMatchers("/update/{id}").hasAnyRole("USER" ,"ADMIN")
                .antMatchers("/delete/{id}").hasAnyRole("USER" ,"ADMIN")
                //permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }
}

/*
 @0verride
 protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin().and()
            .httpBasic();
    }
*/

