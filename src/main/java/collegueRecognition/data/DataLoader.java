package collegueRecognition.data;

import collegueRecognition.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;


    public void run(ApplicationArguments args) {
        System.out.println("#######################");
        userRepository.deleteAll();

        // save a couple of customers
        userRepository.save(new User("biso", "biso123", "Biser", "Ivanov",
                "Globalization", "biserivanov08@gmail.con"));
    }
}

