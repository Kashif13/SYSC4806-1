package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
    @Autowired
    private CategoryRepository categoryRepo;



    @RequestMapping("/pickCourse")
    public String pickCourse(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        model.addAttribute("courses", courseRepo.findAll());
        return "pickCourse";
    }

    @RequestMapping("/listCourses")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepo.findAll());
        return "listCourses";
    }

    @RequestMapping("/listCoursesByCategory")
    public String listCoursesByCategory(@ModelAttribute("category") Category category, Model model){
        List<LearningOutcome> los = loRepo.findByCategory(category);
        List<Course> courses = new ArrayList<>();
        for(LearningOutcome lo : los)
            courses.add(lo.getCourse());
        model.addAttribute("courses", courses);
        return "listCourses";
    }

    @GetMapping("/newCourse")
    public String newCourse(Model model){
        ArrayList years = new ArrayList();
        for(int i=0; i < AcademicYear.values().length; i++) {
            years.add(AcademicYear.values()[i].toString());
        }
        Course course = new Course();

        model.addAttribute("courseAndYear", new CourseAndYearForm());
        model.addAttribute("course", course);
        model.addAttribute("years", years);
        return "newCourseForm";
    }

    @PostMapping("/createCourse")
    public String createCourse(@ModelAttribute("courseAndYear") CourseAndYearForm course, Model model){
        AcademicYear year = null;
        for(int i=0; i < AcademicYear.values().length; i++) {
            if(AcademicYear.values()[i].toString().equals(course.getYear())){
                year = AcademicYear.values()[i];
            }
        }
        Course currentCourse = course.getCourse();
        currentCourse.setYear(year);

        Course c = courseRepo.save(currentCourse);
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("newCourse", c);
        return "listCourses";
    }

    @PostMapping("/displayLearningOutcomesForCourse")
    public String displayLearningOutcomesForCourse(@ModelAttribute("course")Course course, BindingResult p, Model m) {

        List<LearningOutcome> finalizedListoflearningOutcomes = loRepo.findByCourse(course);
        m.addAttribute("learningOutcomes", finalizedListoflearningOutcomes);
        m.addAttribute("learningOutcome", new LearningOutcome());
        return "displayLearningOutcomesForCourse";
    }

}
