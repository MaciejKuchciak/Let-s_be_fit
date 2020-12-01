package pl.coderslab.letsbefit.service;

import org.springframework.stereotype.Service;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.repository.UserDetailsRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public List<UserDetails> getUsersDetails() {
        return userDetailsRepository.getUsersDetails();
    }

    @Override
    public void add(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetails get(Long id) {
        return userDetailsRepository.getOne(id);
    }

    @Override
    public void remove(Long id) {
        userDetailsRepository.deleteById(id);
    }

    @Override
    public void update(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }
}
