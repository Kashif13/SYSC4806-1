package app;

import app.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import app.ProgramRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Year;
import java.util.ArrayList;

@Controller
public class ProgramController {

    int NUMBER_OF_PREVIOUS_YEARS = 3;

    @Autowired
    private ProgramRepository program;

    @RequestMapping("/listPrograms")
    public String listPrograms(Model model){
        model.addAttribute("programs", program.findAll());
        return "listPrograms";
    }

    @GetMapping("/pickProgramAndYear")
    public String pickProgramAndYearForm(Model model){
        ArrayList years = new ArrayList();
        int year;
        for(int i=0; i < NUMBER_OF_PREVIOUS_YEARS; i++) {
            year = Year.now().getValue()-i;
            years.add(year);
        }
        model.addAttribute("programs", program.findAll());
        model.addAttribute("years", years);
        return "pickProgramAndYear";
    }
}
