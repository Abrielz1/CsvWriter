package org.writer;

import lombok.SneakyThrows;
import org.writer.model.Person;
import org.writer.model.Scores;
import org.writer.model.Student;
import org.writer.service.CSVParser;
import org.writer.service.ClassManipulator;
import org.writer.service.Manipulator;
import org.writer.service.Writable;
import org.writer.service.WritableImpl;
import org.writer.util.Adapter;
import org.writer.util.ClassLabel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);

        Person person1 = Person
                         .builder()
                .age(18)
                .firstName("name")
                .lastName("last")
                .dateOfBirth(LocalDate.now().minusYears(15))
                .build();

        Person person2 = Person
                .builder()
                .age(12)
                .firstName("name2")
                .lastName("last2")
                .dateOfBirth(LocalDate.now().minusYears(17))
                .build();

        Student student1 = Student
                .builder()
                .place(1)
                .firstName("name")
                .lastName("surename")
                .score(25.9d)
                .build();

        Scores scores1 = Scores
                .builder()
                .scores(list)
                .build();

        ClassManipulator classManipulator = new ClassManipulator();

        Manipulator<Object> manipulator = new Manipulator<>();

     var res = manipulator.manipulate(classManipulator.classScanner("org.writer.model",
                ClassLabel.class));


        Adapter adapter = new Adapter();
        Writable writable = new WritableImpl();
        CSVParser csvParser = new CSVParser<>(writable, adapter);
        csvParser.createCSV(res, List.of(person1, student1, scores1, person2));
    }
}