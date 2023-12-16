package com.mydancingevent.creating.application.port;

import com.mydancingevent.creating.domain.aggregate.UnpublishedDancingEvents;
import com.mydancingevent.creating.domain.value.EventOrganizerId;

public interface DancingEventRepository {
    UnpublishedDancingEvents fetchUnpublishedDancingEventsFor(EventOrganizerId eventOrganizerId);

    void update(UnpublishedDancingEvents unpublishedDancingEvents);
}
