package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.app.SecurityUtils;
import pl.coderslab.letsbefit.entity.Plan;
import pl.coderslab.letsbefit.service.PlanService;

@Controller
@RequestMapping("plan")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("")
    public String plan(Model model) {
        Plan plan = planService.getPlanByUserLogin(SecurityUtils.login());
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
