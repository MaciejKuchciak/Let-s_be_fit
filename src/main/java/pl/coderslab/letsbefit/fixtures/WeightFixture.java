package pl.coderslab.letsbefit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.letsbefit.entity.Weight;
import pl.coderslab.letsbefit.service.WeightService;

import java.util.Arrays;
import java.util.List;

@Component
public class WeightFixture {

    private final WeightService weightService;

    @Autowired
    public WeightFixture(WeightService weightService) {
        this.weightService = weightService;
    }

    private List<Weight> weights = Arrays.asList(
            new Weight(null, "2020-12-01", 101.0, null),
            new Weight(null, "2020-12-01", 91.3, null),
            new Weight(null, "2020-12-01", 41.2, null),
            new Weight(null, "2020-12-01", 67.5, null),
            new Weight(null, "2020-12-01", 88.9, null)
    );


    public void loadIntoDB() {

        for (Weight weight : weights) {
            weightService.add(weight);
        }
    }

}
