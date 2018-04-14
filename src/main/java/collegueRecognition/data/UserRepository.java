package collegueRecognition.data;

import collegueRecognition.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUserNameAndPass(String userName, String pass);
    public User findByUserName(String userName);
    public List<User> findAll();
    public List<User> findByUserNameStartsWith(String token);
}
