package com.example.mydancingevent.create;

public interface DancingEventRepository {
    UnpublishedDancingEvents fetchForEventOrganizerWithId(EventOrganizerId eventOrganizerId);

    void update(UnpublishedDancingEvents unpublishedDancingEvents);
}
