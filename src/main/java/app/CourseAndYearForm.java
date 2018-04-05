package app;

import lombok.Data;

@Data
public class CourseAndYearForm {

    private Course course;
    private String year;
    private String program;

    /**
     * Default constructor
     */
    public CourseAndYearForm() {}
}
