package org.writer.service;

import lombok.RequiredArgsConstructor;
import net.sf.corn.cps.CPScanner;
import net.sf.corn.cps.ClassFilter;
import net.sf.corn.cps.PackageNameFilter;
import java.util.List;

/**
 * класс для поиска и отсева классов не помеченных аннотацией @ClassLabel
 */
@RequiredArgsConstructor
public class ClassManipulator {

    public List<Class<?>> classScanner(String path, Class classLabel) {

        List<Class<?>> classes = CPScanner.scanClasses(new PackageNameFilter(path),
                new ClassFilter().appendAnnotation(classLabel));

        return classes
                .stream()
                .filter(annotation -> annotation.isAnnotationPresent(classLabel))
                .toList();
    }
}
