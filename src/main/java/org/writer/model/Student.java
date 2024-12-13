package org.writer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.writer.util.ClassLabel;
import org.writer.util.FieldMark;

@Data
@Builder
//@ClassLabel
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @FieldMark
    private int place;

    @FieldMark
    private String firstName;

    @FieldMark
    private String lastName;

    @FieldMark
    private double score;
}