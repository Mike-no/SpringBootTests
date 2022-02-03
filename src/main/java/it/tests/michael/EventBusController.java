package it.tests.michael;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventBusController {

    private EventBus eventBus;

    @Autowired
    public EventBusController(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @PostMapping("/msg")
    public ResponseEntity<Void> postOnEventBus(@RequestParam String msg) {
        eventBus.post(msg);
        return ResponseEntity.ok().build();
    }
}
