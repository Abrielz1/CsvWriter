package org.writer.service;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.writer.exception.IllegalCastException;
import org.writer.util.FieldMark;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для создания csv
 */
public class CSVManipulator {

    public void createCSV(List<Object> objects) {
        objects.forEach(i -> {
            List<Field> field = FieldUtils.getFieldsListWithAnnotation(i.getClass(), FieldMark.class);
            List<String> values = new ArrayList<>();
            StringBuilder fileName = new StringBuilder();
            field.forEach(j -> {
                try {
                    j.setAccessible(true);
                    values.add(field.get(field.indexOf(j)).get(i).toString());
                 //   fileName.append(values.stream().map(c-> c.getClass().getSimpleName()).toList().get(0));
                } catch (IllegalAccessException e) {
                    try {
                        throw new IllegalCastException(e.getMessage());
                    } catch (IllegalCastException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            new WritableImpl().writeToFile(
                    values,
                    field.stream().map(Field::getName).collect(Collectors.joining(";")),
                    fileName.toString());
        });
    }
}
