package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.app.SecurityUtils;
import pl.coderslab.letsbefit.entity.Plan;
import pl.coderslab.letsbefit.service.PlanService;

import java.util.List;

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
        List<Plan> plans = planService.getPlanByUserLogin(SecurityUtils.login());
        model.addAttribute("plans", plans);
        return "plan";
    }
}
