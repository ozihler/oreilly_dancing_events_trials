package com.example.mydancingevent.create.application.usecase;

public record CreateDancingEventCommand(String eventOrganizerId, String eventTitle, String eventDescription,
                                        String eventDate) {

}
