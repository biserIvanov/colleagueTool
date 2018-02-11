package collegueRecognition;

import collegueRecognition.data.UserRepository;
import collegueRecognition.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
