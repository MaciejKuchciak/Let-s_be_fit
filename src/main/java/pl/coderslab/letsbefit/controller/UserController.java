package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.service.UserService;


@Controller
@RequestMapping("")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("users", new User());
        return "register";
    }

    @PostMapping("/register")
    public String add(User user) {
        userService.add(user);
        return "redirect:/index";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

}
