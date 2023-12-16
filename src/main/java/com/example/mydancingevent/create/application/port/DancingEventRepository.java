package com.example.mydancingevent.create.application.port;

import com.example.mydancingevent.create.domain.aggregate.UnpublishedDancingEvents;
import com.example.mydancingevent.create.domain.value.EventOrganizerId;

public interface DancingEventRepository {
    UnpublishedDancingEvents fetchUnpublishedDancingEventsFor(EventOrganizerId eventOrganizerId);

    void update(UnpublishedDancingEvents unpublishedDancingEvents);
}
