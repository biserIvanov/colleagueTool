package collegueRecognition.controller;

import collegueRecognition.data.UserRepository;
import collegueRecognition.entities.User;
import collegueRecognition.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class VoteController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = {"/vote"})
    public String vote(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if(user != null) {
            model.addAttribute("loggedUser", user);
            return "vote";
        }
        return "login";
    }

    @PostMapping(value = {"/vote"})
    public String vote(Vote vote, HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if(user != null) {
            User votedForUser = userRepository.findByUserName(vote.getUserName());
            if (votedForUser != null) {
                user.votes.add(vote);
                userRepository.save(user);
                model.addAttribute("loggedUser", user);
                model.addAttribute("userName", vote.userName);
                return "successfulVote";
            } else {
                model.addAttribute("voteResult", "Error!");
                model.addAttribute("message", "The username that you have entered is not valid!");
                model.addAttribute("loggedUser", user);
                return "vote";
            }

        }
        return "login";
    }
}
