package com.example.mydancingevent.create;

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
}
