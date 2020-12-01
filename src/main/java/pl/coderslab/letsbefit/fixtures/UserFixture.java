package pl.coderslab.letsbefit.fixtures;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.service.UserDetailsService;
import pl.coderslab.letsbefit.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserFixture {

    private UserService userService;
    private UserDetailsService userDetailsService;

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private List<User> userList = Arrays.asList(
            new User(null, "Jan", "Nowak", "jasosik@mail.com", "xyza", 1,1,null),
            new User(null, "Andrzej", "Jasiński", "jedrek@mail.com", null, 0,1, null),
            new User(null, "Monika", "Pawlik", "pawel@mail.com", null, 0,1,null),
            new User(null, "Zofia", "Kowalska", "kowal@mail.com", "null", 0,1, null)
    );

    @Autowired
    public UserFixture(UserService usersService, UserDetailsService userDetailsService) {
        this.userService = usersService;
        this.userDetailsService = userDetailsService;
    }

    public void loadIntoDB() {

        List<UserDetails> userDetailsList = userDetailsService.getUsersDetails();

        for (User users : userList) {
            users.setPassword(hashPassword(users.getPassword()));
            userService.add(users);
        }
        User user1 = userList.get(0);
        User user2 = userList.get(1);
        User user3 = userList.get(2);
        User user4 = userList.get(3);

        user1.setUserDetails(userDetailsList.get(0));
        user2.setUserDetails(userDetailsList.get(1));
        user3.setUserDetails(userDetailsList.get(2));
        user4.setUserDetails(userDetailsList.get(3));
    }
}
