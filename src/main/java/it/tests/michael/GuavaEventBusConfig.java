package it.tests.michael;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GuavaEventBusConfig {

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

}
