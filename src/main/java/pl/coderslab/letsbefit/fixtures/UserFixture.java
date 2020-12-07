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
            new User(null, "maciek", "Maciej", "Kuchciak", "maciek@mail.com", "123",1,1),
            new User(null, "jedrek", "Andrzej", "Jasiński", "jedrek@mail.com", "123",0, 1),
            new User(null, "monia", "Monika", "Pawlik", "pawel@mail.com", "123",0,1),
            new User(null, "zosia", "Zofia", "Kowalska", "kowal@mail.com", "123",0, 1),
            new User(null, "marian", "Mieczysław", "Ziombek", "ziom@mail.com", "123",0, 1)
    );

    public void loadIntoDB() {

        for (User users : userList) {
            userService.add(users);
        }
    }
}
