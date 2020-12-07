package pl.coderslab.letsbefit.service;

import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {

    List<UserDetails> getAllUsersDetails();

    void add(UserDetails userDetails);

    UserDetails get(Long id);

    void remove(Long id);

    void update(UserDetails userDetails);

    List<User> getUserDetailsByUserLogin(String username);

}
