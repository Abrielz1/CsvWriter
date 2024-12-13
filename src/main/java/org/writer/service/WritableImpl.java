package org.writer.service;

import lombok.RequiredArgsConstructor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class WritableImpl implements Writable {

    private static final String PATH = "output/";

    private static final String END = ".csv";

    private static final String FILE = "data.csv";

    @Override
    public void writeToFile(List<?> data, String fileName) {

        if (data == null || data.isEmpty()) {

            return;
        }

        try(FileWriter writer = new FileWriter(fileName != null && !fileName.isBlank() ?

                                                                                 PATH + fileName + END : PATH + FILE)) {
            System.out.println("begin");
            for (Object i : data) {
                writer.write(i + System.lineSeparator());
            }

            System.out.println("done!");
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
