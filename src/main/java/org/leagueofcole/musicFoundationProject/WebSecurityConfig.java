package org.leagueofcole.musicFoundationProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Handles Web Security Configuration
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * This just tells spring to use sensible defaults.
     * @return password encrypter
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures security to allow the user to access anything in /resources, 
     * /registration, /login, and once in they can go to /logout, which will
     * log them out and take them to /login, and they must log in to see
     * any page not listed here.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                    .antMatchers("/resources/**", "/registration").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .successHandler(new RefererRedirectionAuthenticationSuccessHandler())
                    .permitAll()
                    .and()
                .logout()
                		.logoutUrl("/logout")
                		.logoutSuccessUrl("/login");
        
    }

    /**
     * Tells spring to use sensible default encrypter thing.
     * @param auth The AuthenticationManagerBuilder
     * @throws Exception RIP if this ever happens
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    
    /**
     * Tells spring to use sensible AuthenticationManager default.
     * @return The AuthenticationManager we use
     * @throws Exception RIP if this ever happens
     */
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
      return authenticationManager();
    }
}
