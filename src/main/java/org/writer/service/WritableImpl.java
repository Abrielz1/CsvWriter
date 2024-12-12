package org.writer.service;

import lombok.RequiredArgsConstructor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class WritableImpl implements Writable {

    public static final String PATH = "output/data.csv";

    @Override
    public void writeToFile(List<?> data, String fileName) {

        if (data == null || data.isEmpty()) {

            return;
        }

        try(FileWriter writer = new FileWriter(fileName != null && !fileName.isBlank() ?
                                                                                  fileName : PATH)) {

            for (Object i : data) {
                writer.write(i + System.lineSeparator());
            }

        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
