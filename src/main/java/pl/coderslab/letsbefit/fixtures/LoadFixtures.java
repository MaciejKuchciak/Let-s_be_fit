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

    @Autowired
    public LoadFixtures(UserFixture userFixture, UserDetailsFixture userDetailsFixture, ProductFixture productFixture){
        this.userFixture = userFixture;
        this.userDetailsFixture = userDetailsFixture;
        this.productFixture = productFixture;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup(){
        userFixture.loadIntoDB();
        userDetailsFixture.loadIntoDB();
        productFixture.loadIntoDB();
    }
}
