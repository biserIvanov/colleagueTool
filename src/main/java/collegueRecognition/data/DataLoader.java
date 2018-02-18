package collegueRecognition.data;

import collegueRecognition.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;


    public void run(ApplicationArguments args) {
        userRepository.deleteAll();
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("JavaScript");
        // save a couple of customers
        userRepository.save(new User("biso", "biso123", "Biser", "Ivanov",
                "Globalization", "biserivanov08@gmail.con", "Software Engineer", "Love sports, music and programming.", skills));
    }
}

