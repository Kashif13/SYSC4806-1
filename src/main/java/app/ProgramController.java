package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProgramController {


    @Autowired
    private ProgramRepository programRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private LearningOutcomeRepository loRepo;


    @RequestMapping("/listPrograms")
    public String listPrograms(@SessionAttribute("user") User user, Model model){
        model.addAttribute("programs", programRepo.findAll());
        model.addAttribute("user", user);
        return "listPrograms";
    }

    @GetMapping("/pickProgramAndYear")
    public String pickProgramAndYearForm(ModelMap model){
        ArrayList years = new ArrayList();
        for(int i=0; i < AcademicYear.values().length; i++) {
            years.add(AcademicYear.values()[i].toString());
        }
        List<Program> programs = programRepo.findAll();


        model.addAttribute("programAndYear", new ProgramAndYearForm());
        model.addAttribute("programs", programs);
        model.addAttribute("years", years);
        return "pickProgramAndYear";
    }

    @PostMapping("/displayCourseForProgram")
    public String displayCourseForProgram(@SessionAttribute("user") User user, @ModelAttribute("programAndYear") ProgramAndYearForm programAndYear, BindingResult p, Model m) {
        List<Course> courses;
        List<Course> courses2;
        List<Course> finalizedList = new ArrayList<>();

        List<Program> programs = new ArrayList<>();
        programs.add(programAndYear.getProgram());
        AcademicYear year = null;
        for(int i=0; i < AcademicYear.values().length; i++) {
            if(AcademicYear.values()[i].toString().equals(programAndYear.getYear())){
                year = AcademicYear.values()[i];
            }
        }
        courses = courseRepo.findByProgramsIn(programs);

        courses2 = courseRepo.findByYear(year);

        for(int i = 0; i<courses.size(); i++ ){
            if(courses2.contains(courses.get(i))){
                finalizedList.add(courses.get(i));
            }
        }
        m.addAttribute("user", user);
        m.addAttribute("courses",finalizedList);
        m.addAttribute("course", new Course());
        return "displayCourseForProgram";
    }

    @PostMapping("/displayLearningOutcomesForProgram")
    public String displayLearningOutcomesForProgram(@SessionAttribute("user") User user, @ModelAttribute("programAndYear") ProgramAndYearForm programAndYear, BindingResult p, Model m) {
        List<Course> courses;
        List<Course> courses2;
        List<Course> finalizedListofCourses = new ArrayList<>();

        List<Program> programs = new ArrayList<>();
        programs.add(programAndYear.getProgram());
        courses = courseRepo.findByProgramsIn(programs);
        AcademicYear year = null;
        for(int i=0; i < AcademicYear.values().length; i++) {
            if(AcademicYear.values()[i].toString().equals(programAndYear.getYear())){
                year = AcademicYear.values()[i];
            }
        }
        courses2 = courseRepo.findByYear(year);
        for(int i = 0; i<courses.size(); i++ ){
            if(courses2.contains(courses.get(i))){
                finalizedListofCourses.add(courses.get(i));
            }
        }
        List<LearningOutcome> finalizedListoflearningOutcomes = new ArrayList<>();
        for(Course c : finalizedListofCourses){
            for(LearningOutcome lo: loRepo.findByCourse(c)){
                finalizedListoflearningOutcomes.add(lo);
            }
        }

        m.addAttribute("user", user);
        m.addAttribute("learningOutcomes", finalizedListoflearningOutcomes);
        m.addAttribute("learningOutcome", new LearningOutcome());
        return "displayLearningOutcomesForProgram";
    }

    @GetMapping("/newProgram")
    public String newProgram(Model model){
        Program program = new Program();
        model.addAttribute("program", program);
        return "newProgramForm";
    }

    @PostMapping("/createProgram")
    public String createProgram(@ModelAttribute("program") Program program, Model model) {
        Program newProgram = programRepo.save(program);
        model.addAttribute("programs", programRepo.findAll());
        model.addAttribute("newProgram", newProgram);
        return "listPrograms";
    }

    @GetMapping("/editProgram/{programId}")
    public String editProgram(@PathVariable Long programId, Model model){
        Program program = programRepo.findOne(programId);
        model.addAttribute("program", program);
        return "editProgramForm";
    }

    @PostMapping("/updateProgram/{programId}")
    public String updateProgram(@PathVariable Long programId, @ModelAttribute("program") Program program, Model model) {
        program.setId(programId);
        Program updatedProgram = programRepo.save(program);
        model.addAttribute("programs", programRepo.findAll());
        model.addAttribute("updatedProgram", updatedProgram);
        return "listPrograms";
    }

}
