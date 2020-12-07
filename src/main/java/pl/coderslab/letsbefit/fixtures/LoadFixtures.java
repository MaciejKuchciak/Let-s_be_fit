package pl.coderslab.letsbefit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoadFixtures {

    private final UserFixture userFixture;
    private final UserDetailsFixture userDetailsFixture;
    private final ProductFixture productFixture;
    private final PlanFixture planFixture;
    private final WeightFixture weightFixture;

    @Autowired
    public LoadFixtures(UserFixture userFixture, UserDetailsFixture userDetailsFixture, ProductFixture productFixture, PlanFixture planFixture, WeightFixture weightFixture){
        this.userFixture = userFixture;
        this.userDetailsFixture = userDetailsFixture;
        this.productFixture = productFixture;
        this.planFixture = planFixture;
        this.weightFixture = weightFixture;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup(){
        userFixture.loadIntoDB();
        planFixture.loadIntoDB();
        userDetailsFixture.loadIntoDB();
        weightFixture.loadIntoDB();
        productFixture.loadIntoDB();
    }
}
