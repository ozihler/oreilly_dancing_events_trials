package com.example.mydancingevent.create;

public record DancingEvent(DancingEventId id, Title title, Description description, EventDate eventDate) {

    public DancingEvent copy() {
        return new DancingEvent(
                new DancingEventId(id().value()),
                new Title(title().value()),
                new Description(description().value()),
                new EventDate(eventDate().value()));
    }
}
