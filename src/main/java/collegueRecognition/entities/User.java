package collegueRecognition.entities;


import org.springframework.data.annotation.Id;

import java.util.List;

public class User {

    @Id
    public String id;

    public String userName;
    public String pass;
    public String firstName;
    public String lastName;
    //@TODO: fix parsing these fields during registration
    public byte[] profilePic;
    public String role;
    public String department;
    public String organization;
    public List<String> skills;
    public String shortIntro;
    public String email;
    private boolean rememberMe;
    public List<Vote> votes;

    public User() {}

    public User(String userName, String pass, String firstName, String lastName, String department,
                String organization, String email, String role, String shortIntro,
                List<String> skills, List<Vote> votes) {
        this.userName = userName;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.organization = organization;
        this.email = email;
        this.role = role;
        this.shortIntro = shortIntro;
        this.skills = skills;
        this.votes = votes;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
