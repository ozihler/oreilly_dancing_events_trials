package com.example.mydancingevent.create;

public interface DancingEventRepository {
    UnpublishedDancingEvents fetchUnpublishedDancingEventsFor(EventOrganizerId eventOrganizerId);

    void update(UnpublishedDancingEvents unpublishedDancingEvents);
}
