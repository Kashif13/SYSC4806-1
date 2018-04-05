package app;

import app.LearningOutcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.LearningOutcomeRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LearningOutcomeController {

    @Autowired
    private LearningOutcomeRepository learningOutcomeRepo;

    @Autowired
    private ProgramRepository progRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CategoryRepository categoryRepo;


    @GetMapping("/learningOutcome")
    public String loForm(Model model){
        LearningOutcome learningOutcome = new LearningOutcome("test", "test");
        model.addAttribute("learningOutcome", learningOutcome);
        return "learningOutcome";
    }

    @RequestMapping("/listLearningOutcomes")
    public String listLearningOutcomes(@SessionAttribute("user") User user, Model model){
        model.addAttribute("learningOutcomes", learningOutcomeRepo.findAll());
        model.addAttribute("user", user);
        return "listLearningOutcomes";
    }

    @RequestMapping("/listLearningOutcomesByCategory")
    public String listLearningOutcomesByCategory(@ModelAttribute("category") Category category, Model model){
        model.addAttribute("learningOutcomes", learningOutcomeRepo.findByCategory(category));
        return "listLearningOutcomes";
    }

    @RequestMapping("/listLearningOutcomesByCourse")
    public String listLearningOutcomesByCourse(@ModelAttribute("course") Course course, Model model){
        model.addAttribute("learningOutcomes", learningOutcomeRepo.findByCourse(course));
        return "listLearningOutcomes";
    }

    @GetMapping("/addLearningOutcome")
    public String learningOutcomeForm(Model model){

        LearningOutcomeForm learningOutcomeForm = new LearningOutcomeForm();

        List<Course> courses = courseRepo.findAll();
        List<Category> categories = categoryRepo.findAll();

        model.addAttribute("learningOutcomeForm", learningOutcomeForm);
        model.addAttribute("courses", courses);
        model.addAttribute("categories", categories);

        return "learningOutcomeForm";
    }

    @PostMapping("/addLearningOutcome")
    public String learningOutcomeSubmit(@ModelAttribute("learningOutcomeForm") LearningOutcomeForm learningOutcomeForm, Model model) {

        LearningOutcome lo = learningOutcomeForm.getLearningOutcome();
        lo.setCourse(learningOutcomeForm.getCourse());
        lo.setCategory(learningOutcomeForm.getCategory());
        LearningOutcome newLearningOutcome = learningOutcomeRepo.save(lo);

        model.addAttribute("learningOutcomes", learningOutcomeRepo.findAll());
        model.addAttribute("newLearningOutcome", newLearningOutcome);

        return "listLearningOutcomes";
    }

    @GetMapping("/editLearningOutcome/{id}")
    public String editLearningOutcome(@PathVariable Long id, Model model){

        LearningOutcomeForm learningOutcomeForm = new LearningOutcomeForm();
        LearningOutcome lo = learningOutcomeRepo.findOne(id);
        Long courseId = lo.getCourse().getId();
        Long categoryId = lo.getCategory().getId();

        learningOutcomeForm.setLearningOutcome(lo);
        learningOutcomeForm.setCourse(lo.getCourse());
        learningOutcomeForm.setCategory(lo.getCategory());

        List<Course> courses = courseRepo.findAll();
        List<Category> categories = categoryRepo.findAll();

        model.addAttribute("learningOutcomeForm", learningOutcomeForm);
        model.addAttribute("courses", courses);
        model.addAttribute("categories", categories);
        model.addAttribute("courseId", courseId);
        model.addAttribute("categoryId", categoryId);


        return "editLearningOutcomeForm";
    }

    @PostMapping("/updateLearningOutcome/{id}")
    public String updateLearningOutcome(@PathVariable Long id, @ModelAttribute("learningOutcomeForm") LearningOutcomeForm learningOutcomeForm, Model model) {
        LearningOutcome learningOutcome = learningOutcomeForm.getLearningOutcome();
        learningOutcome.setId(id);
        learningOutcome.setCourse(learningOutcomeForm.getCourse());
        learningOutcome.setCategory(learningOutcomeForm.getCategory());
        LearningOutcome updatedLearningOutcome = learningOutcomeRepo.save(learningOutcome);
        model.addAttribute("learningOutcomes", learningOutcomeRepo.findAll());
        model.addAttribute("updatedLearningOutcome", updatedLearningOutcome);
        return "listLearningOutcomes";
    }
}
