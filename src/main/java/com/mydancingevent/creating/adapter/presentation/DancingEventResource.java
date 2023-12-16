package com.mydancingevent.creating.adapter.presentation;

import com.mydancingevent.creating.application.port.CreateDancingEventCommand;
import com.mydancingevent.creating.application.usecase.CreateDancingEventUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DancingEventResource {

    private final CreateDancingEventUseCase useCase;

    public DancingEventResource(CreateDancingEventUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/dancing-event")
    public void createDancingEvent(@RequestBody CreateDancingEventCommand input) {
        useCase.execute(input);
    }
}
