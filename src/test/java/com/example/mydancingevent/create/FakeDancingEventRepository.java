package com.example.mydancingevent.create;

import ch.qos.logback.classic.util.LogbackMDCAdapterSimple;

import java.util.HashMap;
import java.util.Map;

public class FakeDancingEventRepository implements DancingEventRepository {
    private final Map<EventOrganizerId, UnpublishedDancingEvents> unpublishedDancingEvents = new HashMap<>();

    @Override
    public UnpublishedDancingEvents fetchForEventOrganizerWithId(EventOrganizerId eventOrganizerId) {
        if (!unpublishedDancingEvents.containsKey(eventOrganizerId)) {
            unpublishedDancingEvents.put(eventOrganizerId, new UnpublishedDancingEvents(eventOrganizerId));
        }
        return unpublishedDancingEvents.get(eventOrganizerId);
    }

    @Override
    public void update(UnpublishedDancingEvents unpublishedDancingEvents) {
        this.unpublishedDancingEvents.put(unpublishedDancingEvents.eventOrganizerId(), unpublishedDancingEvents);
    }
}
