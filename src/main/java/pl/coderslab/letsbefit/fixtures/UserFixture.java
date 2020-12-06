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
public class UserFixture {

    private final UserService userService;
    private final PlanService planService;

    @Autowired
    public UserFixture(UserService usersService, PlanService planService) {
        this.userService = usersService;
        this.planService = planService;
    }

    private final List<User> userList = Arrays.asList(
            new User(null, "maciek", "Maciej", "Kuchciak", "maciek@mail.com", "123",1,1,null,null),
            new User(null, "jedrek", "Andrzej", "Jasiński", "jedrek@mail.com", "123",0, 1,null,null),
            new User(null, "monia", "Monika", "Pawlik", "pawel@mail.com", "123",0,1,null,null),
            new User(null, "zosia", "Zofia", "Kowalska", "kowal@mail.com", "123",0, 1,null,null),
            new User(null, "marian", "Mieczysław", "Ziombek", "ziom@mail.com", "123",0, 1,null,null)
    );

    public void loadIntoDB() {

        List<Plan> planList = planService.getAllPlans();

        for (User users : userList) {
            userService.add(users);
        }

        User user1 = userList.get(0);
        User user2 = userList.get(1);
        User user3 = userList.get(2);
        User user4 = userList.get(3);
        User user5 = userList.get(4);

        user1.setPlan(planList.get(0));
        user2.setPlan(planList.get(1));
        user3.setPlan(planList.get(2));
        user4.setPlan(planList.get(3));
        user5.setPlan(planList.get(4));

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        userService.add(user5);
    }
}
