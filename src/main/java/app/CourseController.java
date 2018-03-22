package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Faisal on 2018-03-20.
 */
public class CourseController {
    @Autowired
    private CourseRepository courseRepo;

    @RequestMapping("/listCourses")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepo.findAll());
        return "listCourses";
    }

}
