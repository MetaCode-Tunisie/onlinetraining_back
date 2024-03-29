package com.example.examservice.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
@KeycloakConfiguration
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter{

    //creer seesion d'auth
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    //assurer l'auth
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        http.cors().and().csrf()
                .disable()
                .httpBasic()
                .disable()
                .headers().frameOptions().disable()
                .and()

                .authorizeRequests()
                .antMatchers("/user/listExams","/user/listCourses/{id}","/user/coursebyid/{id}").hasAnyAuthority("admin", "user")
                .and()
                .authorizeRequests()
                .antMatchers("/user/*").hasAuthority("user")
                .and()

                .authorizeRequests()
                .antMatchers("/admin/deleteExam/{id}","/admin/**").hasAuthority("admin")

                .anyRequest()
                .authenticated();
    }
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager()throws Exception{
        return super.authenticationManager();
    }
}
