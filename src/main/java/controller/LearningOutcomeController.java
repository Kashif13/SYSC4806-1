package controller;

import com.LearningOutcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.LearningOutcomeRepository;

@Controller
public class LearningOutcomeController {

    @Autowired
    private LearningOutcomeRepository learningOutcome;

    @GetMapping("/learningOutcome")
    public String loForm(Model model){
        LearningOutcome learningOutcome = new LearningOutcome("test", "test");
        model.addAttribute("learningOutcome", learningOutcome);
        return "learningOutcome";
    }



}
