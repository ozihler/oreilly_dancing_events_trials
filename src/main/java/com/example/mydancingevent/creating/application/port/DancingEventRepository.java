package com.example.mydancingevent.creating.application.port;

import com.example.mydancingevent.creating.domain.aggregate.UnpublishedDancingEvents;
import com.example.mydancingevent.creating.domain.value.EventOrganizerId;

public interface DancingEventRepository {
    UnpublishedDancingEvents fetchUnpublishedDancingEventsFor(EventOrganizerId eventOrganizerId);

    void update(UnpublishedDancingEvents unpublishedDancingEvents);
}
