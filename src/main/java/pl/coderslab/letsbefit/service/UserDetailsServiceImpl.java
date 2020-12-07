package pl.coderslab.letsbefit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.repository.UserDetailsRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserDetailsRepository userDetailsRepository;
    @Autowired
    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public List<UserDetails> getAllUsersDetails() {
        return userDetailsRepository.findAll();
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

    @Override
    public UserDetails getUserDetailsByUserLogin(String username) {
        return userDetailsRepository.getUserDetailsByUserLogin(username);
    }

    public int calculateBMR(UserDetails userDetails){
        double rate;
        LocalDate bDate = userDetails.getBirthday();
        double lastWeight = userDetails.getWeights().get(userDetails.getWeights().size()-1).getCurrentWeight();

        if(userDetails.getSex().equals("male")){
            rate = (66 + (13.7 * lastWeight + (5 * userDetails.getHeight()) - (6.8 * (Period.between(bDate, LocalDate.now()).getYears()))) * userDetails.getActivity());
        } else {
            rate = (655 + (9.6 * lastWeight + (1.8 * userDetails.getHeight()) - (4.7 * (Period.between(bDate, LocalDate.now()).getYears()))) * userDetails.getActivity());
        }
        return (int) Math.round(rate);
    }
}
