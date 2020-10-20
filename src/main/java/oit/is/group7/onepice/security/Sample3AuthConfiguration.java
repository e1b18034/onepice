package oit.is.group7.onepice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Sample3AuthConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // tng uma1737
    auth.inMemoryAuthentication().withUser("tng")
        .password("$2y$10$pt/LWb.BvBDXBMGnVtJGROfHK26FpuRqZ4fw5HV7mngcHuOO1Z4km").roles("USER");

    // cani 10201605
    auth.inMemoryAuthentication().withUser("cani")
        .password("$2y$10$wsIbQkqk09gKlSjC3d5WEOwtKPArpOwbtfMLDZAuMWrSxgH6TDwdq").roles("USER");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin();

    http.authorizeRequests().antMatchers("/sample4/**").authenticated();

    http.csrf().disable();
    http.headers().frameOptions().disable();

    http.logout().logoutSuccessUrl("/");
  }
}
