package collegueRecognition.entities;


import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;

    public String userName;
    public String pass;
    public String firstName;
    public String lastName;

    public String department;
    public String email;

    public User() {}

    public User(String userName, String pass, String firstName, String lastName, String department, String email) {
        this.userName = userName;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
