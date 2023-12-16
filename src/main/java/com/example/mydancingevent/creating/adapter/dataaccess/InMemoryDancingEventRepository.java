package com.example.mydancingevent.creating.adapter.dataaccess;

import com.example.mydancingevent.creating.application.port.DancingEventRepository;
import com.example.mydancingevent.creating.domain.aggregate.UnpublishedDancingEvents;
import com.example.mydancingevent.creating.domain.value.EventOrganizerId;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Profile("test")
@Repository
public class InMemoryDancingEventRepository implements DancingEventRepository {
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
        System.out.println("Dancing event added! "+unpublishedDancingEvents.unpublishedDancingEvents());
    }
}
