package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.app.SecurityUtils;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.entity.Weight;
import pl.coderslab.letsbefit.service.PlanService;
import pl.coderslab.letsbefit.service.UserDetailsService;
import pl.coderslab.letsbefit.service.UserService;
import pl.coderslab.letsbefit.service.WeightService;


@Controller
@RequestMapping("")
public class UserController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final WeightService weightService;
    private final PlanService planService;

    @Autowired
    public UserController(UserService userService, UserDetailsService userDetailsService, WeightService weightService, PlanService planService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.weightService = weightService;
        this.planService = planService;
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
    public String dashboard(Model model) {
        Weight lastWeight = weightService.getLastWeightByUserLogin(SecurityUtils.login());
        model.addAttribute("lastWeight", lastWeight.getCurrentWeight());
        UserDetails userDetails = userDetailsService.getUserDetailsByUserLogin(SecurityUtils.login());
        if (userDetails == null) {
            model.addAttribute("bmr", "Please insert data in \"Calculation Data\" tab");
        } else if (userDetails.getWeights().isEmpty()) {
            model.addAttribute("bmr", "Please insert weight in \"Add Today's Weight\" tab");
        } else {
            model.addAttribute("bmr", userDetailsService.calculateBMR(userDetails));
        }
        return "dashboard";
    }

}
