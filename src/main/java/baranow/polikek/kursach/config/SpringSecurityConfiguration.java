package baranow.polikek.kursach.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import baranow.polikek.kursach.model.UserAuthority;

@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(expressionInterceptUrlRegistry ->
//                        expressionInterceptUrlRegistry
//                                .requestMatchers("/registration", "/login").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/buyer").hasAuthority(UserAuthority.PLACE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.GET, "/buyer").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.POST, "/product").hasAuthority(UserAuthority.PLACE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.GET, "/product/**").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.POST, "/purchase").hasAuthority(UserAuthority.PLACE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.GET, "/purchase/**").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.POST, "/employee").hasAuthority(UserAuthority.PLACE_ORDERS.getAuthority())
//                                .requestMatchers(HttpMethod.GET, "/employee/**").hasAuthority(UserAuthority.MANAGE_ORDERS.getAuthority())
//                                .anyRequest().hasAuthority(UserAuthority.FULL.getAuthority()))
//                .formLogin(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}