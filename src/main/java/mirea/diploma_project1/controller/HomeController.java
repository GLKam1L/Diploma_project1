package mirea.diploma_project1.controller;

import mirea.diploma_project1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import mirea.diploma_project1.domain.User;
import mirea.diploma_project1.repo.UserRepo;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null ){
            model.addAttribute("user", user.getUsername());
            model.addAttribute("role", user.getRoles());
            model.addAttribute("name", user.getName());
            return "index";
        }

        model.addAttribute("user", "anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}