package org.writer.service;

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
            if (clasz.getDeclaredAnnotations().length > 0 && clasz.isAnnotationPresent(ClassLabel.class)) {

                Annotation[] annotatedFields = clasz.getDeclaredAnnotations();

                System.out.println("Annotation[] " + Arrays.toString(annotatedFields));
            }

        }

        return new ArrayList<>();
    }
}
