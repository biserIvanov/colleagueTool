package collegueRecognition.data;

import collegueRecognition.entities.User;
import collegueRecognition.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;


    public void run(ApplicationArguments args) {
        userRepository.deleteAll();

        List<String> bisoSkills = new ArrayList<>();
        bisoSkills.add("Java");
        bisoSkills.add("JavaScript");

        List<Vote> bisoVotes = new ArrayList<>();
        bisoVotes.add(new Vote("ivan", "Very helpful!"));
        bisoVotes.add(new Vote("dragan", "Keeps it real!"));
        bisoVotes.add(new Vote("martin", "Keeps it real!"));
        bisoVotes.add(new Vote("georgi", "Keeps it real!"));
        bisoVotes.add(new Vote("martin", "Keeps it real!"));
        bisoVotes.add(new Vote("martin", "Keeps it real!"));
        bisoVotes.add(new Vote("martin", "Keeps it real!"));
        bisoVotes.add(new Vote("martin", "Keeps it real!"));

        // save a couple of customers
        userRepository.save(new User("biso", "biso123", "Biser", "Ivanov",
                "Globalization", "Trading 212", "biserivanov08@gmail.con", "Software Engineer", "Love sports, music and programming.", bisoSkills, bisoVotes));

        List<String> ivanSkills = new ArrayList<>();
        ivanSkills.add("Java");
        ivanSkills.add("CSS");
        ivanSkills.add("HTML");

        List<Vote> ivanVotes = new ArrayList<>();
        ivanVotes.add(new Vote("dragan", "Keeps it real!"));
        ivanVotes.add(new Vote("biso", "Keeps it real!"));
        ivanVotes.add(new Vote("dragan", "Keeps it real!"));
        ivanVotes.add(new Vote("martin", "Keeps it real!"));
        ivanVotes.add(new Vote("dragan", "Keeps it real!"));

        // save a couple of customers
        userRepository.save(new User("ivan", "ivan123", "Ivan", "Ivanov",
                "Globalization", "Trading 212", "ivanivanov08@gmail.con", "Senior Software Engineer", "Love sports, music, programming and rakia.", ivanSkills, ivanVotes));

        userRepository.save(new User("dragan", "dragan123", "Dragan", "Ivanov",
                "Globalization", "Trading 212", "draganivanov08@gmail.con", "Senior Software Engineer", "Loves rakia.", ivanSkills, bisoVotes));

        userRepository.save(new User("martin", "martin123", "Martin", "Ivanov",
                "Globalization", "Trading 212", "martinivanov08@gmail.con", "Senior Software Engineer", "Loves rakia.", ivanSkills, ivanVotes));

        userRepository.save(new User("georgi", "georgi123", "Georgi", "Ivanov",
                "Globalization", "Trading 212", "georgiivanov08@gmail.con", "Senior Software Engineer", "Loves rakia.", ivanSkills, ivanVotes));
    }
}

