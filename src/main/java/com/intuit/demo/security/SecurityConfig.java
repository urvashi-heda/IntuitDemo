package com.intuit.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * LDAP authentication permission configuration for all REST APIs.
 * @author Urvashi Heda
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LDAP_USER_DN_PATTERN = "uid={0},ou=people";
    private static final String LDAP_GROUP_SEARCH_BASE = "ou=groups";
    private static final String LDAP_URL = "ldap://localhost:8389/dc=urvashidemo,dc=com";
    private static final String LDAP_PASSWORD_ATTRIBUTE = "userPassword";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/anonymous").permitAll()
            .antMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/login").fullyAuthenticated()
            .antMatchers(HttpMethod.PUT, "/follow").fullyAuthenticated()
            .antMatchers(HttpMethod.GET, "/followees").fullyAuthenticated()
            .antMatchers(HttpMethod.PUT, "/unfollow").fullyAuthenticated()
            .antMatchers(HttpMethod.GET, "/feed").fullyAuthenticated()
            .antMatchers(HttpMethod.POST, "/tweet").fullyAuthenticated()
            .antMatchers(HttpMethod.GET, "/tweets").fullyAuthenticated()
            .and()
                .logout()
                .clearAuthentication(true)
                .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
            .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .ldapAuthentication()
            .userDnPatterns(LDAP_USER_DN_PATTERN)
            .groupSearchBase(LDAP_GROUP_SEARCH_BASE)
            .contextSource()
            .url(LDAP_URL)
            .and()
                .passwordCompare()
                .passwordAttribute(LDAP_PASSWORD_ATTRIBUTE);
    }
}
