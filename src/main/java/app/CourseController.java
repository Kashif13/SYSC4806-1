package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Faisal on 2018-03-20.
 */
@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private LearningOutcomeRepository loRepo;

    @RequestMapping("/listCourses")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepo.findAll());
        return "listCourses";
    }
    @GetMapping("/addNewCourse")
    public String newCourseForm(Model model){
        Course course= new Course();
        model.addAttribute("course", course);
        return "newCourseForm";
    }

    @PostMapping("/displayLearningOutcomesForCourse")
    public String displayLearningOutcomesForCourse(@ModelAttribute("course")Course course, BindingResult p, Model m) {

        List<LearningOutcome> finalizedListoflearningOutcomes = loRepo.findByCourse(course);
        m.addAttribute("learningOutcomes", finalizedListoflearningOutcomes);
        m.addAttribute("learningOutcome", new LearningOutcome());
        return "displayLearningOutcomesForCourse";
    }

}
