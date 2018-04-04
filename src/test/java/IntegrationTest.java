import app.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
public class IntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LearningOutcomeRepository loRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ProgramRepository progRepo;


    @Test
    public void whenFindByName_thenReturnLearningOutcome() {
        // given
        LearningOutcome lo = new LearningOutcome("Cloud");
        entityManager.persist(lo);
        entityManager.flush();

        // when
        List<LearningOutcome> foundList = loRepo.findByName(lo.getName());
        LearningOutcome found = foundList.get(0);

        // then
        assertThat(found.getName())
                .isEqualTo(lo.getName());
    }

//    @Autowired
//    private TodoRepository repository;
//
//    @Test
//    public void findBySearchTerm_TitleOfFirstTodoEntryContainsGivenSearchTerm_ShouldReturnOneTodoEntry() {
//        List<Todo> searchResults = repository.findBySearchTerm("iTl");
//        assertThat(searchResults).hasSize(1);
//    }
//
//    @Test
//    public void findBySearchTerm_TitleOfFirstTodoEntryContainsGivenSearchTerm_ShouldReturnFirstTodoEntry() {
//        List<Todo> searchResults = repository.findBySearchTerm("iTl");
//
//        Todo found = searchResults.get(0);
//        assertThat(found.getId()).isEqualTo(1L);
//    }
}