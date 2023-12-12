package com.example.cqrsdemo.leads.command.core.ports.outbound;

import com.example.cqrsdemo.leads.command.core.domain.aggregate.Lead;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StoreLead {
    Lead storeLead(Lead lead) throws JsonProcessingException;
}
