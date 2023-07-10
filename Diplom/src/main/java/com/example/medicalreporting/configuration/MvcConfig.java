package com.example.medicalreporting.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Класс для настройки Spring MVC и контроллеров для отображений этих шаблонов
 * Created by Antonova Ksenia.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("main_page");
        registry.addViewController("/add_med_ot").setViewName("add_med_otxod");
    }

}