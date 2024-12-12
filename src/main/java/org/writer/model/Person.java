package org.writer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.writer.util.ClassLabel;
import org.writer.util.FieldMark;
import java.time.LocalDate;

@Data
@Builder
@ClassLabel
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @FieldMark
    private int age;

    @FieldMark
    private String firstName;

    @FieldMark
    private String lastName;

    @FieldMark
    private LocalDate dateOfBirth;
}
