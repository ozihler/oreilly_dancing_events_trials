package com.example.cqrsdemo.leads.command.core.domain.value;

public record DomainEvent(
        EventType eventType,
        Names names,
        PhoneNumbers phoneNumbers,
        String timestamp) {
}
