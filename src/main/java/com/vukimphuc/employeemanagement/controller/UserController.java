package com.vukimphuc.employeemanagement.controller;

import com.vukimphuc.employeemanagement.entity.Submission;
import com.vukimphuc.employeemanagement.entity.User;
import com.vukimphuc.employeemanagement.entity.Work;
import com.vukimphuc.employeemanagement.service.SubmissionService;
import com.vukimphuc.employeemanagement.service.UserService;
import com.vukimphuc.employeemanagement.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WorkService workService;

    @Autowired
    private SubmissionService submissionService;

    @GetMapping("/completedWork/{userId}/{workId}")
    public String completedWork(@PathVariable Long userId, @PathVariable Long workId) {
        Work work = workService.findById(workId);
        workService.updateStatus(work);
        return "redirect:/listWork/" + userId;
    }

    @GetMapping("/myWork")
    public String loadPageMyWork(Model model) {
        User user = getCurrentUser();
        List<Work> works = workService.getAllById(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("works", works);
        return "myWork";
    }

    @GetMapping("/submitWork/{workID}")
    public String loadPageSubmitWork(@PathVariable Long workID,Model model) {
        User user = getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("workID", workID);
        return "submitWork";
    }

    @PostMapping(value = "/submitWork/{workID}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String submitWork(@PathVariable Long workID, Submission submission) {
        Work work = workService.findById(workID);
        workService.updateStatus(work);
        submissionService.saveOrUpdate(submission);
        return "redirect:/myWork";
    }

    public User getCurrentUser() {
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return user;
    }
}
