package org.writer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.writer.util.ClassLabel;
import org.writer.util.FieldMark;

@Data
@Builder
@ClassLabel
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    /**
     * место в рейтинге
     */
    @FieldMark
    private int place;

    /**
     * имя
     */
    @FieldMark
    private String firstName;

    /**
     * фамилия
     */
    @FieldMark
    private String lastName;

    /**
     * очки
     */
    @FieldMark
    private double score;
}