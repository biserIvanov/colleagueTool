package collegueRecognition.controller;

import collegueRecognition.data.UserRepository;
import collegueRecognition.entities.User;
import collegueRecognition.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class StatisticsController {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = {"/statistics"})
    public String statistics(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if(user != null) {
            List<User> allUsers = repository.findAll();
            List<Vote> allVotes = new ArrayList<>();
            allUsers.forEach(user1 -> allVotes.addAll(user1.votes));
            Map<String, Integer> sorted = new LinkedHashMap<>();

            allVotes.forEach(vote -> {
                if(sorted.containsKey(vote.getUserName())) {
                    sorted.put(vote.getUserName(), sorted.get(vote.getUserName()) + 1);    // very bad thing - sorting should happen in the query
                } else sorted.put(vote.getUserName(), 1);
            });



            model.addAttribute("names", sorted.keySet());
            model.addAttribute("votes", sorted.values());
            model.addAttribute("loggedUser", user);
            return "statistics";
        }
        return "login";
    }
}
