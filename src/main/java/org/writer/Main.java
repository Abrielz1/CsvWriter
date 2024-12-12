package org.writer;

import lombok.SneakyThrows;
import org.writer.model.Person;
import org.writer.service.ClassManipulator;
import org.writer.service.Manipulator;
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
                (ClassLabel) Class.forName("ClassLabel").getDeclaredConstructor().newInstance()), person1);


    }
}