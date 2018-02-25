package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Faisal on 2018-02-25.
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String home(Model model){
        return "index";
    }
}
