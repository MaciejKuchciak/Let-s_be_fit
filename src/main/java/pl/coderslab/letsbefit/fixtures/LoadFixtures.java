package pl.coderslab.letsbefit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoadFixtures {

    private UserFixture userFixture;
    private UserDetailsFixture userDetailsFixture;

    @Autowired
    public LoadFixtures(UserFixture userFixture, UserDetailsFixture userDetailsFixture){
        this.userFixture = userFixture;
        this.userDetailsFixture = userDetailsFixture;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup(){
        userFixture.loadIntoDB();
        userDetailsFixture.loadIntoDB();
    }
}
