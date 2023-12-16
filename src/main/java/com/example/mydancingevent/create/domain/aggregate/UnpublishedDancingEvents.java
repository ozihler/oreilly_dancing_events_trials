package com.example.mydancingevent.create.domain.aggregate;

import com.example.mydancingevent.create.domain.entity.DancingEvent;
import com.example.mydancingevent.create.domain.value.EventOrganizerId;

import java.util.ArrayList;
import java.util.List;

public class UnpublishedDancingEvents {
    private EventOrganizerId eventOrganizerId;
    private List<DancingEvent> unpublishedDancingEvents = new ArrayList<>();

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
