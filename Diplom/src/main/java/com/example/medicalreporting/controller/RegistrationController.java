package com.example.medicalreporting.controller;

import com.example.medicalreporting.model.UserEntity;

import com.example.medicalreporting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * Класс контроллер используется для регистрации новых пользователей и отображении формы регистрации
 * Created by Antonova Ksenia.
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserEntity());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid UserEntity userEntityForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!userService.saveUser(userEntityForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/login";
    }
}