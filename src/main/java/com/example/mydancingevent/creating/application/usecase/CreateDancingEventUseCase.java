package com.example.mydancingevent.creating.application.usecase;

import com.example.mydancingevent.creating.application.exception.DancingEventCreationFailed;
import com.example.mydancingevent.creating.application.port.CreateDancingEvent;
import com.example.mydancingevent.creating.application.port.CreateDancingEventCommand;
import com.example.mydancingevent.creating.application.port.DancingEventRepository;
import com.example.mydancingevent.creating.domain.entity.DancingEvent;
import com.example.mydancingevent.creating.domain.value.*;
import org.springframework.stereotype.Service;

@Service
public class CreateDancingEventUseCase implements CreateDancingEvent {
    private final DancingEventRepository dancingEventRepository;

    public CreateDancingEventUseCase(DancingEventRepository dancingEventRepository) {
        this.dancingEventRepository = dancingEventRepository;
    }

    @Override
    public void execute(CreateDancingEventCommand input) {
        try {
            var eventOrganizerId = new EventOrganizerId(input.eventOrganizerId());

            var unpublishedDancingEvents = dancingEventRepository
                    .fetchUnpublishedDancingEventsFor(eventOrganizerId);

            var dancingEvent = new DancingEvent(
                    DancingEventId.newRandomId(),
                    new Title(input.eventTitle()),
                    new Description(input.eventDescription()),
                    new EventDate(input.eventDate()));

            unpublishedDancingEvents.add(dancingEvent);

            dancingEventRepository.update(unpublishedDancingEvents);

        } catch (Exception e) {
            throw new DancingEventCreationFailed(e);
        }
    }
}
