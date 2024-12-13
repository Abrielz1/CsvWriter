package org.writer.service;

import lombok.RequiredArgsConstructor;
import org.writer.model.Person;
import org.writer.model.Scores;
import org.writer.model.Student;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class CSVParser<T> {

    private final Writable writable;

    public void createCSV(Map<String, List<Field>> map, List<T> entities) {

        List<String> result = new ArrayList<>();
        List<Field> temp = new ArrayList<>();

        if ((entities == null || entities.isEmpty())
                && (map == null || map.isEmpty())) {

            return;
        }

        for (T entity : entities) {

            System.out.println("Class " + entity.getClass());

            if (entity.getClass().getSimpleName().equals("Person")) {

                Field age;
                Field firstName;
                Field lastName;
                Field dateOfBirth;

                temp = map.get(entity.getClass().getSimpleName());
                try {

                    age = Person.class.getDeclaredField("age");
                    firstName = Person.class.getDeclaredField("firstName");
                    lastName = Person.class.getDeclaredField("lastName");
                    dateOfBirth = Person.class.getDeclaredField("dateOfBirth");

                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }

                this.extractor(result, temp, entity, age);

                this.extractor(result, temp, entity, firstName);

                this.extractor(result, temp, entity, lastName);

                this.extractor(result, temp, entity, dateOfBirth);
            }

            if (entity.getClass().getSimpleName().equals("Student")) {

                Student student = (Student) entity;
                System.out.println("student: " + student);
            }

            if (entity.getClass().getSimpleName().equals("Scores")) {

                Scores scores = (Scores) entity;
                System.out.println("scores: " + scores);
            }


            System.out.println("toFile!");
            writable.writeToFile(result, "" + entity.getClass().getSimpleName());
        }
    }

    private void extractor(List<String> result, List<Field> temp, T o, Field age) {

        if (temp.contains(age)) {
            Field field = temp.get(temp.indexOf(age));
            Object value = null;
            field.setAccessible(true);

            try {
                value = field.get(o);
                System.out.println("Type: " + field.getType().getName());
                System.out.println("Type: " + field.getType().getSimpleName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            result.add(String.valueOf(value));
        }
    }
}