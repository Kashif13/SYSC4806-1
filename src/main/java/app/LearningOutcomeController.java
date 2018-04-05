package app;

import app.LearningOutcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.LearningOutcomeRepository;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LearningOutcomeController {

    @Autowired
    private LearningOutcomeRepository learningOutcomeRepo;

    @Autowired
    private ProgramRepository progRepo;


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
        LearningOutcome learningOutcome = new LearningOutcome();
        model.addAttribute("learningOutcome", learningOutcome);
        return "learningOutcomeForm";
    }

    @PostMapping("/addLearningOutcome")
    public String learningOutcomeSubmit(@ModelAttribute("learningOutcome") LearningOutcome learningOutcome, Model model) {
        LearningOutcome lo = learningOutcomeRepo.save(learningOutcome);
        model.addAttribute("learningOutcomes", learningOutcomeRepo.findAll());
        model.addAttribute("newLearningOutcome", lo);
        return "listLearningOutcomes";
    }

    @GetMapping("/editLearningOutcome/{id}")
    public String editLearningOutcome(@PathVariable Long id, Model model){
        LearningOutcome learningOutcome = learningOutcomeRepo.findById(id);
        model.addAttribute("learningOutcome", learningOutcome);
        return "editLearningOutcomeForm";
    }

    @PostMapping("/updateLearningOutcome/{id}")
    public String updateLearningOutcome(@PathVariable Long id, @ModelAttribute("learningOutcome") LearningOutcome learningOutcome, Model model) {
        learningOutcome.setId(id);
        LearningOutcome updatedLearningOutcome = learningOutcomeRepo.save(learningOutcome);
        model.addAttribute("learningOutcomes", learningOutcomeRepo.findAll());
        model.addAttribute("updatedLearningOutcome", updatedLearningOutcome);
        return "listLearningOutcomes";
    }
}
