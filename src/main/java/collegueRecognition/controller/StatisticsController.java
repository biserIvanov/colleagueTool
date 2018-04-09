package collegueRecognition.controller;

import collegueRecognition.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class StatisticsController {

    @GetMapping(value = {"/statistics"})
    public String statistics(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if(user != null) {
            model.addAttribute("loggedUser", user);
            ArrayList<String> names = new ArrayList<>();
            names.add("biso");
            names.add("ivan");
            names.add("martin");
            names.add("dragan");
            names.add("petkan");
            names.add("niki");
            ArrayList<Integer> votes = new ArrayList<>();
            votes.add(12);
            votes.add(10);
            votes.add(7);
            votes.add(7);
            votes.add(4);
            votes.add(1);
            model.addAttribute("names", names);
            model.addAttribute("votes", votes);
            return "statistics";
        }
        return "login";
    }
}
