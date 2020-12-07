package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.app.SecurityUtils;
import pl.coderslab.letsbefit.entity.Weight;
import pl.coderslab.letsbefit.service.WeightService;
import java.util.List;

@Controller
@RequestMapping("weight")
public class WeightController {

    private final WeightService weightService;

    @Autowired
    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping("")
    public String weight(Model model) {
        List<Weight> weights = weightService.getWeightByUserLogin(SecurityUtils.login());
        model.addAttribute("weight", weights);
        return "weight";
    }
}
