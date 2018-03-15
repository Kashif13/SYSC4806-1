package app;

import app.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import app.ProgramRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        int[] yearsArr = {2015, 2016, 2017, 2018};
        ArrayList years = new ArrayList();
        for(int year : yearsArr) {
            years.add(year);
        }
        model.addAttribute("programs", program.findAll());
        model.addAttribute("years", years);
        return "pickProgramAndYear";
    }
}
