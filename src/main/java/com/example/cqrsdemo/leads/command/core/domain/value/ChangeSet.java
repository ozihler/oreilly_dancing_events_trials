package com.example.cqrsdemo.leads.command.core.domain.value;

import java.util.List;

public record ChangeSet(List<DomainEvent> domainEvents) {
}
