package pl.coderslab.letsbefit.service;

import pl.coderslab.letsbefit.entity.User;

import java.util.List;

public interface UserService {

    boolean checkPasswordForRegister(String pass1, String pass2);

    List<User> getAllUsers();

    void add(User user);

    User get(Long id);

    void remove(Long id);

    void update(User user);

    User getByLogin(String login);


}
