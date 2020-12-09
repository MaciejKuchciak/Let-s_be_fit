package pl.coderslab.letsbefit.service;

import pl.coderslab.letsbefit.entity.Plan;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.Weight;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    boolean checkPasswordForRegister(String pass1, String pass2);

    List<User> getAllUsers();

    void add(User user);

    User get(Long id);

    void remove(Long id);

    void update(User user);

    User getByLogin(String login);

    LocalDate forecastRealDate(Plan plan, Weight weight);

}
