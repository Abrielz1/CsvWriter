package org.writer.service;

import lombok.RequiredArgsConstructor;
import org.writer.model.Person;
import org.writer.model.Scores;
import org.writer.model.Student;
import org.writer.util.Adapter;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class CSVParser<T> {

    private final Writable writable;

    private final Adapter adapter;

    public void createCSV(Map<String, List<Field>> map, List<T> entities) {

        List<String> result = new ArrayList<>();
        List<Field> temp = new ArrayList<>();

        if ((entities == null || entities.isEmpty())
                && (map == null || map.isEmpty())) {

            return;
        }

        for (T entity : entities) {

            String head = "";

            StringBuilder sb = new StringBuilder();

            System.out.println("Class " + entity.getClass());

            if (entity.getClass().getSimpleName().equals("Person")) {

                Field age = null;
                Field firstName = null;
                Field lastName = null;
                Field dateOfBirth = null;

                temp = map.get(entity.getClass().getSimpleName());

                try {

                    age = Person.class.getDeclaredField("age");
                    firstName = Person.class.getDeclaredField("firstName");
                    lastName = Person.class.getDeclaredField("lastName");
                    dateOfBirth = Person.class.getDeclaredField("dateOfBirth");

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                sb.append(this.extractor(result, temp, entity, age)).append(";");

                sb.append(this.extractor(result, temp, entity, firstName)).append(";");

                sb.append(this.extractor(result, temp, entity, lastName)).append(";");

                sb.append(this.extractor(result, temp, entity, dateOfBirth)).append(";");

                System.out.println("toFile!");
                head = sb.toString();
                System.out.println();
                System.out.println("Head: " + head);
                writable.writeToFile(result, head, entity.getClass().getSimpleName());
            }

            if (entity.getClass().getSimpleName().equals("Student")) {

                Student student = (Student) entity;
                System.out.println("student: " + student);
                writable.writeToFile(result, head, entity.getClass().getSimpleName());
            }

            if (entity.getClass().getSimpleName().equals("Scores")) {

                Scores scores = (Scores) entity;
                System.out.println("scores: " + scores);
                writable.writeToFile(result, head, entity.getClass().getSimpleName());
            }
        }
    }

    private String extractor(List<String> result, List<Field> temp, T entity, Field age) {

        String nameField = "";

        if (temp.contains(age)) {
            Field field = temp.get(temp.indexOf(age));
            Object value = null;
            field.setAccessible(true);

            try {
                value = field.get(entity);
                nameField = field.getName();
                System.out.println("Type: " + field.getType().getName());
                System.out.println("Type: " + field.getType().getSimpleName());

                if (field.get(entity).getClass().getSimpleName().equals("LocalDate")) {
                   value = adapter.dateOfBirthConverter((LocalDate) value);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            result.add(String.valueOf(value));

            return nameField;
        }

        return nameField;
    }
}