package org.writer.service;

import lombok.RequiredArgsConstructor;
import org.writer.util.Adapter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CSVParser<T> {

    private final Adapter adapter;

    private final Writable writable;

    public void createCSV(T t) {


        writable.writeToFile(new ArrayList<>(), "");
    }
}






/*
        String[] csvHeader = {"FirstName", "LastName", "DateOfBirth"};
        String[] nameMapping = {"firstName", "lastName", "dateOfBirth"};
        */