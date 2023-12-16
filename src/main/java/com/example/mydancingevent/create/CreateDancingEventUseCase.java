package com.example.mydancingevent.create;

public class CreateDancingEventUseCase {
    private final DancingEventRepository dancingEventRepository;

    public CreateDancingEventUseCase(DancingEventRepository dancingEventRepository) {
        this.dancingEventRepository = dancingEventRepository;
    }

    public void execute(CreateDancingEventCommand input) {
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
    }
}
