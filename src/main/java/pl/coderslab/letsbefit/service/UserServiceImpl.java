package pl.coderslab.letsbefit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkPasswordForRegister(String pass1, String pass2) {
        return (
                pass1.equals(pass2) &&
                        pass1.matches(".{8,}") &&
                        pass1.matches("^.*\\d+.*$") &&
                        pass1.matches("^.*[a-zA-Z]+.*$")
        );
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }
}
