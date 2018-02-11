package collegueRecognition.controller;

import collegueRecognition.data.UserRepository;
import collegueRecognition.entities.LoginUser;
import collegueRecognition.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/logMeIn")
    public String login(@ModelAttribute LoginUser loginUser) {
        User resultingUser = repository.findByUserNameAndPass(loginUser.getUserName(), loginUser.getPass());
        if(resultingUser != null) {
            return "loggedIn";
        } else {
            loginUser.setUserName("NO SUCH USER");
            loginUser.setPass("NO SUCH PASS");
            return "loggedIn";
        }

    }
}
