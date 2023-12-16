package com.example.mydancingevent.create.adapter.presentation;

import com.example.mydancingevent.create.application.port.CreateDancingEventCommand;
import com.example.mydancingevent.create.application.usecase.CreateDancingEventUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DancingEventResource {

    private final CreateDancingEventUseCase useCase;

    public DancingEventResource(CreateDancingEventUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/dancing-event")
    public void createDancingEvent(CreateDancingEventCommand input) {
        useCase.execute(input);
    }
}
