package org.writer.service;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.writer.util.ClassLabel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manipulator<T> {

    public List<T> manipulate(List<Class<?>> classes, T t) {

        List<T> clasList = new ArrayList<>();

        for (Class<?> getClass : classes) {
            Class clasz = getClass;

           var fields = clasz.getDeclaredFields();

            System.out.println("Fields[]: " + fields);

            System.out.println("Field: " + fields[0]);

        }

        return new ArrayList<>();
    }
}
