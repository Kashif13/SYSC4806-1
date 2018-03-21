package app;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Faisal on 2018-03-20.
 */
public class CourseController {

    @Autowired
    private CourseRepository courseRepo;

//    @PostMapping("displayCourseForProgram")
//    public String displayCourseForProgram(@ModelAttribute("programs") Program program, BindingResult p, @ModelAttribute("years") int year, BindingResult y, Model m) {
//        List<Course> courses = null;
//        if (p != null && y != null) {
//            Program chosenProgram = program;
//            int chosenYear = year;
//            courses = courseRepo.findByProgram(program);
//        }
//        m.addAttribute(courses);
//        return "courseSelection";
//
//    }

}
