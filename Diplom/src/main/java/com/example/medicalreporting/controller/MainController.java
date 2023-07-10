package com.example.medicalreporting.controller;

import com.example.medicalreporting.model.UserEntity;
import com.example.medicalreporting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Класс контроллер включает в себя метод для отображение главной страницы
 * и передачи названии организации из бд на страницу
 * Также метод для поиска по шаблонам
 * Created by Antonova Ksenia.
 */
@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String home(@AuthenticationPrincipal UserDetails user, Model model) {
        UserEntity u = userRepository.findByUsername(user.getUsername());
        model.addAttribute("currentUser", u);
        return "main_page";
    }

    //Метод для поиска
    public String search() {
        return null;
    }
}
