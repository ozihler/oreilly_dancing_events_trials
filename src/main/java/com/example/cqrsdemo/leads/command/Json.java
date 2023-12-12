package com.example.cqrsdemo.leads.command;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Json {
    public static String toJsonArray(List<String> stringsToConcatenate) {
        return "[" + IntStream.range(0, stringsToConcatenate.size() - 1)
                .mapToObj(i -> stringsToConcatenate.get(i) + ",")
                .collect(joining("", "", stringsToConcatenate.getLast()))
                + "]";
    }
}
