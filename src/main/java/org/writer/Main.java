package org.writer;

import lombok.SneakyThrows;
import net.datafaker.Faker;
import org.writer.service.ClassManipulator;
import org.writer.util.ClassLabel;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {

        Faker faker = new Faker();

        ClassManipulator classManipulator = new ClassManipulator();

        classManipulator.classScanner("org.writer.model",
                (ClassLabel) Class.forName("ClassLabel").getDeclaredConstructor().newInstance());
    }
}