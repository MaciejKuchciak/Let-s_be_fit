package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.app.SecurityUtils;
import pl.coderslab.letsbefit.entity.Plan;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.service.PlanService;
import pl.coderslab.letsbefit.service.UserService;

@Controller
@RequestMapping("plan")
public class PlanController {

    private final PlanService planService;
    private final UserService userService;

    @Autowired
    public PlanController(PlanService planService, UserService userService) {
        this.planService = planService;
        this.userService = userService;
    }

    @GetMapping("")
    public String plan(Model model) {
        User user = userService.getByLogin(SecurityUtils.login());
        User userId = userService.get(user.getId());
        Plan plan = planService.getPlanByUserLogin(SecurityUtils.login());
        model.addAttribute("userId",userId);
        model.addAttribute("newPlan", new Plan());
        model.addAttribute("plan", plan);
        int numbersOfPlans = planService.plansQuantity(SecurityUtils.login());
        model.addAttribute("numbersOfPlans", numbersOfPlans);
        return "plan";
    }

    @PostMapping
    public String addPlan(Plan plan){
        planService.add(plan);
        return "redirect:/plan";
    }
}
