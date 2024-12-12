package org.writer;

import lombok.SneakyThrows;
import org.writer.model.Person;
import org.writer.service.CSVParser;
import org.writer.service.ClassManipulator;
import org.writer.service.Manipulator;
import org.writer.service.Writable;
import org.writer.service.WritableImpl;
import org.writer.util.Adapter;
import org.writer.util.ClassLabel;
import java.time.LocalDate;
import java.util.List;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {

        Person person1 = Person
                         .builder()
                .age(18)
                .firstName("name")
                .lastName("last")
                .dateOfBirth(LocalDate.now().minusYears(15))
                .build();

        ClassManipulator classManipulator = new ClassManipulator();

        Manipulator manipulator = new Manipulator<>();

      manipulator.manipulate(classManipulator.classScanner("org.writer.model",
                ClassLabel.class), person1);


        Adapter adapter = new Adapter();
        Writable writable = new WritableImpl();
      //  CSVParser csvParser = new CSVParser<>(adapter, writable);
    }
}