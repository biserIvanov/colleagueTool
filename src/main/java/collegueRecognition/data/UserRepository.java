package collegueRecognition.data;

import collegueRecognition.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public User findByUserNameAndPass(String userName, String pass);
}
