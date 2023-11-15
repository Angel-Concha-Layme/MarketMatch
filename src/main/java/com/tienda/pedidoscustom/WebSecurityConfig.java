package com.tienda.pedidoscustom;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Autowired
        DataSource dataSource;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests((requests) -> requests
                                                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                                                .requestMatchers("/home/**").permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/usuario/pedido", true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/home"))

                                .csrf(csrf -> csrf.disable());

                return http.build();
        }

        @Bean
        public PasswordEncoder encoder() {
                return new BCryptPasswordEncoder(10);
        }

        @Bean
        UserDetailsManager users(PasswordEncoder encoder) {
                JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

                if (!users.userExists("user")) {
                        UserDetails user = User.builder()
                                        .username("user")
                                        .password(encoder.encode("user"))
                                        .roles("USER")
                                        .build();
                        users.createUser(user);
                }

                if (!users.userExists("admin")) {
                        UserDetails admin = User.builder()
                                        .username("admin")
                                        .password(encoder.encode("admin"))
                                        .roles("ADMIN")
                                        .build();
                        users.createUser(admin);
                }

                return users;
        }
}
