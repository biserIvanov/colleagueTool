package collegueRecognition.controller;

import collegueRecognition.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserInfoController {

    @GetMapping(value = {"/myProfile"})
    public String login(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if(user != null) {
            model.addAttribute("loggedUser", user);
            return "myProfile";
        }
        return "login";
    }
}
