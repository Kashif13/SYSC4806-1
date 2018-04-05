package app;

import lombok.Data;

@Data
public class CourseAndYearForm {

    private Course course;
    private String year;

    /**
     * Default constructor
     */
    public CourseAndYearForm() {}
}
