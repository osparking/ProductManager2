package space.bum.social.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
  @Bean
  UserDetailsService userDetailsService() {
    return new StoreUserDetailsService();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // @formatter:off
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin(flc -> flc.loginPage("/login").permitAll())
        .authorizeHttpRequests(
            (auth) -> auth
            .requestMatchers("/register/**").permitAll()
            .anyRequest().authenticated())
        .logout(lo -> lo.permitAll());

    return http.build();
  }
  // @formatter:on
}
