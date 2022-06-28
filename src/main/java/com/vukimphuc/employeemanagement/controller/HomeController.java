package com.vukimphuc.employeemanagement.controller;

import com.vukimphuc.employeemanagement.entity.User;
import com.vukimphuc.employeemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/")
    public String login(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "login";
    }

    @GetMapping("/register")
    public String loadPageRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register(User user, Model model) {
        // validate user
        boolean valid = true;
        String userNameMessage = "";
        String passwordMessage = "";
        String emailMessage = "";
        List<User> users = userService.getAll();
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                userNameMessage = "Username already exist!";
                valid = false;
            }
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                emailMessage = "Email already exist!";
                valid = false;
            }
        }
        if (user.getPassword().length() < 4) {
            passwordMessage = "Password must be at least 4 character!";
            valid = false;
        }
        if (valid == false) {
            model.addAttribute("userNameMessage", userNameMessage);
            model.addAttribute("passwordMessage", passwordMessage);
            model.addAttribute("emailMessage", emailMessage);
            model.addAttribute("user", user);
            return "register";
        }

        // send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Welcome to our system!");
        message.setText("Here is your account to login our system: \n" +
                "Username: " + user.getUsername()
                + "\n Password: " + user.getPassword());
        javaMailSender.send(message);
        userService.saveOrUpdate(user);
        return "redirect:/login";


    }
}
