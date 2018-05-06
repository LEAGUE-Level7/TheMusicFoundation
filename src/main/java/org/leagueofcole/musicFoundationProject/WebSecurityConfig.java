package org.leagueofcole.musicFoundationProject;

<<<<<<< HEAD
import org.springframework.context.annotation.Bean;

=======
>>>>>>> LeaguePelicans/master
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

<<<<<<< HEAD
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

=======
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
>>>>>>> LeaguePelicans/master
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
<<<<<<< HEAD

=======
>>>>>>> LeaguePelicans/master
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
<<<<<<< HEAD


=======
                .successHandler(new RefererRedirectionAuthenticationSuccessHandler())
>>>>>>> LeaguePelicans/master
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
<<<<<<< HEAD

    /*

=======
    /*
>>>>>>> LeaguePelicans/master
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
<<<<<<< HEAD

    */
}

=======
    */
}
>>>>>>> LeaguePelicans/master
