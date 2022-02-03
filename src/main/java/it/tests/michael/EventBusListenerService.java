package it.tests.michael;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EventBusListenerService {

    public static class EventBusListener {

        private final static Logger log = LoggerFactory.getLogger(EventBusListener.class);

        @Subscribe
        public void stringMsgHandler(String msg) {
            log.info(msg);
        }
    }

    private EventBus eventBus;

    @Autowired
    public EventBusListenerService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @PostConstruct
    public void registerListener() {
        eventBus.register(new EventBusListener());
    }
}
