package pl.awolny.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/list/users", "/products/add").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().accessDeniedPage("/unauthorized")
            .and()
	    .formLogin()
	        .loginPage("/login").permitAll()
	        .defaultSuccessUrl("/")
			.usernameParameter("email")
			.passwordParameter("password")
			.and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logmeout"))
            .logoutSuccessUrl("/");
    }
    
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService());
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
}