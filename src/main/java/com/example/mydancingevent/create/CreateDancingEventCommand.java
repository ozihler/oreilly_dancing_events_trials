package com.example.mydancingevent.create;

public record CreateDancingEventCommand(String eventOrganizerId, String eventTitle, String eventDescription,
                                        String eventDate) {

}
