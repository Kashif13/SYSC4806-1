package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String Home(ModelMap model){
        return "login";
    }

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public String HomePage(ModelMap model){
        return "index";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String Login(ModelMap model){
        return "login";
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginForm(HttpSession session, @ModelAttribute("user") User user, Model model) {
        User u = userRepo.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        session.setAttribute("user", user);

        try {
            if (u != null) {
                return "index";
            }
        } catch (Exception e) {
            return "error";
        }
        return "error";
    }
}



