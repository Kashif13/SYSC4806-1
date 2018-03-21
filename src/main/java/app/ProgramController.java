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
    public String pickProgramAndYearForm(Model model){
        ArrayList years = new ArrayList();
        for(int i=0; i < AcademicYear.values().length; i++) {
            years.add(AcademicYear.values()[i]);
        }
        model.addAttribute("programs", program.findAll());
        model.addAttribute("years", years);
        return "pickProgramAndYear";
    }

    @PostMapping("pickProgramAndYear")
    public String pickProgramAndYear(@ModelAttribute("programs") Program program, BindingResult p, @ModelAttribute("years") int year, BindingResult y){
        if(p != null && y!= null){
            Program chosenProgram = program;
            int chosenYear = year;
        }
        return null;
    }
}
