package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.app.SecurityUtils;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.entity.Weight;
import pl.coderslab.letsbefit.service.UserDetailsService;
import pl.coderslab.letsbefit.service.WeightService;

@Controller
@RequestMapping("weight")
public class WeightController {

    private final WeightService weightService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public WeightController(WeightService weightService, UserDetailsService userDetailsService) {
        this.weightService = weightService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("")
    public String weight(Model model) {
        UserDetails userDetails = userDetailsService.getUserDetailsByUserLogin(SecurityUtils.login());
        if(userDetails == null){
            return "redirect:/dashboard";
        }
        UserDetails userDetailsId = userDetailsService.get(userDetails.getId());
        model.addAttribute("userDetailsId",userDetailsId);
        model.addAttribute("weight", new Weight());
        return "weight";
    }

    @PostMapping("")
    public String addWeight(Weight weight){
        weightService.add(weight);
        return "redirect:/dashboard";
    }

}