package pl.coderslab.letsbefit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.letsbefit.entity.UserDetails;
import pl.coderslab.letsbefit.entity.Weight;
import pl.coderslab.letsbefit.service.UserDetailsService;
import pl.coderslab.letsbefit.service.WeightService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class WeightFixture {

    private final WeightService weightService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public WeightFixture(WeightService weightService, UserDetailsService userDetailsService) {
        this.weightService = weightService;
        this.userDetailsService = userDetailsService;
    }

    private List<Weight> weights = Arrays.asList(
            new Weight(null, LocalDate.of(2020,12,1), 101.0,null),
            new Weight(null, LocalDate.of(2020,12,1), 91.3,null),
            new Weight(null, LocalDate.of(2020,12,1), 41.2, null),
            new Weight(null, LocalDate.of(2020,12,1), 67.5, null),
            new Weight(null, LocalDate.of(2020,12,1), 88.9,null),
            new Weight(null, LocalDate.of(2020,12,2), 100.6,null),
            new Weight(null, LocalDate.of(2020,12,3), 100.1,null),
            new Weight(null, LocalDate.of(2020,12,4), 99.4,null)
            );

    public void loadIntoDB() {

        for (Weight weight : weights) {
            weightService.add(weight);
        }

        List<UserDetails> userDetailsList = userDetailsService.getAllUsersDetails();

        Weight weight1 = weights.get(0);
        Weight weight2 = weights.get(1);
        Weight weight3 = weights.get(2);
        Weight weight4 = weights.get(3);
        Weight weight5 = weights.get(4);
        Weight weight6 = weights.get(5);
        Weight weight7 = weights.get(6);
        Weight weight8 = weights.get(7);

        weight1.setUserDetails(userDetailsList.get(0));
        weight2.setUserDetails(userDetailsList.get(1));
        weight3.setUserDetails(userDetailsList.get(2));
        weight4.setUserDetails(userDetailsList.get(3));
        weight5.setUserDetails(userDetailsList.get(4));
        weight6.setUserDetails(userDetailsList.get(0));
        weight7.setUserDetails(userDetailsList.get(0));
        weight8.setUserDetails(userDetailsList.get(0));

        weightService.add(weight1);
        weightService.add(weight2);
        weightService.add(weight3);
        weightService.add(weight4);
        weightService.add(weight5);
        weightService.add(weight6);
        weightService.add(weight7);
        weightService.add(weight8);

    }

}
