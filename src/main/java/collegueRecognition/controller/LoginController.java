package collegueRecognition.controller;

import collegueRecognition.entities.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/logMeIn")
    public String login(@ModelAttribute LoginUser loginUser) {
        return "loggedIn";
    }
}
