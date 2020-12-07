package pl.coderslab.letsbefit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.service.UserDetailsService;
import pl.coderslab.letsbefit.service.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class UserDetailsFixture {

    private final UserDetailsService userDetailsService;
    private final UserService userService;

    @Autowired
    public UserDetailsFixture(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    private List<UserDetails> userDetailsList = Arrays.asList(
            new UserDetails(null, "male", LocalDate.of(1980,12,11),196, 1.2),
            new UserDetails(null, "male", LocalDate.of(2000,1,28),182, 1.375),
            new UserDetails(null, "female", LocalDate.of(2008, 7, 1),164, 1.55),
            new UserDetails(null, "female", LocalDate.of(1991,10,7),155, 1.725),
            new UserDetails(null, "male", LocalDate.of(1972,8,31),175, 1.9)

    );

    public void loadIntoDB() {

        List<User> userList = userService.getAllUsers();

        for (UserDetails userDetails : userDetailsList) {
            userDetailsService.add(userDetails);
        }

        UserDetails userDetails1 = userDetailsList.get(0);
        UserDetails userDetails2 = userDetailsList.get(1);
        UserDetails userDetails3 = userDetailsList.get(2);
        UserDetails userDetails4 = userDetailsList.get(3);
        UserDetails userDetails5 = userDetailsList.get(4);

        userDetails1.setUser(userList.get(0));
        userDetails2.setUser(userList.get(1));
        userDetails3.setUser(userList.get(2));
        userDetails4.setUser(userList.get(3));
        userDetails5.setUser(userList.get(4));

        userDetailsService.add(userDetails1);
        userDetailsService.add(userDetails2);
        userDetailsService.add(userDetails3);
        userDetailsService.add(userDetails4);
        userDetailsService.add(userDetails5);

    }
}
