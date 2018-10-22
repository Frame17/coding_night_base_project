package ua.edu.ukma.e_oss.config;

import org.springframework.beans.factory.annotation.Autowired;
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
import ua.edu.ukma.e_oss.service.SCMemberService;
import ua.edu.ukma.e_oss.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;
    private SCMemberService scMemberService;

    public WebSecurityConfig() {
    }

    @Autowired
    public WebSecurityConfig(UserService userService, SCMemberService scMemberService) {
        this.userService = userService;
        this.scMemberService = scMemberService;
    }

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
        // todo consider adding users to list and flush after all
        List<UserDetails> users = new ArrayList<>();
        ua.edu.ukma.e_oss.model.SCMember user =
                new ua.edu.ukma.e_oss.model.SCMember("2000", (byte) 0,
                        new ua.edu.ukma.e_oss.model.User("user1"));
        users.add(User.withDefaultPasswordEncoder()
                .username(user.getUser().getName())
                .password("password")
                .roles("USER", "SC")
                .build());
        if (!userService.findByName(user.getUser().getName()).isPresent()) {
            userService.save(user.getUser());
            scMemberService.save(user);
        }

        user = new ua.edu.ukma.e_oss.model.SCMember("2000", (byte) 1,
                new ua.edu.ukma.e_oss.model.User("sc1"));
        users.add(User.withDefaultPasswordEncoder()
                .username(user.getUser().getName())
                .password("dontwork")
                .roles("USER", "SC")
                .build());
        if (!userService.findByName(user.getUser().getName()).isPresent()) {
            userService.save(user.getUser());
            scMemberService.save(user);
        }

        user = new ua.edu.ukma.e_oss.model.SCMember("2000", (byte) 1,
                new ua.edu.ukma.e_oss.model.User("sc2"));
        users.add(User.withDefaultPasswordEncoder()
                .username(user.getUser().getName())
                .password("dontwork")
                .roles("USER", "SC")
                .build());
        if (!userService.findByName(user.getUser().getName()).isPresent()) {
            userService.save(user.getUser());
            scMemberService.save(user);
        }

        ua.edu.ukma.e_oss.model.User generalUser =
                new ua.edu.ukma.e_oss.model.User("user2");
        users.add(User.withDefaultPasswordEncoder()
                .username(generalUser.getName())
                .password("password")
                .roles("USER")
                .build());
        if (!userService.findByName(generalUser.getName()).isPresent())
            userService.save(generalUser);
        return new InMemoryUserDetailsManager(users);
    }
}