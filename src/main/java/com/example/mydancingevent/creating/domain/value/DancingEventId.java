package com.example.mydancingevent.creating.domain.value;

import java.util.UUID;

public record DancingEventId(String value){
    public static DancingEventId newRandomId() {
        return new DancingEventId(UUID.randomUUID().toString());
    }

}