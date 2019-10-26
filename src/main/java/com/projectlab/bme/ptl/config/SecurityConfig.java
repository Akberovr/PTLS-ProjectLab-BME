package com.projectlab.bme.ptl.config;

import com.projectlab.bme.ptl.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.projectlab.bme.ptl.service.MyUserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.headers().frameOptions().disable();
        http.csrf().disable()
                .authorizeRequests().antMatchers("/authenticated").permitAll()



        .and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//        http.authorizeRequests()
//                .antMatchers("/api/admin").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("ADMIN","USER")
//                .antMatchers(HttpMethod.POST,"/api/employees/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PATCH,"/api/employees/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
//                .antMatchers("/api").permitAll()
//                .and().formLogin();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){ return NoOpPasswordEncoder.getInstance(); }

}
