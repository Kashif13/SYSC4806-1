package app;

import app.LearningOutcome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(collectionResourceRel="learningOutcomes", path ="learningOutcomes")
public interface LearningOutcomeRepository extends CrudRepository<LearningOutcome, Long> {
    List<LearningOutcome> findByName(String name);
    List<LearningOutcome> findByProgram (Program program);
    List<LearningOutcome> findByCategory (Category category);
}