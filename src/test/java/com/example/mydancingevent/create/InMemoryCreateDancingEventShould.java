package com.example.mydancingevent.create;

import com.example.mydancingevent.create.application.usecase.CreateDancingEventCommand;
import com.example.mydancingevent.create.application.usecase.CreateDancingEventUseCase;
import com.example.mydancingevent.create.domain.value.EventOrganizerId;
import com.example.mydancingevent.create.testing.InjectableTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryCreateDancingEventShould extends InjectableTest {


    @BeforeEach
    void init() {
        dancingEventRepository = new FakeDancingEventRepository();
    }

    @Test
    void create_a_new_dancing_event() {
        var useCase = new CreateDancingEventUseCase(dancingEventRepository);
        var input = new CreateDancingEventCommand("1", "My great new event", "Some words of what to expect from the event", "2021-01-01");

        useCase.execute(input);

        var unpublishedDancingEvents = dancingEventRepository.fetchUnpublishedDancingEventsFor(new EventOrganizerId("1"));
        assertEquals(1, unpublishedDancingEvents.count());

        var newDancingEvent = unpublishedDancingEvents.unpublishedDancingEvents().getFirst();
        assertEquals(input.eventTitle(), newDancingEvent.title().value());
        assertEquals(input.eventDescription(), newDancingEvent.description().value());
        assertEquals(input.eventDate(), newDancingEvent.eventDate().value());
    }
}
