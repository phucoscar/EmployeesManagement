package com.vukimphuc.employeemanagement.controller;

import com.vukimphuc.employeemanagement.entity.Submission;
import com.vukimphuc.employeemanagement.entity.User;
import com.vukimphuc.employeemanagement.entity.Work;
import com.vukimphuc.employeemanagement.service.SubmissionService;
import com.vukimphuc.employeemanagement.service.UserService;
import com.vukimphuc.employeemanagement.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private WorkService workService;

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private JavaMailSender javaMailSender;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/listUser")
    public String home(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin/listUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/addEmployee")
    public String loadPageAdd(Model model) {
        model.addAttribute("user", new User());
        return "admin/addUser";
    }

    @PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addEmployee(User user, Model model) {
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
            return "admin/addUser";
        }


        //send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Welcome to our system!");
        message.setText("Here is your account to login our system: \n" +
                "Username: " + user.getUsername()
                + "\nPassword: " + user.getPassword());
        javaMailSender.send(message);
        userService.saveOrUpdate(user);
        return "redirect:/listUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/editEmployee/{id}")
    public String loadPageEdit(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin/editUser";
    }

    @PostMapping(value = "/editEmployee", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String edit(User user) {
        userService.saveOrUpdate(user);
        return "redirect:/listUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/deleteEmployee/{id}")
    public String loadPageConfirm(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "admin/confirmDelete";
    }

    @PostMapping("/deleteEmployee/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/listUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/addWork")
    public String loadPageAddWork(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/addWork";
    }

    @PostMapping(value = "/addWork", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addWork(Work work) {
        workService.saveOrUpdate(work);
        return "redirect:/";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/deleteWork/{userID}/{workID}")
    public String loadPageConfirmDeleteWork(@PathVariable Long userID, @PathVariable Long workID, Model model) {
        model.addAttribute("workID", workID);
        model.addAttribute("userID", userID);
        return "admin/confirmDeleteWork";
    }

    @PostMapping("/deleteWork/{userID}/{workID}")
    public String deleteWork(@PathVariable Long userID, @PathVariable Long workID) {
        workService.deleteById(workID);
        return "redirect:/listWork/" + userID;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/listWork/{id}")
    public String loadPageListWork(@PathVariable Long id, Model model) {
        model.addAttribute("works", workService.getAllById(id));
        model.addAttribute("id", id);
        return "admin/listWork";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/viewSubmission/{userID}/{workID}")
    public String loadPageSubmission(@PathVariable Long userID, @PathVariable Long workID, Model model) {
        Submission submission = submissionService.findByUserIDAndWorkID(userID, workID);
        System.out.println(submission.getContent());
        model.addAttribute("submission", submission);
        model.addAttribute("userID", userID);
        return "admin/submittedWork";
    }
}
