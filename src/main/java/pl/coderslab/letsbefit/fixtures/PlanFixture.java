package pl.coderslab.letsbefit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.letsbefit.entity.Plan;
import pl.coderslab.letsbefit.service.PlanService;

import java.util.Arrays;
import java.util.List;

@Component
public class PlanFixture {

    private final PlanService planService;

    @Autowired
    public PlanFixture(PlanService planService) {
        this.planService = planService;
    }

    private List<Plan> plans = Arrays.asList(
            new Plan(null,"2020-01-01",90.0,"2020-12-31",null),
            new Plan(null,"2020-12-01",74.3,"2020-12-31",null),
            new Plan(null,"2020-06-01",51.6,"2020-12-01",null),
            new Plan(null,"2020-12-10",48.5,"2020-12-20",null),
            new Plan(null,"2020-12-31",69.9,"2021-04-21",null)
    );

    public void loadIntoDB() {

        for (Plan plan : plans) {
            planService.add(plan);
        }
    }

}
