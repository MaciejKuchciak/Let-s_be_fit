package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.app.SecurityUtils;
import pl.coderslab.letsbefit.entity.Plan;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.entity.Weight;
import pl.coderslab.letsbefit.service.PlanService;
import pl.coderslab.letsbefit.service.UserDetailsService;
import pl.coderslab.letsbefit.service.WeightService;

import java.util.List;


@Controller
@RequestMapping("weight")
public class WeightController {

    private final WeightService weightService;
    private final UserDetailsService userDetailsService;
    private final PlanService planService;

    @Autowired
    public WeightController(WeightService weightService, UserDetailsService userDetailsService, PlanService planService) {
        this.weightService = weightService;
        this.userDetailsService = userDetailsService;
        this.planService = planService;
    }

    @GetMapping("")
    public String weight(Model model) {
        UserDetails userDetails = userDetailsService.getUserDetailsByUserLogin(SecurityUtils.login());
        Plan plan = planService.getPlanByUserLogin(SecurityUtils.login());
        if(userDetails == null || plan == null){
            return "redirect:/dashboard";
        }
        UserDetails userDetailsId = userDetailsService.get(userDetails.getId());
        Weight lastWeight = weightService.getLastWeightByUserLogin(SecurityUtils.login());
        model.addAttribute("userDetailsId",userDetailsId);
        model.addAttribute("newWeight", new Weight());
        model.addAttribute("lastWeight", lastWeight);
        int numbersOfWeights = weightService.weightsQuantity(SecurityUtils.login());
        model.addAttribute("numbersOfWeights",numbersOfWeights);
        return "weight";
    }

    @PostMapping("")
    public String addWeight(Weight weight){
        weightService.add(weight);
        return "redirect:/dashboard";
    }

    @GetMapping("progress-chart")
    public String progressChart(Model model) {
        List<Weight> weights = weightService.getAllWeightsByUserLogin(SecurityUtils.login());
        model.addAttribute("weights",weights);
        return "progress-chart";
    }
}