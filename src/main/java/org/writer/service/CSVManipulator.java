package org.writer.service;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.writer.util.FieldMark;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Класс для создания csv
 */
public class CSVManipulator {

    public void createCSV1(Map<String, Object> objects) {

        objects.forEach((k, v) -> {
            List<Field> field = FieldUtils.getFieldsListWithAnnotation(objects.get(k).getClass(), FieldMark.class);
            List<String> values = new ArrayList<>();
            AtomicReference<String> fileName = new AtomicReference<>();
            AtomicReference<String> head = new AtomicReference<>();
            field.forEach(j -> {

                try {
                    j.setAccessible(true);
                    values.add(field.get(field.indexOf(j)).get(v).toString());
                    fileName.set(k);
                } catch (RuntimeException ex) {
                    throw new RuntimeException(ex);

            } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
            new WritableImpl().writeToFile(values, "", fileName.get());

        });

    }
}
