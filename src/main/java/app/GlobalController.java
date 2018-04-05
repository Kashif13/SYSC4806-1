package app;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice
@SessionAttributes(value = "user", types = {User.class})
public class GlobalController {
    @ModelAttribute("user")
    public void addAttributes(Model model) {
        model.addAttribute("user", new User());
    }
}