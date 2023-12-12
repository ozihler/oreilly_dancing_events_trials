package com.example.cqrsdemo.leads.query;

public record Lead(String aggregateId, String changesetId, Object payload, Object metadata) {
}
