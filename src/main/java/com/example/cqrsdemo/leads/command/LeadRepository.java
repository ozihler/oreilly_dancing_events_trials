package com.example.cqrsdemo.leads.command;

import com.example.cqrsdemo.leads.command.core.domain.aggregate.Lead;
import com.example.cqrsdemo.leads.command.core.ports.outbound.StoreLead;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Repository
public class LeadRepository implements StoreLead {
    private JdbcTemplate jdbcTemplate;


    public LeadRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Lead storeLead(Lead lead) throws JsonProcessingException {

        var objectMapper = new ObjectMapper();

        jdbcTemplate.execute("INSERT INTO lead(lead_id, changeset_id, payload, metadata) VALUES ('%s', '%s', array['%s']::json[], '%s')".formatted(
                lead.getLeadId().value(),
                lead.getChangeSetId().value(),
                lead.getPayLoad().domainEvents().stream().map(e -> {
                    try {
                        return objectMapper.writeValueAsString(e);
                    } catch (JsonProcessingException ex) {
                        throw new RuntimeException(ex);
                    }
                }).collect(joining("','")),
                objectMapper.writeValueAsString(lead.getMetaData().value())));
        return lead;
    }
}
