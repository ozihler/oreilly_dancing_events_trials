package com.example.mydancingevent.creating.application.port;

public record CreateDancingEventCommand(String eventOrganizerId,
                                        String eventTitle,
                                        String eventDescription,
                                        String eventDate) {

}
