package com.example.mydancingevent.create;

public class CreateDancingEventUseCase {
    private final DancingEventRepository dancingEventRepository;

    public CreateDancingEventUseCase(DancingEventRepository dancingEventRepository) {
        this.dancingEventRepository = dancingEventRepository;
    }

    public void execute(CreateDancingEventCommand input) {
        UnpublishedDancingEvents unpublishedDancingEvents = dancingEventRepository
                .fetchForEventOrganizerWithId(new EventOrganizerId(input.eventOrganizerId()));

        unpublishedDancingEvents.add(new DancingEvent(DancingEventId.newRandomId(), new Title(input.eventTitle()), new Description(input.eventDescription()), new EventDate(input.eventDate())));

        dancingEventRepository.update(unpublishedDancingEvents);
    }
}
