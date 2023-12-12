package com.example.cqrsdemo.leads.query;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController("/")
public class LeadQueryResource {
    private final JdbcTemplate client;

    public LeadQueryResource(JdbcTemplate client) {
        this.client = client;
    }

    @GetMapping
    public TreeMap<String, Object> helloWorld() {

        var values = new TreeMap<String, Object>();

        return client.query("select * from changes_view", (row, rowNum) -> {

                    var leadId = row.getString("lead_id");

                    List<Object> valuesForLeadId = (List<Object>) values.getOrDefault(leadId, new ArrayList<>());
                    valuesForLeadId.add(
                            Map.of(
                                    "events", Arrays.stream((String[]) row.getArray("events").getArray()).map(LeadQueryResource::fix).toList()));


                    values.put(leadId, valuesForLeadId);
                    return values;
                }
        ).get(0);
    }

    private static String fix(String firstname) {
        return firstname != null ? firstname.replace("\"", "").trim() : "";
    }
}
