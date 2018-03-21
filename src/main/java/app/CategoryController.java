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
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @RequestMapping("/listCategories")
    public String listCategories(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepo.findAll());
        return "listCategories";
    }
}
