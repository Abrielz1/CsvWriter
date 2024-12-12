package org.writer.service;

import lombok.RequiredArgsConstructor;
import net.sf.corn.cps.CPScanner;
import net.sf.corn.cps.ClassFilter;
import net.sf.corn.cps.PackageNameFilter;
import org.writer.util.ClassLabel;
import java.util.List;

@RequiredArgsConstructor
public class ClassManipulator {

    public List<Class<?>> classScanner(String path, ClassLabel annotationName) {

        List<Class<?>> classes = CPScanner.scanClasses(new PackageNameFilter(path),
                new ClassFilter().appendAnnotation(annotationName.getClass()));

        return classes
                .stream()
                .filter(annotation -> annotation.isAnnotationPresent(annotationName.getClass()))
                .toList();
    }
}
