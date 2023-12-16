package com.mydancingevent.creating.domain.aggregate;

import com.mydancingevent.creating.domain.entity.DancingEvent;
import com.mydancingevent.creating.domain.value.EventOrganizerId;

import java.util.ArrayList;
import java.util.List;

public class UnpublishedDancingEvents {
    private final EventOrganizerId eventOrganizerId;
    private final List<DancingEvent> unpublishedDancingEvents = new ArrayList<>();

    public UnpublishedDancingEvents(EventOrganizerId eventOrganizerId) {
        this.eventOrganizerId = eventOrganizerId;
    }

    public int count() {
        return unpublishedDancingEvents.size();
    }

    public void add(DancingEvent dancingEvent) {
        this.unpublishedDancingEvents.add(dancingEvent);
    }

    public EventOrganizerId eventOrganizerId() {
        return this.eventOrganizerId;
    }

    public List<DancingEvent> unpublishedDancingEvents() {
        return this.unpublishedDancingEvents.stream()
                .map(DancingEvent::copy)
                .toList();
    }

}
