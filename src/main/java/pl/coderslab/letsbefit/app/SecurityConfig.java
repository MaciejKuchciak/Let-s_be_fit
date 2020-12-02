package pl.coderslab.letsbefit.app;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.letsbefit.service.CustomerUserDetailsService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomerUserDetailsService customerUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
//               .antMatchers("/admin/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin();
//                .loginPage("/login")
//                .usernameParameter("login") // username
//                .passwordParameter("password") // password
//                .defaultSuccessUrl("/userlist")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/userlist")
//                .and()
//                .csrf()
//                .disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customerUserDetailsService).passwordEncoder(passwordEncoder());
    }
}

