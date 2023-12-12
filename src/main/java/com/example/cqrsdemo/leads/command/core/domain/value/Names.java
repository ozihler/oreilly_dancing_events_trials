package com.example.cqrsdemo.leads.command.core.domain.value;

import com.example.cqrsdemo.leads.command.Json;

import java.util.List;

public record Names(Name firstName, List<Name> middleNames, Name lastName) {
}