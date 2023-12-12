package com.example.cqrsdemo.leads.command;

import com.example.cqrsdemo.leads.command.core.domain.aggregate.Lead;
import com.example.cqrsdemo.leads.command.core.domain.value.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("/command")
public class LeadCommandResource {
    private final LeadRepository leadRepository;

    public LeadCommandResource(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @PostMapping
    public String addLead() throws JsonProcessingException {

        /*

        var first = List.of(
                new DomainEvent(
                        EventType.LEAD_INITIALIZED,
                        null,
                        new PhoneNumbers(List.of(new PhoneNumber("+41796033808"))),
                        LocalDateTime.now().toString())
                ,
                new DomainEvent(
                        EventType.AVAILABLE_SET,
                        new Names(
                                new Name("Oliver"),
                                List.of(new Name("Felix"), new Name("Martin")),
                                new Name("Zihler")
                        ),
                        new PhoneNumbers(List.of(new PhoneNumber("+41796033808"))),
                        LocalDateTime.now().toString()),
                new DomainEvent(
                        EventType.CONTACT_DETAILS_UPDATED,
                        new Names(
                                new Name("Oliver"),
                                List.of(new Name("Felix"), new Name("Martin")),
                                new Name("Zihler")
                        ),
                        new PhoneNumbers(List.of(new PhoneNumber("0796033808"))),
                        LocalDateTime.now().toString())

        );

         */


        var first = List.of(
                new DomainEvent(
                        EventType.CONVERTED,
                        null,
                        null,
                        LocalDateTime.now().toString())


        );

        leadRepository.storeLead(new Lead(
                new LeadId("111a"),
                new ChangeSetId("3"),
                new ChangeSet(first),
                new MetaData("No meta data")
        ));

        return "success";

    }
}
