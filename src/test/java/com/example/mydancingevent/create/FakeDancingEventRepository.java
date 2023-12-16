package com.example.mydancingevent.create;

import com.example.mydancingevent.create.application.port.DancingEventRepository;
import com.example.mydancingevent.create.domain.aggregate.UnpublishedDancingEvents;
import com.example.mydancingevent.create.domain.value.EventOrganizerId;

import java.util.HashMap;
import java.util.Map;

public class FakeDancingEventRepository implements DancingEventRepository {
    private final Map<EventOrganizerId, UnpublishedDancingEvents> unpublishedDancingEvents = new HashMap<>();

    @Override
    public UnpublishedDancingEvents fetchUnpublishedDancingEventsFor(EventOrganizerId eventOrganizerId) {
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
