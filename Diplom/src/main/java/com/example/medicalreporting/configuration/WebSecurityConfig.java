package com.example.medicalreporting.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
/**
 * Класс для настройки безопасности с помощью Sprig Security
 * Created by Antonova Ksenia.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()

                //Доступ только для не зарегистрированных пользователей
                .requestMatchers("/registration").not().fullyAuthenticated()

                //Разделение ролей по функциям
                .requestMatchers("/export-to-excel").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.GET, "/add_med_ot").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.POST, "/add_med_ot").hasRole("USER")

                //Доступ разрешен всем пользователей
                .requestMatchers("/", "/resources/**", "/static/**", "/css/**", "/foto/**").permitAll()

                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()

                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")

                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
