package pl.coderslab.letsbefit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.repository.UserDetailsRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserDetailsRepository userDetailsRepository;

    @Autowired
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

    public int calculateBMR(UserDetails userDetails){
        double rate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bDate = LocalDate.parse(userDetails.getBirthday(), formatter);

        if(userDetails.getSex().equals("male")){
            rate = 66 + (13.7 * userDetails.getWeight()) + (5 * userDetails.getHeight()) - (6.8 * (Period.between(bDate, LocalDate.now()).getYears()));
        } else {
            rate = 655 + (9.6 * userDetails.getWeight()) + (1.8 * userDetails.getHeight()) - (4.7 * (Period.between(bDate, LocalDate.now()).getYears()));
        }
        int rateInt = (int) Math.round(rate);
        return rateInt;
    }
}
