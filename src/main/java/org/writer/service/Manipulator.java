package org.writer.service;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.writer.util.FieldMark;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manipulator<T> {

    public Map<String, List<Field>> manipulate(List<Class<?>> classes) {

       Map<String, List<Field>> result = new HashMap<>();

        for (Class<?> getClass : classes) {
            Class<?> clasz = getClass;

             result.put(clasz.getSimpleName(), FieldUtils.getFieldsListWithAnnotation(getClass, FieldMark.class));
        }

        return result;
    }
}
