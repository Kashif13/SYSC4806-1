import app.Application;
import app.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes= Application.class)
public class HttpRequestTest {

    @LocalServerPort
    private int port;
    @Mock
    private HttpSession session;

    @Autowired
    private TestRestTemplate restTemplate;
    User u1;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        u1 = new User();
        Mockito.doReturn(u1).when(session).getAttribute("user");
    }

    @Test
    public void indexRequestShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Learning Outcomes Manager");
    }


    @Test
    public void addLearningOutcomeRequestShouldReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/addLearningOutcome",
                String.class)).contains("Add Learning Outcome:");
    }


    @Test
    public void pickCategoryRequestShouldReturnList() throws Exception {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/pickCategory",
                String.class);
        assertThat(response).contains("Filter Learning Outcomes by Category:");
        assertThat(response).contains("Filter Courses by Category:");
    }

    @Test
    public void addCategoryRequestShouldReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/addCategory",
                String.class)).contains("Add Category:");
    }

    @Test
    public void listLearningOutcomesByCategoryRequestShouldReturnList() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/listLearningOutcomesByCategory?id=1",
                String.class)).contains("Learning Outcomes");
    }


    @Test
    public void listCoursesByCategoryRequestShouldReturnList() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/listCoursesByCategory?id=1",
                String.class)).contains("Courses");
    }

    @Test
    public void editLearningOutcomeShouldReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/editLearningOutcome/1",
                String.class)).contains("Update Learning Outcome:");
    }

    @Test
    public void editCategoryShouldReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/editCategory/1",
                String.class)).contains("Update Category:");
    }

    @Test
    public void editCourseReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/editCourse/1",
                String.class)).contains("Update Course:");
    }

    @Test
    public void editProgramReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/editProgram/1",
                String.class)).contains("Update Program:");
    }

    @Test
    public void addCourseShouldReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/newCourse",
                String.class)).contains("Add Course:");
    }

    @Test
    public void addProgramShouldReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/newProgram",
                String.class)).contains("Add Program:");
    }

    @Test
    public void addLearningOutcomeShouldReturnForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/addLearningOutcome",
                String.class)).contains("Add Learning Outcome:");
    }

}