package org.writer.service;

import lombok.SneakyThrows;
import java.util.List;

/**
 * Класс для поиска и фильтрации полей в классах помеченных аннотацией FieldLabel
 * @param <T> универсальный тип
 */
public class Manipulator<T> {

    @SneakyThrows
    public List<Object> manipulate(List<Class<?>> classes, List<Object> objects) {

        return objects.stream()
                .filter(i->classes.contains(i.getClass()))
                .toList();
    }
}
