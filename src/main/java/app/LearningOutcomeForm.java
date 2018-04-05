package app;

import lombok.Data;

import java.util.Collection;

@Data
public class LearningOutcomeForm {

    private LearningOutcome learningOutcome;
    private Course course;
    private Category category;

    public LearningOutcomeForm() { }
}
