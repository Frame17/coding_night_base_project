package ua.edu.ukma.e_oss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/mainPage");
        return handler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // TODO: not to forget add path security in future @g_f0x
                .antMatchers("/mainPage", "/ticket", "/", "/sk.png", "/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(successHandler())
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable(); // not needed so far @g_f0x
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<>();
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user1")
                        .password("password")
                        .roles("USER", "SC")
                        .build();
        users.add(user);
        users.add(User.withDefaultPasswordEncoder()
                .username("user2")
                .password("password")
                .roles("USER")
                .build());
        users.add(User.withDefaultPasswordEncoder()
                .username("sc1")
                .password("dontwork")
                .roles("USER", "SC")
                .build());
        users.add(User.withDefaultPasswordEncoder()
                .username("sc2")
                .password("dontwork")
                .roles("USER", "SC")
                .build());
        // TODO: add other users @g_f0x
        return new InMemoryUserDetailsManager(users);
    }
}