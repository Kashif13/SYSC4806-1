package app;

import app.LearningOutcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.LearningOutcomeRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LearningOutcomeController {

    @Autowired
    private LearningOutcomeRepository learningOutcomeRepo;

    @GetMapping("/learningOutcome")
    public String loForm(Model model){
        LearningOutcome learningOutcome = new LearningOutcome("test", "test");
        model.addAttribute("learningOutcome", learningOutcome);
        return "learningOutcome";
    }

    @RequestMapping("/listLearningOutcomes")
    public String listLearningOutcomes(Model model){
        model.addAttribute("learningOutcomes", learningOutcomeRepo.findAll());
        return "listLearningOutcomes";
    }

    @GetMapping("/addLearningOutcome")
    public String learningOutcomeForm(Model model){
        LearningOutcome learningOutcome = new LearningOutcome();
        model.addAttribute("learningOutcome", learningOutcome);
        return "learningOutcomeForm";
    }

    @PostMapping("/addLearningOutcome")
    public String learningOutcomSubmit(@ModelAttribute("learningOutcome") LearningOutcome learningOutcome) {
        learningOutcomeRepo.save(learningOutcome);
        return "loResult";
    }
}
