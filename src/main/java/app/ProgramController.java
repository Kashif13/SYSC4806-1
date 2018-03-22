package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProgramController {


    @Autowired
    private ProgramRepository program;

    @RequestMapping("/listPrograms")
    public String listPrograms(Model model){
        model.addAttribute("programs", program.findAll());
        return "listPrograms";
    }

    @GetMapping("/pickProgramAndYear")
    public String pickProgramAndYearForm(ModelMap model){
        ArrayList years = new ArrayList();
        for(int i=0; i < AcademicYear.values().length; i++) {
            years.add(AcademicYear.values()[i]);
        }
        List<Program> programs = program.findAll();


        model.addAttribute("programAndYear", new ProgramAndYearForm());
        model.addAttribute("programs", programs);
        model.addAttribute("years", years);
        return "pickProgramAndYear";
    }

    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private ProgramRepository programRepository;

    @PostMapping("/displayCourseForProgram")
    public String displayCourseForProgram(@ModelAttribute("programAndYear") ProgramAndYearForm programAndYear, BindingResult p, Model m) {
        List<Course> courses;
        List<Course> courses2;
        List<Course> finalizedList = new ArrayList<>();

        List<Program> programs = new ArrayList<>();
        programs.add(programAndYear.getProgram());
        courses = courseRepo.findByProgramsIn(programs);
        courses2 = courseRepo.findByYear(programAndYear.getYear());

        for(int i = 0; i<courses.size(); i++ ){
            if(courses2.contains(courses.get(i))){
                finalizedList.add(courses.get(i));
            }
        }
        m.addAttribute("courses",finalizedList);
        m.addAttribute("course", new Course());
        return "displayCourseForProgram";
    }

}
