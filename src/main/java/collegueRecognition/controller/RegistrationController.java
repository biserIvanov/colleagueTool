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
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if(user != null) {
            model.addAttribute("loggedUser", user);
            return "loggedIn";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model, HttpServletRequest request) {
        try {
            userRepository.save(user);

            User resultingUser = userRepository.findByUserNameAndPass(user.getUserName(), user.getPass());

            request.getSession().setAttribute("loggedUser", resultingUser);
            model.addAttribute("loggedUser", resultingUser);
            return "loggedIn";
        } catch(Exception e) {
            model.addAttribute("registerResult", "Error!");
            model.addAttribute("message", "Something went wrong with your registration. " +
                    "Please try again later");
            return "register";
        }
    }
}
