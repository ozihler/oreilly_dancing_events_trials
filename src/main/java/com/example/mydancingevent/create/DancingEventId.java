package com.example.mydancingevent.create;

import java.util.UUID;

public class DancingEventId {
    private final String value;

    private DancingEventId(String value) {
        this.value = value;
    }

    public static DancingEventId newRandomId() {
        return new DancingEventId(UUID.randomUUID().toString());
    }
}
