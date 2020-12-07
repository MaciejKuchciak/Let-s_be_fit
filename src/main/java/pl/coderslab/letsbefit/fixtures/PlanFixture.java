package pl.coderslab.letsbefit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.letsbefit.entity.Plan;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.service.PlanService;
import pl.coderslab.letsbefit.service.UserService;

import java.util.Arrays;
import java.util.List;

@Component
public class PlanFixture {

    private final PlanService planService;
    private final UserService userService;

    @Autowired
    public PlanFixture(PlanService planService, UserService userService) {
        this.planService = planService;
        this.userService = userService;
    }

    private List<Plan> plans = Arrays.asList(
            new Plan(null,"2020-01-01",90.0,"2020-12-31",null),
            new Plan(null,"2020-12-01",74.3,"2020-12-31",null),
            new Plan(null,"2020-06-01",51.6,"2020-12-01",null),
            new Plan(null,"2020-12-10",48.5,"2020-12-20",null),
            new Plan(null,"2020-12-31",69.9,"2021-04-21",null)
    );

    public void loadIntoDB() {

        List<User> userList = userService.getAllUsers();

        for (Plan plan : plans) {
            planService.add(plan);
        }

        Plan plan1 = plans.get(0);
        Plan plan2 = plans.get(1);
        Plan plan3 = plans.get(2);
        Plan plan4 = plans.get(3);
        Plan plan5 = plans.get(4);

        plan1.setUser(userList.get(0));
        plan2.setUser(userList.get(1));
        plan3.setUser(userList.get(2));
        plan4.setUser(userList.get(3));
        plan5.setUser(userList.get(4));

        planService.add(plan1);
        planService.add(plan2);
        planService.add(plan3);
        planService.add(plan4);
        planService.add(plan5);
    }

}
