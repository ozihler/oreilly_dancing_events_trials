package com.mydancingevent.creating.domain.entity;

import com.mydancingevent.creating.domain.value.DancingEventId;
import com.mydancingevent.creating.domain.value.Description;
import com.mydancingevent.creating.domain.value.EventDate;
import com.mydancingevent.creating.domain.value.Title;

public record DancingEvent(DancingEventId id, Title title, Description description, EventDate eventDate) {

    public DancingEvent copy() {
        return new DancingEvent(
                new DancingEventId(id().value()),
                new Title(title().value()),
                new Description(description().value()),
                new EventDate(eventDate().value()));
    }
}
