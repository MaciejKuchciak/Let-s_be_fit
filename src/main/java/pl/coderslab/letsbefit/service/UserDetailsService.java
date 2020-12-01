package pl.coderslab.letsbefit.service;

import pl.coderslab.letsbefit.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {

    List<UserDetails> getUsersDetails();

    void add(UserDetails userDetails);

    UserDetails get(Long id);

    void remove(Long id);

    void update(UserDetails userDetails);
}
