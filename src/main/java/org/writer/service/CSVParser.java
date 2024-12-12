package org.writer.service;

import lombok.RequiredArgsConstructor;
import org.writer.util.Adapter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CSVParser<T> {

    private final Adapter adapter;

    private final Writable writable;

    public void createCSV(T t, String fileName) {


        writable.writeToFile(new ArrayList<>(), fileName);
    }
}






/*
        String[] csvHeader = {"FirstName", "LastName", "DateOfBirth"};
        String[] nameMapping = {"firstName", "lastName", "dateOfBirth"};
        */