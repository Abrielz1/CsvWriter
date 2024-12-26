package org.writer.service;

import lombok.RequiredArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * класс для записи csv файла
 */
@RequiredArgsConstructor
public class WritableImpl implements Writable {

    private static final String PATH = "output/";

    private static final String END = ".csv";

    private static final String FILE = "data.csv";

    /**
     * Метод для записи на диск csv файла
     * @param data список сущностей для записи
     * @param head заголовок
     * @param fileName имя файла для записи
     */
    @Override
    public void writeToFile(List<?> data, String head, String fileName) {


        if (data == null || data.isEmpty()) {
            System.out.println("file empty");
            return;
        }

        try(FileWriter writer = new FileWriter(fileName != null && !fileName.isBlank() ?

                                                                                 PATH + fileName + END : PATH + FILE, true)) {

      //      writer.append(head);
      //      writer.append(System.lineSeparator());

            for (Object i : data) {

                writer.append(i.toString()).append(";");
            }

            writer.append(System.lineSeparator());
            writer.flush();

        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
