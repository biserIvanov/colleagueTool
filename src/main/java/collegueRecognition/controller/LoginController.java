package collegueRecognition.controller;

import collegueRecognition.data.UserRepository;
import collegueRecognition.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if(user != null) {
            model.addAttribute("loggedUser", user);
            return "loggedIn";
        }
        return "login";
    }

    @PostMapping("/logMeIn")
    public String login(@ModelAttribute User user, Model model, HttpServletRequest request) {
        User resultingUser = repository.findByUserNameAndPass(user.getUserName(), user.getPass());
        if(resultingUser != null) {
            request.getSession().setAttribute("loggedUser", resultingUser);
            model.addAttribute("loggedUser", resultingUser);
            return "loggedIn";
        } else {
            model.addAttribute("loginResult", "Error!");
            model.addAttribute("message", "The username or password that you have entered is not valid!");
            return "login";
        }
    }
}
