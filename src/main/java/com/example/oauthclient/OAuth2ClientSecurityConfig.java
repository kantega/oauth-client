package com.example.oauthclient;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class OAuth2ClientSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests(authorize -> authorize
                    .antMatchers("/user/**").authenticated())
                // .oauth2Login(Customizer.withDefaults());
                .oauth2Login(login -> login .redirectionEndpoint().baseUri("/api/callback"));
    }
}
