package app;

import app.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import app.ProgramRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProgramController {

    @Autowired
    private ProgramRepository program;

    @RequestMapping("/listPrograms")
    public String listPrograms(Model model){
        model.addAttribute("programs", program.findAll());
        return "listPrograms";
    }
}
