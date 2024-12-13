package org.writer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.writer.util.ClassLabel;
import org.writer.util.FieldMark;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@ClassLabel
@EqualsAndHashCode
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
