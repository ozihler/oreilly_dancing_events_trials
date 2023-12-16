package com.example.mydancingevent.create.application.port;

public record CreateDancingEventCommand(String eventOrganizerId,
                                        String eventTitle,
                                        String eventDescription,
                                        String eventDate) {

}
