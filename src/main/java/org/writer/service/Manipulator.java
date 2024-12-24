package org.writer.service;

import lombok.SneakyThrows;
import java.util.Arrays;
import java.util.List;

/**
 * Класс для поиска и фильтрации полей в классах помеченных аннотацией FieldLabel
 * @param <T> универсальный тип
 */
public class Manipulator<T> {

    @SneakyThrows
    public List<Object> manipulate(List<Class<?>> classes, Object... objects) {

        return Arrays
                .stream(objects)
                .filter(i->classes.contains(i.getClass()))
                .toList();
    }
}
