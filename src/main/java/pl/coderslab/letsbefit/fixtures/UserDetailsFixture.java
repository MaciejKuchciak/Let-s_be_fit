package pl.coderslab.letsbefit.fixtures;

import org.springframework.stereotype.Component;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.service.UserDetailsService;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDetailsFixture {

    private UserDetailsService userDetailsService;

    private List<UserDetails> userDetailsList = Arrays.asList(
            new UserDetails(null, "Jeżyk", "male", "2020-12-11", 94.2),
            new UserDetails(null, "Śnieżek", "male", "2020-12-11", 84.6),
            new UserDetails(null, "Zenon", "female", "2020-12-11", 74.2),
            new UserDetails(null, "Farba", "female", "2020-12-11", 64.3)

    );

    public void loadIntoDB() {

        for (UserDetails userDetails : userDetailsList) {
            userDetailsService.add(userDetails);
        }
    }
}
